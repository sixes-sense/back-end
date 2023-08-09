package com.sixesSense.recorder.review.command.domain.aggregate.vo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TagVO {

    @Column(name = "tag_no")
    private Long tagNo;
}
