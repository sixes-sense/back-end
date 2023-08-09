package com.sixesSense.recorder.review.command.application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sixesSense.recorder.review.command.application.controller.object.TestObjects;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.repository.ReviewRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class ReviewControllerTests {

    @Autowired
    private ReviewRepository reviewRepository;

    @DisplayName("저장 테스트")
    @Test
    void CreateContent() {
        String title = "테스트 제목";
        String content = "테스트 내용";

        Review review = TestObjects.createContentWithReview(title, content);

        Assertions.assertDoesNotThrow(
                () -> reviewRepository.save(review)
        );
    }
}
