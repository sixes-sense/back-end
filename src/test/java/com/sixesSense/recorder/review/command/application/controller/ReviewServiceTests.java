package com.sixesSense.recorder.review.command.application.controller;


import com.sixesSense.recorder.review.command.application.controller.object.TestObjects;
import com.sixesSense.recorder.review.command.application.dto.like.request.PostLikeRequest;
import com.sixesSense.recorder.review.command.application.dto.like.response.PostLikeResponse;
import com.sixesSense.recorder.review.command.application.dto.review.request.CreateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.request.UpdateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.response.CreateReviewResponse;
import com.sixesSense.recorder.review.command.application.dto.review.response.UpdateReviewResponse;
import com.sixesSense.recorder.review.command.application.service.CommandReviewServiceImpl;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.repository.ReviewRepository;
import com.sixesSense.recorder.review.query.application.dto.response.ReadReviewResponse;
import com.sixesSense.recorder.review.query.domain.repository.ReviewMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@Transactional
public class ReviewServiceTests {

    @Autowired
    private CommandReviewServiceImpl commandReviewService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewMapper reviewMapper;

    @DisplayName("리뷰 등록 테스트")
    @Test
    void CreateReview() {
        CreateReviewRequest review = TestObjects.createContentWithReview();

        CreateReviewResponse createReviewResponse = commandReviewService.reviewSave(review);

        Assertions.assertNotNull(createReviewResponse);
    }

    @DisplayName("리뷰 전체 조회 테스트")
    @Test
    void ReadReviews() {
        List<ReadReviewResponse> reviewDTOList = reviewMapper.reviewLists();

        Assertions.assertNotNull(reviewDTOList);
    }

    @DisplayName("리뷰 상세 조회 테스트")
    @Test
    void ReadReviewByReviewNo() {
        Long reviewNo = 1L;

        ReadReviewResponse review = reviewMapper.reviewListByReviewNo(reviewNo);

        Assertions.assertNotNull(review);
    }

    @DisplayName("리뷰 제목만 수정")
    @Test
    void UpdateReviewWithTitle(){
        ReadReviewResponse review = reviewMapper.reviewListByReviewNo(1l);
        UpdateReviewRequest updatingReview = TestObjects.updateContentWithReview(review,
                Optional.of("제목 업데이트"),
                Optional.empty());

        UpdateReviewResponse updateReviewResponse = commandReviewService.reviewUpdate(updatingReview);

        Assertions.assertTrue(
                updatingReview.getReviewTitle().equals(updateReviewResponse.getReviewTitle()) &&
                        updatingReview.getReviewContent().equals(updateReviewResponse.getReviewContent())
        );
    }

    @DisplayName("리뷰 내용만 수정")
    @Test
    void UpdateReviewWithContent(){
        ReadReviewResponse review = reviewMapper.reviewListByReviewNo(1l);
        UpdateReviewRequest updatingReview = TestObjects.updateContentWithReview(review,
                Optional.empty(),
                Optional.of("내용 업데이트"));

        UpdateReviewResponse updateReviewResponse = commandReviewService.reviewUpdate(updatingReview);

        Assertions.assertTrue(
                updatingReview.getReviewTitle().equals(updateReviewResponse.getReviewTitle()) &&
                        updatingReview.getReviewContent().equals(updateReviewResponse.getReviewContent())
        );
    }

    @DisplayName("리뷰 둘다 수정")
    @Test
    void UpdateReviewAll(){
        ReadReviewResponse review = reviewMapper.reviewListByReviewNo(1l);
        UpdateReviewRequest updatingReview = TestObjects.updateContentWithReview(review,
                Optional.of("제목 업데이트"),
                Optional.of("내용 업데이트"));

        UpdateReviewResponse updateReviewResponse = commandReviewService.reviewUpdate(updatingReview);

        Assertions.assertTrue(
                updatingReview.getReviewTitle().equals(updateReviewResponse.getReviewTitle()) &&
                        updatingReview.getReviewContent().equals(updateReviewResponse.getReviewContent())
        );
    }

    @DisplayName("리뷰 삭제 확인")
    @Test
    void DeleteReview(){
        Long reviewNo = 1L;

        Assertions.assertDoesNotThrow(
                () -> commandReviewService.reviewDelete(reviewNo)
        );

        Assertions.assertNull(reviewRepository.findByReviewNo(reviewNo));
    }

    @DisplayName("좋아요 증가 확인")
    @Test
    void increaseReviewLike(){
        Long reviewNo = 15L;
        PostLikeRequest postLikeRequest = TestObjects.countReviewLike(1l, false);
        Review reviewBefore = reviewRepository.findByReviewNo(reviewNo);
        long beforeLike = reviewBefore.getLikeCnt();

        PostLikeResponse postLikeResponse =commandReviewService.countLike(reviewNo, postLikeRequest);
        Review reviewAfter = reviewRepository.findByReviewNo(reviewNo);
        long afterLike = reviewAfter.getLikeCnt();

        Assertions.assertTrue(postLikeResponse.getIsLiked());
        Assertions.assertEquals(beforeLike+1l, afterLike);
    }

    @DisplayName("좋아요 감소 확인")
    @Test
    void decreaseReview(){
        Long reviewNo = 15L;
        PostLikeRequest postLikeRequest = TestObjects.countReviewLike(2l, true);
        Review reviewBefore = reviewRepository.findByReviewNo(reviewNo);
        long beforeLike = Math.max(0l, reviewBefore.getLikeCnt()-1l);

        PostLikeResponse postLikeResponse =commandReviewService.countLike(reviewNo, postLikeRequest);
        Review reviewAfter = reviewRepository.findByReviewNo(reviewNo);
        long afterLike = reviewAfter.getLikeCnt();

        Assertions.assertFalse(postLikeResponse.getIsLiked());
        Assertions.assertEquals(beforeLike, afterLike);
    }
}
