package com.sixesSense.recorder.review.command.application.dto.comment.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class CreateCommentRequest {
    private Long memberNo;

    private String commentContent;
}