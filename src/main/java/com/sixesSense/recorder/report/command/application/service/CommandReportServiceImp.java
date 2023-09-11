package com.sixesSense.recorder.report.command.application.service;

import com.sixesSense.recorder.report.command.application.dto.request.CreateReportRequest;
import com.sixesSense.recorder.report.command.application.dto.response.CreateReportResponse;
import com.sixesSense.recorder.report.command.domain.aggregate.entity.Report;
import com.sixesSense.recorder.report.command.domain.repository.ReportRepository;
import com.sixesSense.recorder.report.command.domain.service.ReportService;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommandReportServiceImp implements ReportService {

    private final ReportRepository reportRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public CreateReportResponse reportSave(CreateReportRequest createReportRequest) {

        Report report = Report.toEntity(createReportRequest);

        Report createReport = reportRepository.save(report);

        CreateReportResponse createReportResponse = CreateReportResponse.fromReport(createReport);

        // 리뷰 reportCnt 증가 로직
        Long reviewNo = createReportRequest.getReviewNo();

        Review review = reviewRepository.findByReviewNo(reviewNo);

        review.increaseReportsCount();
        reviewRepository.save(review);

        return createReportResponse;
    }

}
