package com.sixesSense.recorder.review.query.domain.repository;


import com.sixesSense.recorder.review.query.application.dto.QueryReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

    // 리뷰 전체 조회
    List<QueryReviewDTO> reviewLists();

    // 리뷰 상세 조회
    QueryReviewDTO reviewListByReviewNo(Long reviewNo);
}
