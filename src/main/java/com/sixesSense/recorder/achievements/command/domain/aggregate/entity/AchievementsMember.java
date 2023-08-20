package com.sixesSense.recorder.achievements.command.domain.aggregate.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "Member_Owned_Achievements_TB")
@Entity
@IdClass(AchievementsMember.class)
public class AchievementsMember implements Serializable {

    @Id
    @Column(name = "member_no")
    private Long memberNo;

    @Id
    @Column(name = "achievements_no")
    private Long achievementsNo;

    @Column(name = "owned_date")
    private LocalDateTime ownedDate;
}
