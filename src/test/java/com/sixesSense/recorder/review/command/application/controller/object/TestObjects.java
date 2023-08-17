package com.sixesSense.recorder.review.command.application.controller.object;

import com.sixesSense.recorder.review.command.application.dto.like.request.PostLikeRequest;
import com.sixesSense.recorder.review.command.application.dto.like.response.PostLikeResponse;
import com.sixesSense.recorder.review.command.application.dto.review.request.CreateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.request.UpdateReviewRequest;
import com.sixesSense.recorder.review.command.application.service.CommandReviewServiceImpl;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.repository.ReviewRepository;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;


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

    public static UpdateReviewRequest updateContentWithReview(){
        return UpdateReviewRequest.builder()
                .reviewNo(1L)
                .reviewTitle("테스트 제목")
                .reviewContent("테스트 내용")
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
