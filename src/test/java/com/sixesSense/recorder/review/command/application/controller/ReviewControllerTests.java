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
import java.time.LocalDate;
import java.util.List;


@SpringBootTest
@Transactional
public class ReviewControllerTests {

    @Autowired
    private CommandReviewServiceImpl commandReviewService;

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

        Assertions.assertNotNull(review);
    }

    @DisplayName("리뷰 수정 테스트")
    @Test
    void UpdateReviewByReviewNo(){
        Integer reviewNo = 1;
        String reviewTitle = "제목 수정 테스트";
        String reviewContent = "내용 수정 테스트";
        LocalDate reviewDate = LocalDate.now();
        Long tagNo = 2l;

        QueryReviewDTO review = reviewMapper.reviewListByReviewNo(reviewNo);

    }


}
