package com.sixesSense.recorder.report.command.domain.aggregate.entity.enumtype;

import lombok.Getter;

@Getter
public enum ReportType {
    ADVERTISEMENT("지나친 광고/홍보", "Excessive Advertisement and Promotion"),
    INAPPROPRIATE_CONTENT("부적절한 콘텐츠", "Inappropriate Content"),
    PERSONAL_INFORMATION("개인정보 노출", "Exposure of Personal Information"),
    FALSE_CONTENT("허위적인 내용", "false content"),
    OTHER("기타", "Other Reasons");

    private final String koreanLabel;
    private final String englishLabel;

    ReportType(String koreanLabel, String englishLabel) {
        this.koreanLabel = koreanLabel;
        this.englishLabel = englishLabel;
    }

}
