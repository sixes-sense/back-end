package com.sixesSense.recorder.review.query.application.controller;

import com.sixesSense.recorder.review.command.domain.aggregate.entity.Comment;
import com.sixesSense.recorder.review.query.application.service.QueryReviewServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QueryReviewTests {
    @Autowired
    private QueryReviewServiceImpl queryReviewService;

    @DisplayName("댓글 전체 리스트")
    @Test
    void ReadComment(){
        Long reviewNo = 1l;
//        Comment comment = queryReviewService.commentLists(reviewNo);
    }
}
