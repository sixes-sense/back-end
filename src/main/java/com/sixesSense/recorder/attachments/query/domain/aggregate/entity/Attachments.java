package com.sixesSense.recorder.attachments.query.domain.aggregate.entity;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Attachments {

    private Long attachmentNo;

    private String attachmentOriginalName;

    private String attachmentChangedName;

    private String attachmentUrl;

    private String attachmentCategory;

    private String attachmentFilenameExtension;

    private Long achievementNo;

    private LocalDateTime achievementCreatedDate;

    private LocalDateTime achievementUpdatedDate;


    public Attachments(String attachmentOriginalName, String attachmentChangedName, String attachmentUrl, String attachmentCategory, String attachmentFilenameExtension, Long achievementNo, LocalDateTime achievementCreatedDate, LocalDateTime achievementUpdatedDate) {
        this.attachmentOriginalName = attachmentOriginalName;
        this.attachmentChangedName = attachmentChangedName;
        this.attachmentUrl = attachmentUrl;
        this.attachmentCategory = attachmentCategory;
        this.attachmentFilenameExtension = attachmentFilenameExtension;
        this.achievementNo = achievementNo;
        this.achievementCreatedDate = achievementCreatedDate;
        this.achievementUpdatedDate = achievementUpdatedDate;
    }
}
