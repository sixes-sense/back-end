package com.sixesSense.recorder.review.query.application.dto;

import com.sixesSense.recorder.common.entity.BaseTimeEntity;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString
public class QueryReviewDTO extends BaseTimeEntity {
    private Long reviewNo;

    private String reviewTitle;

    private String reviewContent;

    private Long likeCnt;

    private Long reportCnt;

    private Long bookMarkCnt;

    private Long tagNo;

    private Long reviewWriter;

}
