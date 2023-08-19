package com.sixesSense.recorder.review.command.domain.service;

import com.sixesSense.recorder.review.command.application.dto.comment.request.CreateCommentRequest;
import com.sixesSense.recorder.review.command.application.dto.comment.response.CreateCommentResponse;

public interface CommentService {
    CreateCommentResponse createComment(CreateCommentRequest createCommentRequest);
}
