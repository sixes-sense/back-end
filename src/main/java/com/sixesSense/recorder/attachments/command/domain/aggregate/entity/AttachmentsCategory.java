package com.sixesSense.recorder.attachments.command.domain.aggregate.entity;

import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AttachmentsCategory_TB")
public class AttachmentsCategory {

    @Id
    @Column(name = "attachment_category_no")
    @Comment("파일 카테고리 번호")
    private Integer attachmentCategoryNo;

    @Column(name = "attachment_category_name")
    @Comment("파일 카테고리 이름")
    private String attachementCategoryName;
}
