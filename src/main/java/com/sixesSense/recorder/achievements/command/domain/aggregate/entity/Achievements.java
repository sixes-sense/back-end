package com.sixesSense.recorder.achievements.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Achievements_TB")
public class Achievements {

    @Id
    @Column(name = "achievments_no")
    private Long achievementsNo;

    @Column(name = "achievments_name")
    private String achievementsName;

    @Column(name = "achievments_description")
    private String achievementsDescription;

    @Column(name = "attachments_no")
    private Long attachmentsNo;

    @Column(name = "achievements_created_date")
    private LocalDateTime achievementsCreatedDate;

    @Column(name = "achievements_updated_date")
    private LocalDateTime achievementsUpdatedDate;
}