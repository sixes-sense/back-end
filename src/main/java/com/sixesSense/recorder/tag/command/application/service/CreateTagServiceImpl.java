package com.sixesSense.recorder.tag.command.application.service;

import com.sixesSense.recorder.tag.command.application.dto.CreateTagRequest;
import com.sixesSense.recorder.tag.command.domain.aggregate.entity.Tag;
import com.sixesSense.recorder.tag.command.domain.repository.TagRepository;
import com.sixesSense.recorder.tag.command.domain.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateTagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    public CreateTagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    @Transactional
    public void createTag(CreateTagRequest tagRequest) {
        if (tagRequest == null || tagRequest.getTagName() == null || tagRequest.getTagName().isEmpty()) {
            // 유효성 검사 실패 처리
            throw new IllegalArgumentException("잘못된 태그 요청입니다.");
        }

        String tagName = tagRequest.getTagName();

        // 중복 검사
        if (tagRepository.existsByTagName(tagName)) {
            throw new IllegalArgumentException("이미 존재하는 태그입니다.");
        }

        Tag tag = new Tag(tagRequest.getTagName());
        tagRepository.save(tag);
    }
}
