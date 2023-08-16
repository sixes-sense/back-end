package com.sixesSense.recorder.review.command.application.controller.object;

import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.application.dto.request.CreateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.request.UpdateReviewRequest;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.ReviewWriterVO;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.TagVO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
}
