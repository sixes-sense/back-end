package com.sixesSense.recorder.review.command.domain.service;


import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.application.dto.ReviewLikesDTO;
import com.sixesSense.recorder.review.command.application.dto.request.CreateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.request.UpdateReviewRequest;

public interface ReviewService {

    ReviewDTO reviewSave(CreateReviewRequest reviewDTO);

    boolean reviewUpdate(UpdateReviewRequest updatedReview);

    void reviewDelete(Long reviewNo);

    ReviewLikesDTO countLike(Long reviewNo, ReviewLikesDTO clickLikesDTO);

//    ReviewLikesDTO minusLike(Long reviewNo, ReviewLikesDTO clickedLikesDTO);

}
