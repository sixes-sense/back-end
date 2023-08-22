package com.sixesSense.recorder.report.command.application.controller.object;

import com.sixesSense.recorder.report.command.application.dto.request.CreateReportRequest;
import com.sixesSense.recorder.report.command.domain.aggregate.entity.enumtype.ReportType;
import com.sixesSense.recorder.report.command.domain.aggregate.vo.ReviewInfoVO;

public class TestObjects {

    public static CreateReportRequest createContentReport() {
        return CreateReportRequest.builder()
                .reportType(ReportType.FALSE_CONTENT)
                .reportContent("")
                .reviewNo(1L)
                .build();
    }

}
