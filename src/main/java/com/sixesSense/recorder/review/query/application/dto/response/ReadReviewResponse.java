package com.sixesSense.recorder.review.query.application.dto.response;


import com.sixesSense.recorder.review.query.application.dto.response.common.CommonReviewResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReadReviewResponse<T> extends CommonReviewResponse {
    private T data;
}
