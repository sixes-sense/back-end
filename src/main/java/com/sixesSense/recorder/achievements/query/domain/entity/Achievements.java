package com.sixesSense.recorder.achievements.query.domain.entity;


import com.sixesSense.recorder.attachments.query.domain.aggregate.entity.Attachments;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Achievements {

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

    public Achievements(String achievementName, String achievementDescription, LocalDateTime achievementCreatedDate, LocalDateTime achievementUpdatedDate) {
        this.achievementName = achievementName;
        this.achievementDescription = achievementDescription;
        this.achievementCreatedDate = achievementCreatedDate;
        this.achievementUpdatedDate = achievementUpdatedDate;
    }
}
