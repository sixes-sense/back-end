package com.sixesSense.recorder.achievements.command.domain.aggregate.entity;

import com.sixesSense.recorder.common.entity.BaseTimeEntity;
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
public class Achievements extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_no")
    @Comment("업적 번호")
    private Long achievementNo;

    @Column(name = "achievement_name")
    @Comment("업적 이름")
    private String achievementName;

    @Column(name = "achievement_description")
    @Comment("업적 설명")
    private String achievementDescription;
}