package com.sixesSense.recorder.achievements.command.domain.aggregate.entity;


import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "Member_Owned_Achievements_TB")
@Entity
@IdClass(AchievementsMember.class)
public class AchievementsMember implements Serializable {

    @Id
    @Column(name = "member_no")
    @Comment("업적 달성 회원")
    private Long memberNo;

    @Id
    @Column(name = "achievements_no")
    @Comment("업적 번호")
    private Long achievementsNo;

    @Column(name = "owned_date")
    @Comment("획득 시간")
    private LocalDateTime ownedDate;
}
