package com.sixesSense.recorder.review.command.domain.aggregate.entity;

import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.application.dto.ReviewLikesDTO;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.ReviewWriterVO;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.TagVO;
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
    private Long likeNo;

    @Column(name = "review_no")
    private Long reviewNo;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(name = "is_liked")
    private Boolean isLiked;

    public static ReviewLikes toEntity(ReviewLikesDTO clickLikesDTO){
        return ReviewLikes.builder()
                .reviewNo(clickLikesDTO.getReviewNo())
                .memberNo(clickLikesDTO.getMemberNo())
                .isLiked(clickLikesDTO.getIsLiked())
                .build();
    }

    public void like() {
        this.isLiked = true;
    }

    public void dontLike() {
        this.isLiked = false;
    }
}
