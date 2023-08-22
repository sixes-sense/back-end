package com.sixesSense.recorder.tag.command.domain.service;

import com.sixesSense.recorder.tag.command.application.dto.CreateTagRequest;

public interface TagService {
    void createTag(CreateTagRequest tagRequest);
}
