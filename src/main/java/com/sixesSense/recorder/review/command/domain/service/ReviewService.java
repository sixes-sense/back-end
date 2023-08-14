package com.sixesSense.recorder.review.command.domain.service;


import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.application.dto.ReviewLikesDTO;

public interface ReviewService {

    void reviewSave(ReviewDTO review);

    boolean reviewUpdate(ReviewDTO updatedReview);

    void reviewDelete(Long reviewNo);

    ReviewLikesDTO countLike(Long reviewNo, ReviewLikesDTO clickLikesDTO);

//    ReviewLikesDTO minusLike(Long reviewNo, ReviewLikesDTO clickedLikesDTO);

}
