package com.sixesSense.recorder.review.command.domain.aggregate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Builder
public class ReviewLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_no")
    private int likeNo;

    @Column(name = "review_no")
    private Integer reviewNo;

    @Column(name = "member_no")
    private Integer memberNo;
}
