package com.sixesSense.recorder.review.command.application.controller.object;

import com.sixesSense.recorder.review.command.application.dto.comment.request.CreateCommentRequest;
import com.sixesSense.recorder.review.command.application.dto.like.request.PostLikeRequest;
import com.sixesSense.recorder.review.command.application.dto.review.request.CreateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.request.UpdateReviewRequest;
import com.sixesSense.recorder.review.query.application.dto.response.ReadReviewResponse;

import java.util.Optional;


public class TestObjects {

    public static CreateReviewRequest createContentWithReview(){
        return CreateReviewRequest.builder()
                .reviewTitle("테스트 제목")
                .reviewContent("테스트 내용")
                .tagNo(1L)
                .reviewWriter(1L)
                .build();
    }

    public static UpdateReviewRequest updateContentWithReview(ReadReviewResponse review, Optional<String> title, Optional<String> content){
        return UpdateReviewRequest.builder()
                .reviewNo(review.getReviewNo())
                .reviewTitle(title.orElse(review.getReviewTitle()))
                .reviewContent(content.orElse(review.getReviewContent()))
                .build();
    }

    public static PostLikeRequest countReviewLike(Long testMemberNo, boolean isLiked) {
        return PostLikeRequest.builder()
                .memberNo(testMemberNo)
                .reviewNo(15l)
                .isLiked(isLiked)
                .build();
    }

    public static CreateCommentRequest createComment(){
        return CreateCommentRequest.builder()
                .memberNo(1l)
                .commentContent("테스트 댓글 내용")
                .build();
    }
}
