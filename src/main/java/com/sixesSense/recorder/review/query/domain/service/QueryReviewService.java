package com.sixesSense.recorder.review.query.domain.service;

import com.sixesSense.recorder.review.command.application.dto.review.request.SearchReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.response.SearchReviewResponse;
import com.sixesSense.recorder.review.query.application.dto.response.ReadReviewResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QueryReviewService {
    Page<ReadReviewResponse> getReviews(Pageable pageable);
    ReadReviewResponse getReviewDetail(Long reviewNo);
    Page<SearchReviewResponse> searchReview(SearchReviewRequest searchReviewRequest, Pageable pageable);

}
