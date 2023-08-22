package com.sixesSense.recorder.review.command.infrastructure.service;


import com.sixesSense.recorder.review.command.application.dto.like.response.PostLikeResponse;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.ReviewLikes;
import com.sixesSense.recorder.review.command.domain.repository.ReviewLikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewValidService {

    private final ReviewLikesRepository reviewLikesRepository;

    @Transactional
    public PostLikeResponse checkLikeIsClicked(Review review, ReviewLikes reviewLikes) {
        /* 좋아요를 누른적이 없으면 if문 실행 */
        if (!(reviewLikes.getIsLiked())){
            /*
            * 1. 좋아요 이력 변경
            * 2. 좋아요 +1 및 좋아요 isLiked = true 설정 후 true 반환
            * */
            review.increaseLikesCount();
            reviewLikes.like();
            reviewLikesRepository.save(reviewLikes);

            PostLikeResponse postLikeResponse = PostLikeResponse.fromEntity(reviewLikes);
            return postLikeResponse;
        }else {
            /* 좋아요 누른적 있으면 좋아요 -1 및 좋아요 isLiked = false 설정 후 false 반환*/
            ReviewLikes Like = reviewLikesRepository.findByReviewNoAndMemberNo(reviewLikes.getReviewNo(), reviewLikes.getMemberNo());
            review.decreaseLikesCount();
            Like.dontLike();
            reviewLikes = Like;
        }

        PostLikeResponse postLikeResponse = PostLikeResponse.fromEntity(reviewLikes);
        return postLikeResponse;
    }
}
