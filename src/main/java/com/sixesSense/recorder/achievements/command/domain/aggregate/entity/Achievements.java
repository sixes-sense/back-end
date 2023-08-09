package com.sixesSense.recorder.achievements.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Achievements")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Achievements {

    @Id
    @Column(name = "ARCHIEVEMENTS_NO")
    private Long achievementsNo;

    @Column(name = "ARCHIVEMENTS_DESCRIPTION")
    private String achievementsDescription;
}