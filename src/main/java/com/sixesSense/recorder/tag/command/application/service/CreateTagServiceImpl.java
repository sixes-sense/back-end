package com.sixesSense.recorder.tag.command.application.service;

import com.sixesSense.recorder.tag.command.application.dto.CreateTagDTO;
import com.sixesSense.recorder.tag.command.domain.aggregate.entity.Tag;
import com.sixesSense.recorder.tag.command.domain.repository.TagRepository;
import com.sixesSense.recorder.tag.command.domain.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    public CreateTagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public boolean createTag(CreateTagDTO tagDTO) {

        Tag tag = new Tag(tagDTO.getTagName());
        Tag savedTag = tagRepository.save(tag);

        if ((savedTag.getTagName()).equals(tag.getTagName())) {
            return true;
        } else {
            return false;
        }

    }
}
