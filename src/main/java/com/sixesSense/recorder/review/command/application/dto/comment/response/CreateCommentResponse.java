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
    private Long reviewNo;

    private Long memberNo;

    private String commentContent;

    public static CreateCommentResponse fromEntity(Comment comment) {
        return CreateCommentResponse.builder()
//                .reviewNo(comment.getReview().getReviewNo())
                .memberNo(comment.getMemberNo())
                .commentContent(comment.getCommentContent())
                .build();
    }
}



