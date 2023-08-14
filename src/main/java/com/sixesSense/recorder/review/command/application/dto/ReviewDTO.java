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

    @Builder
    public ReviewDTO(String reviewTitle, String reviewContent, LocalDate reviewDate) {
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
    }

    public ReviewDTO toReviewDTO(Review review) {
        return ReviewDTO.builder()
                .reviewTitle(review.getReviewTitle())
                .reviewContent(review.getReviewContent())
                .reviewDate(review.getReviewDate())
                .likeCnt(review.getLikeCnt())
                .reportCnt(review.getReportCnt())
                .bookMarkCnt(review.getBookMarkCnt())
                .tagNo(review.getTagNo().getTagNo())
                .reviewWriter(review.getReviewWriter().getReviewWriterMemberNo())
                .build();
    }
}
