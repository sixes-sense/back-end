package com.sixesSense.recorder.review.command.application.dto.request;

import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CreateReviewRequest {
    private String reviewTitle;

    private String reviewContent;

    private Long likeCnt;

    private Long reportCnt;

    private Long bookMarkCnt;

    private Long tagNo;

    private Long reviewWriter;

    public ReviewDTO toReviewDTO(Review review) {
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
