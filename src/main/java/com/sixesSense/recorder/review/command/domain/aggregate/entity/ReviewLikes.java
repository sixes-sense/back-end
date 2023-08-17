package com.sixesSense.recorder.review.command.domain.aggregate.entity;

import com.sixesSense.recorder.review.command.application.dto.like.request.PostLikeRequest;
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

    public static ReviewLikes toEntity(PostLikeRequest postLikeRequest){
        return ReviewLikes.builder()
                .reviewNo(postLikeRequest.getReviewNo())
                .memberNo(postLikeRequest.getMemberNo())
                .isLiked(postLikeRequest.getIsLiked())
                .build();
    }

    public void like() {
        this.isLiked = true;
    }

    public void dontLike() {
        this.isLiked = false;
    }
}
