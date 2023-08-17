package com.sixesSense.recorder.review.command.application.dto.review.response;

import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateReviewResponse {

    private Long reviewNo;

    private String reviewTitle;

    private String reviewContent;

    public static UpdateReviewResponse toUpdateResponse(Review updatedReview) {
        return UpdateReviewResponse.builder()
                .reviewNo(updatedReview.getReviewNo())
                .reviewTitle(updatedReview.getReviewTitle())
                .reviewContent(updatedReview.getReviewContent())
                .build();
    }
}
