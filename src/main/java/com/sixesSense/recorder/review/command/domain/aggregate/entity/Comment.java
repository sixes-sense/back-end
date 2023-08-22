package com.sixesSense.recorder.review.command.domain.aggregate.entity;

import com.sixesSense.recorder.common.entity.BaseTimeEntity;
import com.sixesSense.recorder.review.command.application.dto.comment.request.CreateCommentRequest;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(exclude = "review")
@Builder
public class Comment extends BaseTimeEntity {
    @Id
    @Column(name = "comment_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @Column(name = "comment_content")
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "review_no")
    private Review review;

    @Column(name = "member_no")
    private Long memberNo;


    public static Comment toEntity(CreateCommentRequest createCommentRequest, Review review) {
        return Comment.builder()
                .memberNo(createCommentRequest.getMemberNo())
                .review(review)
                .commentContent(createCommentRequest.getCommentContent())
                .build();
    }

    public void updateComment(String commentContent) {
        this.commentContent = commentContent;
    }
}
