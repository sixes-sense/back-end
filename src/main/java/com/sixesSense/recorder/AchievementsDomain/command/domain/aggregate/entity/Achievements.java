package com.sixesSense.recorder.AchievementsDomain.command.domain.aggregate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Achievements")
public class Achievements {

    @Id
    @Column(name = "ARCHIEVEMENTS_NO")
    private Integer achievementsNo;

    @Column(name = "ARCHIVEMENTS_DESCRIPTION")
    private String achievementsDescription;
}