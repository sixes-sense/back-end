package com.sixesSense.recorder.review.command.domain.service;


import com.sixesSense.recorder.review.command.application.dto.like.request.PostLikeRequest;
import com.sixesSense.recorder.review.command.application.dto.like.response.PostLikeResponse;
import com.sixesSense.recorder.review.command.application.dto.review.request.CreateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.request.SearchReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.request.UpdateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.response.CreateReviewResponse;
import com.sixesSense.recorder.review.command.application.dto.review.response.SearchReviewResponse;
import com.sixesSense.recorder.review.command.application.dto.review.response.UpdateReviewResponse;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;

public interface ReviewService {

    CreateReviewResponse reviewSave(CreateReviewRequest reviewDTO);

    UpdateReviewResponse reviewUpdate(UpdateReviewRequest updateReviewRequest, Long reviewNo);

    void reviewDelete(Long reviewNo);

    PostLikeResponse countLike(Long reviewNo, PostLikeRequest clickLikesDTO);
}
