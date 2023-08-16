package com.sixesSense.recorder.review.command.application.dto.response;

import com.sixesSense.recorder.review.command.application.dto.response.common.CommonReviewResponse;
import lombok.*;


@Getter
@Setter
public class CreateReviewResponse<T> extends CommonReviewResponse {
    private T data;
}
