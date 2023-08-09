package com.sixesSense.recorder.review.query.domain.repository;


import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<ReviewDTO> reviewLists();
}
