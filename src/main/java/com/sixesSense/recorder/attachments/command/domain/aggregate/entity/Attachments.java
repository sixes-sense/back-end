package com.sixesSense.recorder.attachments.command.domain.aggregate.entity;

import com.sixesSense.recorder.common.entity.BaseTimeEntity;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Attachments_TB")
public class Attachments extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attachment_no")
    @Comment("파일 번호")
    private Long attachmentNo;

    @Column(name = "attachment_original_name")
    @Comment("변환 전 파일 이름")
    @NotNull
    private String attachmentOriginalName;

    @Column(name = "attachment_changed_name")
    @Comment("변환 후 파일 이름")
    @NotNull
    private String attachmentChangedName;

    @Column(name = "attachment_url")
    @Comment("파일 저장 경로")
    @NotNull
    private String attachmentUrl;

    @Column(name = "attachment_category")
    @Comment("파일 카테고리")
    private String attachmentCategory;

    @Column(name = "attachment_filename_extension")
    @Comment("파일 확장자")
    private String attachmentFilenameExtension;

    @Column(name = "achievement_no")
    @Comment("업적 번호")
    private Long achievementNo;
}
