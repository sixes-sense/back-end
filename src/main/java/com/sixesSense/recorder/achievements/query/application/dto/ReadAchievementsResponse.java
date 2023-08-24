package com.sixesSense.recorder.achievements.query.application.dto;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReadAchievementsResponse {

    private Long achievementNo;

    private String achievementName;

    private String achievementDescription;

    private LocalDateTime achievementCreatedDate;

    private LocalDateTime achievementUpdatedDate;
}
