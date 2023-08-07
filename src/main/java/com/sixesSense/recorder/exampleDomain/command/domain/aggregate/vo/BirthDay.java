package com.sixesSense.recorder.exampleDomain.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class BirthDay {

    @Column(name = "example_birth")
    private LocalDate exampleBirth;

    protected BirthDay() {}

    public BirthDay(LocalDate birthDay) {
        validatePast(birthDay);
        this.exampleBirth = birthDay;
    }

    private void validatePast(LocalDate birthDay) {

        if(!birthDay.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("생일은 오늘 날짜보다 이후일 수 없습니다.");
        }
    }
}
