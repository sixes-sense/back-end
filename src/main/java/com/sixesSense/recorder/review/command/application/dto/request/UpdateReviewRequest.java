package com.sixesSense.recorder.review.command.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateReviewRequest {
    private Long reviewNo;

    private String reviewTitle;

    private String reviewContent;
}
