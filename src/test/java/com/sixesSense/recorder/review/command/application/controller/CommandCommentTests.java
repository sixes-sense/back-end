package com.sixesSense.recorder.review.command.application.controller;

import com.sixesSense.recorder.review.command.application.controller.object.TestObjects;
import com.sixesSense.recorder.review.command.application.dto.comment.request.CreateCommentRequest;
import com.sixesSense.recorder.review.command.application.dto.comment.request.UpdateCommentRequest;
import com.sixesSense.recorder.review.command.application.dto.comment.response.CreateCommentResponse;
import com.sixesSense.recorder.review.command.application.service.CommandCommentServiceImpl;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Comment;
import com.sixesSense.recorder.review.command.domain.repository.CommentRepository;
import com.sixesSense.recorder.review.query.application.dto.response.ReadCommentResponse;
import com.sixesSense.recorder.review.query.application.service.QueryCommentServiceImpl;
import com.sixesSense.recorder.review.query.application.service.QueryReviewServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class CommandCommentTests {

    @Autowired
    private CommandCommentServiceImpl commandCommentService;


    @Autowired
    private QueryCommentServiceImpl queryCommentService;

    @Autowired
    private CommentRepository commentRepository;

    @DisplayName("댓글 작성 확인")
    @Test
    void CreateComment(){
        Long reviewNo = 1l;
        CreateCommentRequest createCommentRequest = TestObjects.createComment();

        CreateCommentResponse createCommentResponse = commandCommentService.createComment(createCommentRequest, reviewNo);

        Assertions.assertTrue(
                createCommentRequest.getCommentContent().equals(createCommentResponse.getCommentContent()) &&
                createCommentRequest.getCommentContent().equals(createCommentResponse.getCommentContent()));
    }
    @DisplayName("댓글 전체 리스트")
    @Test
    void ReadComment(){
        Long reviewNo = 1l;

        int pageStart = 0;
        int commentSize = 10;

        Pageable pageable = PageRequest.of(pageStart, commentSize);

        Page<ReadCommentResponse> readCommentResponses = queryCommentService.commentLists(reviewNo, pageable);
        System.out.println("readCommentResponses = " + readCommentResponses);

        assertEquals(commentSize, readCommentResponses.getSize(), "예상한 댓글 수와 일치하지 않습니다.");
    }

//    @DisplayName("댓글 수정 확인")
//    @Test
//    void UpdateComment(){
//        Long reviewNo = 1l;
//        UpdateCommentRequest updateCommentRequest = TestObjects.updateComment();
//    }
}
