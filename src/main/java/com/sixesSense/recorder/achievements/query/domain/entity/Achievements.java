package com.sixesSense.recorder.achievements.query.domain.entity;


import com.sixesSense.recorder.attachments.query.domain.aggregate.entity.Attachments;
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

    private LocalDateTime achievementCreatedDate;

    private LocalDateTime achievementUpdatedDate;

    public Achievements(String achievementName, String achievementDescription, LocalDateTime achievementCreatedDate, LocalDateTime achievementUpdatedDate) {
        this.achievementName = achievementName;
        this.achievementDescription = achievementDescription;
        this.achievementCreatedDate = achievementCreatedDate;
        this.achievementUpdatedDate = achievementUpdatedDate;
    }
}
