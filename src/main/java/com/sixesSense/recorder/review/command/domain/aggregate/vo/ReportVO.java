package com.sixesSense.recorder.review.command.domain.aggregate.vo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReportVO {

    // 신고와 상의 필요
    @Column(name = "report_no")
    private Long reportNo;

    @Column(name = "report_cnt")
    private Long reportCnt;
}
