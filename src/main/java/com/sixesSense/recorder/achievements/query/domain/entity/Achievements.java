package com.sixesSense.recorder.achievements.query.domain.entity;


import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Achievements {

    private Long achievementNo;

    private String achievementName;

    private String achievementDescription;

    private Long attachmentNo;

    private LocalDateTime achievementCreatedDate;

    private LocalDateTime achievementUpdatedDate;

    public Achievements(String achievementName, String achievementDescription, Long attachmentNo, LocalDateTime achievementCreatedDate, LocalDateTime achievementUpdatedDate) {
        this.achievementName = achievementName;
        this.achievementDescription = achievementDescription;
        this.attachmentNo = attachmentNo;
        this.achievementCreatedDate = achievementCreatedDate;
        this.achievementUpdatedDate = achievementUpdatedDate;
    }
}
