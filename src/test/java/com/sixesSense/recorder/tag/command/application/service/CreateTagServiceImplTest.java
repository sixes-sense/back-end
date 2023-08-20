package com.sixesSense.recorder.tag.command.application.service;

import com.sixesSense.recorder.tag.command.application.dto.CreateTagDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;


@SpringBootTest
@Transactional
class CreateTagServiceImplTest {

    @Autowired
    private CreateTagServiceImpl createTagService;

    static Stream<String> tagNamesProvider() {
        return Stream.of("Tag1", "Tag2", "Tag3");
    }

    @DisplayName("@MethodSource를 활용한 tag 저장 테스트")
    @ParameterizedTest
    @MethodSource("tagNamesProvider")
    void createTag(String tagName) {
        // Given
        CreateTagDTO tagDTO = new CreateTagDTO();
        tagDTO.setTagName(tagName);

        // When
        boolean result = createTagService.createTag(tagDTO);

        // Then
        Assertions.assertTrue(result);
    }
}