package com.sixesSense.recorder.review.command.domain.aggregate.entity;

import com.sixesSense.recorder.review.command.application.dto.comment.request.CreateCommentRequest;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Builder
public class Comment {
    @Id
    @Column(name = "comment_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "review_no")
    private Long review_no;

    @Column(name = "member_no")
    private Long member_no;


    public static Comment toEntity(CreateCommentRequest createCommentRequest) {
        return Comment.builder()
                .member_no(createCommentRequest.getMember_no())
                .review_no(createCommentRequest.getReview_no())
                .commentContent(createCommentRequest.getCommentContent())
                .build();
    }
}
