package com.sixesSense.recorder.review.query.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReadCommentResponse {
    private Long memberNo;

    private String commentContent;
}
