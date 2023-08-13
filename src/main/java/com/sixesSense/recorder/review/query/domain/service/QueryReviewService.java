package com.sixesSense.recorder.review.query.domain.service;

import com.sixesSense.recorder.review.query.application.dto.QueryReviewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QueryReviewService {
    Page<QueryReviewDTO> getReviews(Pageable pageable);

}
