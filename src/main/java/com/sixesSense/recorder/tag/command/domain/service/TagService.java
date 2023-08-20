package com.sixesSense.recorder.tag.command.domain.service;

import com.sixesSense.recorder.tag.command.application.dto.CreateTagDTO;

public interface TagService {
    boolean createTag(CreateTagDTO tagDTO);
}
