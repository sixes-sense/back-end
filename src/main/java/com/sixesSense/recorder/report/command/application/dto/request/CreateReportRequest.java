package com.sixesSense.recorder.report.command.application.dto.request;

import com.sixesSense.recorder.report.command.domain.aggregate.entity.Report;
import com.sixesSense.recorder.report.command.domain.aggregate.entity.enumtype.ReportType;
import com.sixesSense.recorder.report.command.domain.aggregate.vo.ReviewInfoVO;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CreateReportRequest {

    private ReportType reportType;

    private String reportContent;

    private Long reviewNo;

    public CreateReportRequest(Long reviewNo){
        this.reviewNo = reviewNo;
    }

}
