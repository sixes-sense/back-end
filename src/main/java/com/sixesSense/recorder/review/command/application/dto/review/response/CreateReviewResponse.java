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

    private Long tagNo;

    private Long reviewWriter;

    public static CreateReviewResponse toCreateResponse(Review createdReview) {
        return CreateReviewResponse.builder()
                .reviewTitle(createdReview.getReviewTitle())
                .reviewContent(createdReview.getReviewContent())
                .tagNo(createdReview.getTagNo().getTagNo())
                .reviewWriter(createdReview.getReviewWriter().getReviewWriterMemberNo())
                .build();
    }
}
