package com.sixesSense.recorder.review.command.application.dto;

import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ReviewDTO {
    private Long reviewNo;

    private String reviewTitle;

    private String reviewContent;

    private LocalDate reviewDate;

    private Long likeCnt;

    private Long reportCnt;

    private Long bookMarkCnt;

    private Long tagNo;

    private Long reviewWriter;

    public static ReviewDTO toReviewDTO(Review review) {
        return ReviewDTO.builder()
                .reviewTitle(review.getReviewTitle())
                .reviewContent(review.getReviewContent())
                .likeCnt(review.getLikeCnt())
                .reportCnt(review.getReportCnt())
                .bookMarkCnt(review.getBookMarkCnt())
                .tagNo(review.getTagNo().getTagNo())
                .reviewWriter(review.getReviewWriter().getReviewWriterMemberNo())
                .build();
    }
}
