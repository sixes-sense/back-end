package com.sixesSense.recorder.report.command.domain.aggregate.vo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReviewVo {

    @Column(name = "review_no")
    private Integer reviewNo;

}
