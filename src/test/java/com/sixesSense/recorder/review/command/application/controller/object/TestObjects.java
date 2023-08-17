package com.sixesSense.recorder.review.command.application.controller.object;

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
                .likeCnt(0L)
                .reportCnt(0L)
                .bookMarkCnt(0L)
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
}
