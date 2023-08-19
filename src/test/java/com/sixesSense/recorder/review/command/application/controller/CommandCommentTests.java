package com.sixesSense.recorder.review.command.application.controller;

import com.sixesSense.recorder.review.command.application.controller.object.TestObjects;
import com.sixesSense.recorder.review.command.application.dto.comment.request.CreateCommentRequest;
import com.sixesSense.recorder.review.command.application.dto.comment.response.CreateCommentResponse;
import com.sixesSense.recorder.review.command.application.service.CommandCommentServiceImpl;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Comment;
import com.sixesSense.recorder.review.command.domain.repository.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class CommandCommentTests {

    @Autowired
    private CommandCommentServiceImpl commandCommentService;

    @Autowired
    private CommentRepository commentRepository;

    @DisplayName("댓글 작성 확인")
    @Test
    void CreateComment(){
        Long reviewNo = 1l;
        CreateCommentRequest createCommentRequest = TestObjects.createComment();

        CreateCommentResponse createCommentResponse = commandCommentService.createComment(createCommentRequest, reviewNo);
        Comment comment = commentRepository.findByCommentNo(reviewNo);
        System.out.println("comment = " + comment);

        Assertions.assertNotNull(createCommentResponse);
    }
}
