package com.sixesSense.recorder.review.command.application.controller;

import com.sixesSense.recorder.review.command.application.controller.object.TestObjects;
import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.application.service.CommandReviewServiceImpl;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.repository.ReviewRepository;
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
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewMapper reviewMapper;

    @DisplayName("리뷰 등록 테스트")
    @Test
    void CreateReview() {
        ReviewDTO review = TestObjects.createContentWithReview();

        Assertions.assertDoesNotThrow(
                () -> commandReviewService.reviewSave(review)
        );
    }

    @DisplayName("리뷰 전체 조회 테스트")
    @Test
    void ReadReviews() {
        List<QueryReviewDTO> reviewDTOList = reviewMapper.reviewLists();

        Assertions.assertNotNull(reviewDTOList);
    }

    @DisplayName("리뷰 상세 조회 테스트")
    @Test
    void ReadReviewByReviewNo() {
        Integer reviewNo = 1;

        QueryReviewDTO review = reviewMapper.reviewListByReviewNo(reviewNo);
        System.out.println("review = " + review);

        Assertions.assertNotNull(review);
    }

    @DisplayName("리뷰 수정")
    @Test
    void UpdateReview(){
        Long reviewNo = 1L;

        ReviewDTO review = TestObjects.createContentWithReview();

        Assertions.assertDoesNotThrow(
                () -> commandReviewService.reviewUpdate(reviewNo, review)
        );

        Review updatedReview = reviewRepository.findByReviewNo(reviewNo);
        Assertions.assertTrue(
                review.getReviewTitle().equals(updatedReview.getReviewTitle()) &&
                        review.getReviewContent().equals(updatedReview.getReviewContent()) &&
                        review.getReviewDate().equals(updatedReview.getReviewDate())
        );
    }

    @DisplayName("리뷰 삭제")
    @Test
    void DeleteReview(){
        Long reviewNo = 1L;

        ReviewDTO review = TestObjects.createContentWithReview();

        Assertions.assertDoesNotThrow(
                () -> commandReviewService.reviewDelete(reviewNo, review)
        );

        Assertions.assertNull(reviewRepository.findByReviewNo(reviewNo));
    }
}
