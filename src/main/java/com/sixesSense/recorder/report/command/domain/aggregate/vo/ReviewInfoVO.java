package com.sixesSense.recorder.report.command.domain.aggregate.vo;

import com.sixesSense.recorder.review.command.domain.aggregate.vo.ReviewWriterVO;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Getter
@NoArgsConstructor
public class ReviewInfoVO {

    @Column(name = "review_no")
    private Long reviewNo;

    @Column(name = "review_title")
    private String reviewTitle;

    @Embedded
    @Column(name = "review_writer")
    //리뷰 작성자
    private ReviewWriterVO reviewWriter;

    public ReviewInfoVO(Long reviewNo) {
        this.reviewNo = reviewNo;
    }

}
