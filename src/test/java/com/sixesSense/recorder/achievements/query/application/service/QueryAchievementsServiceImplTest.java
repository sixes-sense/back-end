package com.sixesSense.recorder.achievements.query.application.service;

import com.sixesSense.recorder.achievements.query.domain.entity.Achievements;
import com.sixesSense.recorder.achievements.query.domain.repository.AchievementsMapper;
import com.sixesSense.recorder.attachments.query.domain.aggregate.entity.Attachments;
import com.sixesSense.recorder.attachments.query.domain.repository.AttachmentsMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@Transactional
class QueryAchievementsServiceImplTest {

    private static Stream<Arguments> getAchievementsInfo() {
        return Stream.of(
                Arguments.of(
                        "업적1",
                        "업적1",
                        LocalDateTime.now(),
                        LocalDateTime.now()
                )
        );
    }

    @Autowired
    private AchievementsMapper achievementsMapper;

    @Autowired
    private AttachmentsMapper attachmentsMapper;

    @ParameterizedTest
    @MethodSource("getAchievementsInfo")
    @DisplayName("업적 목록 조회")
    void testFindAchievementsList(String name, String description, LocalDateTime created, LocalDateTime updated) {
        //given
        PageRequest pageable = PageRequest.of(0, 10);

        Achievements achievements = new Achievements(4L, name, description, created, updated);
        achievementsMapper.insertAchievements(achievements);

        Attachments attachments = new Attachments(4L, "모니터앞 코기", "모니터앞 코기", "업적", "/assets/img/", ".jpg", 4L, LocalDateTime.now(), LocalDateTime.now());
        attachmentsMapper.insertAttachment(attachments);

        //when
        List<Achievements> list = achievementsMapper.getAchievements(pageable);

        //then
        assertDoesNotThrow(
                () -> !list.isEmpty() && list != null
        );
    }
}