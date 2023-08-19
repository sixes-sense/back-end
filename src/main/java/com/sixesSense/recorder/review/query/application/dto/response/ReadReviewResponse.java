package com.sixesSense.recorder.review.query.application.dto.response;



import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReadReviewResponse {
    private Long reviewNo;

    private String reviewTitle;

    private String reviewContent;

    private Long likeCnt;

    private Long reportCnt;

    private Long bookMarkCnt;

    private Long tagNo;

    private Long reviewWriter;

    private LocalDateTime createdAt;

    private LocalDate lastModifiedAt;

    private LocalDateTime deletedAt;
}
