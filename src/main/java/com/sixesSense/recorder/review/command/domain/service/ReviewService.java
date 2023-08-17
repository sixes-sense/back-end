package com.sixesSense.recorder.review.command.domain.service;


import com.sixesSense.recorder.review.command.application.dto.like.request.PostLikeRequest;
import com.sixesSense.recorder.review.command.application.dto.like.response.PostLikeResponse;
import com.sixesSense.recorder.review.command.application.dto.review.request.CreateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.request.UpdateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.response.CreateReviewResponse;
import com.sixesSense.recorder.review.command.application.dto.review.response.UpdateReviewResponse;

public interface ReviewService {

    CreateReviewResponse reviewSave(CreateReviewRequest reviewDTO);

    UpdateReviewResponse reviewUpdate(UpdateReviewRequest updatedReview);

    void reviewDelete(Long reviewNo);

    PostLikeResponse countLike(Long reviewNo, PostLikeRequest clickLikesDTO);

//    ReviewLikesDTO minusLike(Long reviewNo, ReviewLikesDTO clickedLikesDTO);

}
