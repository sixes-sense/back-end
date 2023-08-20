package com.sixesSense.recorder.review.query.domain.repository;


import com.sixesSense.recorder.review.query.application.dto.response.ReadReviewResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

    // 리뷰 전체 조회
    List<ReadReviewResponse> reviewLists();

    // 리뷰 상세 조회
    ReadReviewResponse reviewListByReviewNo(Long reviewNo);
}
