package com.sixesSense.recorder.review.command.application.dto;

import com.sixesSense.recorder.review.command.domain.aggregate.entity.ReviewLikes;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ReviewLikesDTO {
    private Long reviewNo;

    private Long memberNo;

    private Boolean isLiked;

    public static ReviewLikesDTO fromEntity(ReviewLikes reviewLikes) {
        return ReviewLikesDTO.builder()
                .reviewNo(reviewLikes.getReviewNo())
                .memberNo(reviewLikes.getMemberNo())
                .isLiked(reviewLikes.getIsLiked())
                .build();
    }
}
