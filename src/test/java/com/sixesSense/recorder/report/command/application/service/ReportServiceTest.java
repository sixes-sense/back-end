package com.sixesSense.recorder.report.command.application.service;

import com.sixesSense.recorder.report.command.application.controller.object.TestObjects;
import com.sixesSense.recorder.report.command.application.dto.request.CreateReportRequest;
import com.sixesSense.recorder.report.command.application.dto.response.CreateReportResponse;
import com.sixesSense.recorder.report.command.application.service.CommandReportServiceImp;
import com.sixesSense.recorder.report.command.domain.repository.ReportRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class ReportServiceTest {

    @Autowired
    private CommandReportServiceImp commandReportService;

    @Autowired
    private ReportRepository reportRepository;

    @Test
    @DisplayName("신고 등록 테스트")
    void CreateReport() {

        CreateReportRequest createReportRequest = TestObjects.createContentReport();
        CreateReportResponse createReportResponse = commandReportService.reportSave(createReportRequest);
        Assertions.assertNotNull(createReportResponse);


    }
}


