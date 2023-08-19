package com.sixesSense.recorder.review.command.application.service;

import com.sixesSense.recorder.review.command.application.dto.comment.request.CreateCommentRequest;
import com.sixesSense.recorder.review.command.application.dto.like.request.PostLikeRequest;
import com.sixesSense.recorder.review.command.application.dto.like.response.PostLikeResponse;
import com.sixesSense.recorder.review.command.application.dto.review.request.CreateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.request.UpdateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.response.CreateReviewResponse;
import com.sixesSense.recorder.review.command.application.dto.review.response.UpdateReviewResponse;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Comment;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.ReviewLikes;
import com.sixesSense.recorder.review.command.domain.repository.ReviewRepository;
import com.sixesSense.recorder.review.command.domain.service.ReviewService;
import com.sixesSense.recorder.review.command.infrastructure.service.ReviewValidService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommandReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewValidService reviewInvalidService;

    @Override
    @Transactional
    public CreateReviewResponse reviewSave(CreateReviewRequest createReviewRequest) {
        /* createReviewRequest -> entity 변환 후 저장, 다시 dto로 변환 후 리턴 */
        Review review = Review.toEntity(createReviewRequest);
        Review createdReview = reviewRepository.save(review);
        CreateReviewResponse createReviewResponse = CreateReviewResponse.toCreateResponse(createdReview);

        return createReviewResponse;
    }


    @Override
    @Transactional
    public UpdateReviewResponse reviewUpdate(UpdateReviewRequest updateReviewRequest) {
        Review review = reviewRepository.findByReviewNo(updateReviewRequest.getReviewNo());

//        if(review == null){
//            UpdateReviewResponse updateReviewResponse =
//        }

        review.updateReview(updateReviewRequest);
        Review updatedReview = reviewRepository.findByReviewNo(updateReviewRequest.getReviewNo());
        UpdateReviewResponse updateReviewResponse = UpdateReviewResponse.toUpdateResponse(updatedReview);

        return updateReviewResponse;
    }

    @Override
    @Transactional
    public void reviewDelete(Long reviewNo) {
        reviewRepository.deleteByReviewNo(reviewNo);
    }

    @Override
    @Transactional
    public PostLikeResponse countLike(Long reviewNo, PostLikeRequest postLikeRequest) {
        Review review = reviewRepository.findByReviewNo(reviewNo);
        ReviewLikes reviewLikes = ReviewLikes.toEntity(postLikeRequest);

        /* 좋아요 누른적 있는지 체크 후 좋아요 업데이트 */
        PostLikeResponse postLikeResponse = reviewInvalidService.checkLikeIsClicked(review, reviewLikes);

        return postLikeResponse;
    }
}
