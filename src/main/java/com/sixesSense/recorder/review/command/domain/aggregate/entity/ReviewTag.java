package com.sixesSense.recorder.review.command.domain.aggregate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
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
    @Column(name = "tag_id")
    private Long tagId;

    public static ReviewTag toEntity(Long tagId, Long reviewNo) {
        return ReviewTag.builder()
                .reviewNo(reviewNo)
                .tagId(tagId)
                .build();
    }
}
