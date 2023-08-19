package com.sixesSense.recorder.review.query.domain.service;

import com.sixesSense.recorder.review.query.application.dto.response.ReadCommentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QueryCommentService {
    Page<ReadCommentResponse> commentLists(Long reviewNo, Pageable pageable);
}
