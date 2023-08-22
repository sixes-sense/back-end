package com.sixesSense.recorder.review.query.domain.repository;

import com.sixesSense.recorder.review.query.application.dto.response.ReadCommentResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<ReadCommentResponse> commentList(Long reviewNo);
}
