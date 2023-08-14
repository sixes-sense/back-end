package com.sixesSense.recorder.review.command.application.service;

import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.repository.ReviewRepository;
import com.sixesSense.recorder.review.command.domain.service.ReviewService;
import com.sixesSense.recorder.review.command.ininfrastructure.service.ReviewValidService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommandReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewValidService reviewInvalidService;

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
    @Transactional(readOnly = true)
    public ReviewDTO findReviewByReviewNo(Long reviewNo) {
        Review review = reviewRepository.findByReviewNo(reviewNo);

        return null;
    }
}
