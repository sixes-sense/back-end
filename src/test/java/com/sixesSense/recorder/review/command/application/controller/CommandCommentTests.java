package com.sixesSense.recorder.review.command.application.controller;

import com.sixesSense.recorder.review.command.application.controller.object.TestObjects;
import com.sixesSense.recorder.review.command.application.dto.comment.request.CreateCommentRequest;
import com.sixesSense.recorder.review.command.application.dto.comment.response.CreateCommentResponse;
import com.sixesSense.recorder.review.command.application.dto.comment.response.UpdateCommentResponse;
import com.sixesSense.recorder.review.command.application.service.CommandCommentServiceImpl;
import com.sixesSense.recorder.review.command.application.service.CommandReviewServiceImpl;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Comment;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.repository.CommentRepository;
import com.sixesSense.recorder.review.command.domain.repository.ReviewRepository;
import com.sixesSense.recorder.review.query.application.dto.response.ReadCommentResponse;
import com.sixesSense.recorder.review.query.application.service.QueryCommentServiceImpl;
import com.sixesSense.recorder.review.query.domain.repository.CommentMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class CommandCommentTests {

    @Autowired
    private CommandCommentServiceImpl commandCommentService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private QueryCommentServiceImpl queryCommentService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommandReviewServiceImpl commandReviewService;

    @Autowired
    private CommentMapper commentMapper;

    @DisplayName("댓글 작성 확인")
    @Test
    void createComment(){
        Long reviewNo = 1l;
        CreateCommentRequest createCommentRequest = TestObjects.createComment();

        CreateCommentResponse createCommentResponse = commandCommentService.createComment(createCommentRequest, reviewNo);

        Assertions.assertTrue(
                createCommentRequest.getCommentContent().equals(createCommentResponse.getCommentContent()) &&
                createCommentRequest.getCommentContent().equals(createCommentResponse.getCommentContent()));
    }
    @DisplayName("댓글 전체 리스트")
    @Test
    void readComment(){
        Long reviewNo = 1l;

        int pageStart = 0;
        int commentSize = 10;

        Pageable pageable = PageRequest.of(pageStart, commentSize);

        Page<ReadCommentResponse> readCommentResponses = queryCommentService.commentLists(reviewNo, pageable);

        assertEquals(commentSize, readCommentResponses.getSize(), "예상한 댓글 수와 일치하지 않습니다.");
    }

    @DisplayName("댓글 수정 확인")
    @Test
    void updateComment(){
        Long reviewNo = 1l;
        Long memberNo = 1L;
        String commentContent = "쌍쌍바 맛있어요";

        UpdateCommentResponse updateCommentResponse = commandCommentService.updateComment(reviewNo, commentContent, memberNo);

        assertEquals(commentContent, updateCommentResponse.getCommentContent());
    }

    @DisplayName("댓글만 삭제 확인")
    @Test
    void deleteOneComment(){
        Long reviewNo = 1l;
        Long memberNo = 1L;

        assertDoesNotThrow(
                () -> commandCommentService.deleteOneComment(reviewNo,memberNo)
        );

        Comment comment = commentRepository.findByReviewReviewNoAndMemberNo(reviewNo, memberNo);
        assertNull(comment);
    }

    @DisplayName("리뷰 삭제시 댓글도 삭제 되는지")
    @Test
    void deleteAllCommentIfDeleteReview(){
        Long reviewNo = 1L;


        assertDoesNotThrow(
                () -> commandReviewService.reviewDelete(reviewNo)
        );
        reviewRepository.findByReviewNo(reviewNo);

        List<ReadCommentResponse> readCommentResponses = commentMapper.commentList(reviewNo);
        assertTrue(readCommentResponses.isEmpty(), "삭제 후에도 값이 존재합니다.");
    }
}
