package com.sixesSense.recorder.review.command.application.controller;

import com.sixesSense.recorder.review.command.application.controller.object.TestObjects;
import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.application.service.CommandReviewServiceImpl;
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

    @DisplayName("저장 테스트")
    @Test
    void CreateContent() {
        String title = "테스트 제목";
        String content = "테스트 내용";

        ReviewDTO review = TestObjects.createContentWithReview(title, content);

        Assertions.assertDoesNotThrow(
                () -> commandReviewService.reviewSave(review)
        );
    }

    @DisplayName("조회 테스트")
    @Test
    void ReadContent() {
        List<ReviewDTO> reviewDTOList = reviewMapper.reviewLists();
        Assertions.assertNotNull(reviewDTOList);
    }
}
