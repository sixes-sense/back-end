package com.sixesSense.recorder.review.command.application.service;

import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.application.dto.ReviewLikesDTO;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.ReviewLikes;
import com.sixesSense.recorder.review.command.domain.repository.ReviewLikesRepository;
import com.sixesSense.recorder.review.command.domain.repository.ReviewRepository;
import com.sixesSense.recorder.review.command.domain.service.ReviewService;
import com.sixesSense.recorder.review.command.infrastructure.service.ReviewValidService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommandReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewValidService reviewInvalidService;

    private final ReviewLikesRepository reviewLikesRepository;

    @Override
    @Transactional
    public void reviewSave(ReviewDTO reviewDTO) {
        Review review = Review.toEntity(reviewDTO);
        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public boolean reviewUpdate(ReviewDTO updatedReview) {
        Review review = reviewRepository.findByReviewNo(updatedReview.getReviewNo());

        if(review == null){
            return false;
        }

        review.updateReview(updatedReview);
        return true;
    }

    @Override
    @Transactional
    public void reviewDelete(Long reviewNo) {
        reviewRepository.deleteByReviewNo(reviewNo);
    }

    @Override
    @Transactional
    public ReviewLikesDTO countLike(Long reviewNo, ReviewLikesDTO clickLikesDTO) {
        Review review = reviewRepository.findByReviewNo(reviewNo);
        ReviewLikes reviewLikes = ReviewLikes.toEntity(clickLikesDTO);

        /* 좋아요 누른적 있는지 체크 후 좋아요 entity에 이력 저장 */
        ReviewLikes countReviewLikes = reviewInvalidService.checkLikeIsClicked(review, reviewLikes);

        /* 좋아요 엔티티를 DTO로 변환 후 리턴 */
        return ReviewLikesDTO.fromEntity(countReviewLikes);
    }
}
