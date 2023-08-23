package com.sixesSense.recorder.review.command.application.dto.review.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class SearchReviewResponse {
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
