package com.sixesSense.recorder.tag.command.application.service;

import com.sixesSense.recorder.tag.command.application.dto.CreateTagRequest;
import com.sixesSense.recorder.tag.command.domain.aggregate.entity.Tag;
import com.sixesSense.recorder.tag.command.domain.repository.TagRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class CreateTagServiceImplTests {

    @Autowired
    private CreateTagServiceImpl tagService;

    @Autowired
    private TagRepository tagRepository;

    @DisplayName("정상적으로 태그가 생성되었는지 확인")
    @Test
    void testCreateTag1() {
        CreateTagRequest validTagRequest = new CreateTagRequest("NewTag");
        tagService.createTag(validTagRequest);

        assertTrue(tagRepository.existsByTagName(validTagRequest.getTagName()));
    }

    @DisplayName("중복된 태그 생성 시 예외 발생 확인")
    @Test
    void testCreateTag2() {

        tagRepository.save(new Tag("ExistingTag"));

        CreateTagRequest duplicateTagRequest = new CreateTagRequest("ExistingTag");

        assertThrows(IllegalArgumentException.class, () -> {
            tagService.createTag(duplicateTagRequest);
        });
    }
    @DisplayName("유효하지 않은 태그 요청 시 예외가 발생하는지 확인")
    @Test
    void testCreateTag3() {
        CreateTagRequest invalidTagRequest = new CreateTagRequest(null);

        assertThrows(IllegalArgumentException.class, () -> {
            tagService.createTag(invalidTagRequest);
        });
    }
}