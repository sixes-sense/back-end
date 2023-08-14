package com.sixesSense.recorder.report.command.domain.aggregate.entity;

import com.sixesSense.recorder.report.command.domain.aggregate.vo.ReporterVo;
import com.sixesSense.recorder.report.command.domain.aggregate.vo.ReviewVo;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.ReviewWriterVO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Report {

    @Id
    @Column(name = "report_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportNo;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "report_content")
    private String reportContent;

    @Column(name = "report_category")
    private Integer reportCategory;

    @Column(name = "report_cnt")
    private Integer reportCnt;

    @Column(name = "blind_status")
    private Boolean blindStatus;

    @Embedded
    private ReviewVo reviewVo;

    @Embedded
    private ReporterVo reporterVo;

    @Embedded
    private ReviewWriterVO reviewWriterVO;

}
