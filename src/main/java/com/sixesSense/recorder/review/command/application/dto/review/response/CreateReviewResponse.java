package com.sixesSense.recorder.review.command.application.dto.review.response;


import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Builder
public class CreateReviewResponse {
    private Long reviewNo;

    private String reviewTitle;

    private String reviewContent;

    private LocalDate reviewDate;

    private Long reviewWriter;

    public static CreateReviewResponse toCreateResponse(Review review) {
        return CreateReviewResponse.builder()
                .reviewNo(review.getReviewNo())
                .reviewTitle(review.getReviewTitle())
                .reviewContent(review.getReviewContent())
                .reviewWriter(review.getReviewWriter().getReviewWriterMemberNo())
                .build();
    }
}
