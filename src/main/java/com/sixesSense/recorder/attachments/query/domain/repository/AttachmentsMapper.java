package com.sixesSense.recorder.attachments.query.domain.repository;

import com.sixesSense.recorder.attachments.query.domain.aggregate.entity.Attachments;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttachmentsMapper {
    void insertAttachment(Attachments attachments);
}
