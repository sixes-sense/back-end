package com.sixesSense.recorder.review.command.application.controller;

import com.sixesSense.recorder.review.command.application.controller.object.TestObjects;
import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.application.service.CommandReviewServiceImpl;
import com.sixesSense.recorder.review.query.application.dto.QueryReviewDTO;
import com.sixesSense.recorder.review.query.domain.repository.ReviewMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;


@SpringBootTest
@Transactional
public class ReviewControllerTests {

    @Autowired
    private CommandReviewServiceImpl commandReviewService;

    @Autowired
    private ReviewMapper reviewMapper;

    @DisplayName("리뷰 등록")
    @Test
    void CreateReview() {
        ReviewDTO review = TestObjects.createContentWithReview();

        Assertions.assertDoesNotThrow(
                () -> commandReviewService.reviewSave(review)
        );
    }

    @DisplayName("리뷰 전체 조회")
    @Test
    void ReadReviews() {
        List<QueryReviewDTO> reviewDTOList = reviewMapper.reviewLists();

        Assertions.assertNotNull(reviewDTOList);
    }

    @DisplayName("리뷰 상세 조회")
    @Test
    void ReadReviewByReviewNo() {
        Integer reviewNo = 1;

        QueryReviewDTO review = reviewMapper.reviewListByReviewNo(reviewNo);
        System.out.println("review = " + review);

        Assertions.assertNotNull(review);
    }
}
