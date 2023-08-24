package com.sixesSense.recorder.review.command.application.dto.review.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SearchReviewRequest {
    String type;
    String keyword;
}
