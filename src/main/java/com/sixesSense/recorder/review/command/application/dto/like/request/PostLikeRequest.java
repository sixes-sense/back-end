package com.sixesSense.recorder.review.command.application.dto.like.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostLikeRequest {
    private Long reviewNo;

    private Long memberNo;

    private Boolean isLiked;
}
