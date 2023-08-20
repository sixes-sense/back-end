package com.sixesSense.recorder.review.query.application.service;

import com.sixesSense.recorder.review.query.application.dto.response.ReadCommentResponse;
import com.sixesSense.recorder.review.query.domain.repository.CommentMapper;
import com.sixesSense.recorder.review.query.domain.service.QueryCommentService;
import com.sixesSense.recorder.review.query.infrastructure.service.QueryCommentValidService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryCommentServiceImpl implements QueryCommentService {

    private final CommentMapper commentMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<ReadCommentResponse> commentLists(Long reviewNo, Pageable pageable) {
        List<ReadCommentResponse> readCommentResponseList = commentMapper.commentList(reviewNo);

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), readCommentResponseList.size());

        Page<ReadCommentResponse> pagedCommentResponse = QueryCommentValidService.checkCommentSize(readCommentResponseList, start, end, pageable);

        return pagedCommentResponse;
    }
}
