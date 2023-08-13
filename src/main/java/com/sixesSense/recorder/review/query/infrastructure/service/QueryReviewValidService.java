package com.sixesSense.recorder.review.query.infrastructure.service;

import com.sixesSense.recorder.review.query.application.dto.QueryReviewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryReviewValidService {
    public Page<QueryReviewDTO> checkReviewSize(List<QueryReviewDTO> reviews, int start, int end, Pageable pageable) {

        if(start > reviews.size()){
            return new PageImpl<>(new ArrayList<>(), pageable, reviews.size());
        }
        return new PageImpl<>(reviews.subList(start, end), pageable, reviews.size());
    }
}
