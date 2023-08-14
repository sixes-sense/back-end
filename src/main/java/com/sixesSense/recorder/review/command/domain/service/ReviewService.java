package com.sixesSense.recorder.review.command.domain.service;


import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;

public interface ReviewService {

    void reviewSave(ReviewDTO review);
    boolean reviewUpdate(ReviewDTO updatedReview);
    void reviewDelete(Long reviewNo);
    ReviewDTO findReviewByReviewNo(Long reviewNo);

}
