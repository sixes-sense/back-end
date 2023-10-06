package com.sixesSense.recorder.review.command.application.dto.review.request;

import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CreateReviewRequest {
    private String reviewTitle;

    private String reviewContent;

    private Long reviewWriter;

    private List<String> tagNames;
}
