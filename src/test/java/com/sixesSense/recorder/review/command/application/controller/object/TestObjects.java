package com.sixesSense.recorder.review.command.application.controller.object;

import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.ReviewWriterVO;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.TagVO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestObjects {

    public static ReviewDTO createContentWithReview(){
        return ReviewDTO.builder()
                .reviewTitle("테스트 제목")
                .reviewContent("테스트 내용")
                .reviewDate(LocalDate.now())
                .likeCnt(0L)
                .reportCnt(0L)
                .bookMarkCnt(0L)
                .tagNo(1L)
                .reviewWriter(1L)
                .build();
//        return new ReviewDTO("테스트 제목", "테스트 내용", LocalDate.now(), 0L, 0L, 0L, 1L, 1L);
    }
}
