package com.sixesSense.recorder.attachments.command.domain.aggregate.entity;

import org.hibernate.annotations.Comment;

import javax.persistence.*;


@Entity
@Table(name = "Attachments_TB")
public class Attachments {

    @Id
    @GeneratedValue
    @Column(name = "attachment_no")
    @Comment("파일 번호")
    private Long attachmentNo;

    @Column(name = "attachment_originalal_name")
    @Comment("변환 전 파일 이름")
    private String attachmentOriginalName;

    @Column(name = "attachment_changed_name")
    @Comment("변환 후 파일 이름")
    private String attachmentChangedName;

    @Column(name = "attachment_url")
    @Comment("파일 저장 경로")
    private String attachmentUrl;

    @Column(name = "attachment_category")
    @Comment("파일 카테고리")
    private Integer attachementCategory;
}
