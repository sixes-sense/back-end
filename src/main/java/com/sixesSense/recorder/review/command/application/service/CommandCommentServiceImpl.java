package com.sixesSense.recorder.review.command.application.service;

import com.sixesSense.recorder.review.command.application.dto.comment.request.CreateCommentRequest;
import com.sixesSense.recorder.review.command.application.dto.comment.response.CreateCommentResponse;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Comment;
import com.sixesSense.recorder.review.command.domain.repository.CommentRepository;
import com.sixesSense.recorder.review.command.domain.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommandCommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public CreateCommentResponse createComment(CreateCommentRequest createCommentRequest) {
        Comment comment = Comment.toEntity(createCommentRequest);
        Comment createdComment = commentRepository.save(comment);

        CreateCommentResponse createCommentResponse = CreateCommentResponse.fromEntity(createdComment);

        return createCommentResponse;
    }
}
