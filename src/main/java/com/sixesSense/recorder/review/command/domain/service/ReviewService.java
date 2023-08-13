package com.sixesSense.recorder.review.command.domain.service;


import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;

public interface ReviewService {

    Review reviewSave(ReviewDTO review);

    void reviewUpdate(Long reviewNo, ReviewDTO review);

    void reviewDelete(Long reviewNo, ReviewDTO review);

}
