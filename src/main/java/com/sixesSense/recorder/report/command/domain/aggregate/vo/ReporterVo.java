package com.sixesSense.recorder.report.command.domain.aggregate.vo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReporterVo {

    @Column(name = "report_member_no")
    // 신고자
    private Long reporter;

}
