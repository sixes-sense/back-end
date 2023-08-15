package com.sixesSense.recorder.report.command.domain.repository;

import com.sixesSense.recorder.report.command.domain.aggregate.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

}
