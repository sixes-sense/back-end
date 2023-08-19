package com.sixesSense.recorder.review.command.application.dto.comment.request;

import java.time.LocalDate;

public class UpdateCommentRequest {
    private Long commentNo;
    private String commentContent;
    private LocalDate lastModifiedAt;
}
