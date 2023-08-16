package com.sixesSense.recorder.review.command.application.dto.response.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonReviewResponse {
    private boolean success;
    private int code;
    String message;
}
