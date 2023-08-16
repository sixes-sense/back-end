package com.sixesSense.recorder.review.query.application.dto.request;

import com.sixesSense.recorder.common.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReadReviewRequest extends BaseTimeEntity {
    private Long reviewNo;

    private String reviewTitle;

    private String reviewContent;

    private Long likeCnt;

    private Long reportCnt;

    private Long bookMarkCnt;

    private Long tagNo;

    private Long reviewWriter;
}
