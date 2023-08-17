package com.sixesSense.recorder.review.command.application.dto.review.request;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CreateReviewRequest {
    private String reviewTitle;

    private String reviewContent;

    private Long likeCnt;

    private Long reportCnt;

    private Long bookMarkCnt;

    private Long tagNo;

    private Long reviewWriter;
}
