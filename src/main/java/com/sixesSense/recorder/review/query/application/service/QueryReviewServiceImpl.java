package com.sixesSense.recorder.review.query.application.service;


import com.sixesSense.recorder.review.query.application.dto.QueryReviewDTO;
import com.sixesSense.recorder.review.query.domain.repository.ReviewMapper;
import com.sixesSense.recorder.review.query.domain.service.QueryReviewService;
import com.sixesSense.recorder.review.query.infrastructure.service.QueryReviewValidService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryReviewServiceImpl implements QueryReviewService {

    private final ReviewMapper reviewMapper;
    private final QueryReviewValidService queryReviewValidService;

    @Override
    @Transactional(readOnly = true)
    public Page<QueryReviewDTO> getReviews(Pageable pageable) {
        List<QueryReviewDTO> reviews = reviewMapper.reviewLists();

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), reviews.size());

        /* 리뷰 개수 유효성 체크 */
        Page<QueryReviewDTO> pagingReviews = queryReviewValidService.checkReviewSize(reviews, start, end, pageable);

        return pagingReviews;
    }

    @Override
    @Transactional(readOnly = true)
    public QueryReviewDTO getReviewDetail(Long reviewNo) {
        QueryReviewDTO reviewDetail = reviewMapper.reviewListByReviewNo(reviewNo);
        return reviewDetail;
    }
}
