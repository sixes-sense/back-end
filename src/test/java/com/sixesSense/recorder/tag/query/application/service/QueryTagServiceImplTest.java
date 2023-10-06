package com.sixesSense.recorder.tag.query.application.service;

import com.sixesSense.recorder.tag.command.domain.aggregate.entity.Tag;
import com.sixesSense.recorder.tag.command.domain.repository.TagRepository;
import com.sixesSense.recorder.tag.query.domain.entity.QueryTag;
import com.sixesSense.recorder.tag.query.domain.repository.QueryTagRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QueryTagServiceImplTest {

    @Autowired
    private QueryTagServiceImpl tagService;

    @Autowired
    private QueryTagRepository queryTagRepository;

    @Autowired
    private TagRepository tagRepository;

    @DisplayName("전체 태그 조회 확인")
    @Test
    @Transactional
    void testGetAllTags() {
        //given
        Tag tag1 = new Tag("1번 태그");
        Tag tag2 = new Tag("2번 태그");
        tagRepository.saveAll(List.of(tag1, tag2));

        //when
        List<QueryTag> tags = tagService.getAllTags();

        //then
        assertTrue(tags.stream().anyMatch(tag -> tag.getTagName().equals(tag1.getTagName())));
        assertTrue(tags.stream().anyMatch(tag -> tag.getTagName().equals(tag2.getTagName())));
    }
}