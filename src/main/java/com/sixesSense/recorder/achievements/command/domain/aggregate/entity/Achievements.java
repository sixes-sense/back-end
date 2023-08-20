package com.sixesSense.recorder.achievements.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Achievements_TB")
public class Achievements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievment_no")
    @Comment("업적 번호")
    private Long achievementNo;

    @Column(name = "achievment_name")
    @Comment("업적 이름")
    private String achievementName;

    @Column(name = "achievment_description")
    @Comment("업적 설명")
    private String achievementDescription;

    @Column(name = "attachment_no")
    @Comment("업적 이미지")
    private Long attachmentNo;

    @Column(name = "achievement_created_date")
    @Comment("업적 생성시간")
    private LocalDateTime achievementsCreatedDate;

    @Column(name = "achievement_updated_date")
    @Comment("업적 수정시간")
    private LocalDateTime achievementsUpdatedDate;
}