package com.sixesSense.recorder.review.command.domain.service;


import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;

public interface ReviewService {

    void reviewSave(ReviewDTO review);

}
