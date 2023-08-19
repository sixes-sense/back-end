package com.sixesSense.recorder.review.command.application.dto.comment.response;



import com.sixesSense.recorder.review.command.domain.aggregate.entity.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class CreateCommentResponse {
    private Long review_no;

    private Long member_no;

    private String commentContent;

    public static CreateCommentResponse fromEntity(Comment createdComment) {
        return CreateCommentResponse.builder()
                .review_no(createdComment.getReview_no())
                .member_no(createdComment.getMember_no())
                .commentContent(createdComment.getCommentContent())
                .build();
    }
}



