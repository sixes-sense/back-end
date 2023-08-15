package com.sixesSense.recorder.report.command.domain.aggregate.entity;

import com.sixesSense.recorder.report.command.domain.aggregate.entity.enumtype.ReportType;
import com.sixesSense.recorder.report.command.domain.aggregate.vo.ReporterVo;
import com.sixesSense.recorder.report.command.domain.aggregate.vo.ReviewInfoVO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Report_TB")
public class Report {

    @Id
    @Column(name = "report_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportNo;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "report_content")
    private String reportContent;

    @Enumerated(EnumType.STRING)
    @Column(name = "report_type")
    private ReportType reportType;

    @Column(name = "blind_status")
    private Boolean blindStatus;

    @Embedded
    private ReviewInfoVO reviewInfoVO;

    @Embedded
    private ReporterVo reporterVo;


}
