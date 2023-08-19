package com.sixesSense.recorder.review.command.application.service;

import com.sixesSense.recorder.review.command.application.dto.comment.request.CreateCommentRequest;
import com.sixesSense.recorder.review.command.application.dto.comment.response.CreateCommentResponse;
import com.sixesSense.recorder.review.command.application.dto.comment.response.UpdateCommentResponse;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Comment;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.repository.CommentRepository;
import com.sixesSense.recorder.review.command.domain.repository.ReviewRepository;
import com.sixesSense.recorder.review.command.domain.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommandCommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public CreateCommentResponse createComment(CreateCommentRequest createCommentRequest, Long reviewNo) {
        Review review = reviewRepository.findByReviewNo(reviewNo);
        Comment comment = Comment.toEntity(createCommentRequest, review);
        Comment createdComment = commentRepository.save(comment);

        CreateCommentResponse createCommentResponse = CreateCommentResponse.fromEntity(createdComment);

        return createCommentResponse;
    }

    @Override
    @Transactional
    public UpdateCommentResponse updateComment(Long reviewNo, String commentContent, Long memberNo) {
        Comment comment = commentRepository.findByReviewReviewNoAndMemberNo(reviewNo,memberNo);
        comment.updateComment(commentContent);

        UpdateCommentResponse updateCommentResponse = UpdateCommentResponse.fromEntity(comment);
        return updateCommentResponse;
    }

    @Override
    @Transactional
    public void deleteOneComment(Long reviewNo, Long memberNo) {
        Comment comment = commentRepository.findByReviewReviewNoAndMemberNo(reviewNo, memberNo);
        commentRepository.delete(comment);
    }
}
