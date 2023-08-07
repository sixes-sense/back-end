package com.sixesSense.recorder.exampleDomain.command.domain.aggregate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Example {
    @Id
    private Integer exampleNo;
}