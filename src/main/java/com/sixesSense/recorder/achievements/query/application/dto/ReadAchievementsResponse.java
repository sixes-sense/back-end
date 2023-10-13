package com.sixesSense.recorder.achievements.query.application.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReadAchievementsResponse {

    @Schema(name = "업적 번호")
    private Long achievementNo;

    @Schema(name = "업적 명")
    private String achievementName;

    @Schema(name = "업적 설명")
    private String achievementDescription;

    @Schema(name = "업적 생성 날짜")
    private LocalDateTime achievementCreatedDate;

    @Schema(name = "업적 수정 날짜")
    private LocalDateTime achievementUpdatedDate;
}
