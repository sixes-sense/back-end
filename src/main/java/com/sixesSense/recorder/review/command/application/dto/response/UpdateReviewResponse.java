package com.sixesSense.recorder.review.command.application.dto.response;

import com.sixesSense.recorder.review.command.application.dto.response.common.CommonReviewResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateReviewResponse<T> extends CommonReviewResponse {
    private T data;
}
