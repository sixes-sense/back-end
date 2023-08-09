package com.sixesSense.recorder.review.query.application.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString
public class QueryReviewDTO {
    private Long reviewNo;

    private String reviewTitle;

    private String reviewContent;

    private LocalDate reviewDate;

    private Long likeCnt;

    private Long reportCnt;

    private Long bookMarkCnt;

    private Long tagNo;

    private Long reviewWriter;
}
