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
public class ReviewWriterVO {
    // 회원 pk 맞춰야함
    @Column(name = "member_no")
    private Long reviewWriterMemberNo;
}
