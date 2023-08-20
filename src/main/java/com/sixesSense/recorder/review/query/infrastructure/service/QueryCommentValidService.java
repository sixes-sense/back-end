package com.sixesSense.recorder.review.query.infrastructure.service;

import com.sixesSense.recorder.review.query.application.dto.response.ReadCommentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class QueryCommentValidService {
    public static Page<ReadCommentResponse> checkCommentSize(List<ReadCommentResponse> readCommentResponseList, int start, int end, Pageable pageable) {

        if(start > readCommentResponseList.size()){
            return new PageImpl<>(new ArrayList<>(), pageable, readCommentResponseList.size());
        }
        return new PageImpl<>(readCommentResponseList.subList(start, end), pageable, readCommentResponseList.size());
    }
}
