package com.sixesSense.recorder.review.command.application.dto.review.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class UpdateReviewRequest {
    private Long reviewNo;

    private String reviewTitle;

    private String reviewContent;
}
