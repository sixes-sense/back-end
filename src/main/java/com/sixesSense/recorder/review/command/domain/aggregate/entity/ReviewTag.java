package com.sixesSense.recorder.review.command.domain.aggregate.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "ReviewTag_TB")
public class ReviewTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @org.hibernate.annotations.Comment("리뷰 태그 번호")
    @Column(name = "review_tag_no")
    private Long reviewTagNo;

    @org.hibernate.annotations.Comment("리뷰 번호")
    @Column(name = "review_no")
    private Long reviewNo;

    @org.hibernate.annotations.Comment("태그 번호")
    @Column(name = "tag_no")
    private Long tagNo;
}
