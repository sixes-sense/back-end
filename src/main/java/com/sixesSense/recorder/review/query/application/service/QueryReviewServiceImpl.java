package com.sixesSense.recorder.review.query.application.service;


import com.sixesSense.recorder.review.command.application.dto.review.request.SearchReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.response.SearchReviewResponse;
import com.sixesSense.recorder.review.query.application.dto.response.ReadReviewResponse;
import com.sixesSense.recorder.review.query.domain.repository.ReviewMapper;
import com.sixesSense.recorder.review.query.domain.service.QueryReviewService;
import com.sixesSense.recorder.review.query.infrastructure.service.QueryReviewValidService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryReviewServiceImpl implements QueryReviewService {

    private final ReviewMapper reviewMapper;
    private final QueryReviewValidService queryReviewValidService;

    @Override
    @Transactional(readOnly = true)
    public Page<ReadReviewResponse> getReviews(Pageable pageable) {
        List<ReadReviewResponse> readReviewResponses = reviewMapper.reviewLists();

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), readReviewResponses.size());

        /* 리뷰 개수 유효성 체크 */
        Page<ReadReviewResponse> pagingReviews = queryReviewValidService.checkReviewSize(readReviewResponses, start, end, pageable);

        return pagingReviews;
    }

    // 리뷰 검색
    @Override
    @Transactional(readOnly = true)
    public Page<SearchReviewResponse> searchReview(SearchReviewRequest searchReviewRequest, Pageable pageable) {
        List<SearchReviewResponse> searchReviewResponses = reviewMapper.reviewListByKeyword(searchReviewRequest.getKeyword(), searchReviewRequest.getType());

        int start = (int) pageable.getOffset();
        int end = Math.min(start+ pageable.getPageSize(), searchReviewResponses.size());

        Page<SearchReviewResponse> searchReviews = queryReviewValidService.checkReviewSize(searchReviewResponses, start, end, pageable);

        return searchReviews;
    }

    @Override
    @Transactional(readOnly = true)
    public ReadReviewResponse getReviewDetail(Long reviewNo) {
        ReadReviewResponse reviewDetail = reviewMapper.reviewListByReviewNo(reviewNo);
        return reviewDetail;
    }

//    @Override
//    @Transactional(readOnly = true)
//    public Page<ReadReviewResponse> searchReview(SearchReviewRequest searchReviewRequest, Pageable pageable) {
//        List<ReadReviewResponse> readReviewResponses = reviewMapper.reviewListByKeyword(searchReviewRequest.getKeyword());
//
//        int start = (int) pageable.getOffset();
//        int end = Math.min(start+ pageable.getPageSize(), readReviewResponses.size());
//
//        Page<ReadReviewResponse> searchReviews = queryReviewValidService.checkReviewSize(readReviewResponses, start, end, pageable);
//
//        return searchReviews;
//    }
}
