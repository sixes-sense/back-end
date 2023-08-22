package com.sixesSense.recorder.report.command.domain.service;

import com.sixesSense.recorder.report.command.application.dto.request.CreateReportRequest;
import com.sixesSense.recorder.report.command.application.dto.response.CreateReportResponse;

public interface ReportService {

    CreateReportResponse reportSave (CreateReportRequest reportRequest);


}
