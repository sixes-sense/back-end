package com.sixesSense.recorder.achievements.query.application.service;

import com.sixesSense.recorder.achievements.command.domain.repository.AchievementsRepository;
import com.sixesSense.recorder.achievements.query.domain.entity.Achievements;
import com.sixesSense.recorder.achievements.query.domain.repository.AchievementsMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
                        1L,
                        LocalDateTime.now(),
                        LocalDateTime.now()
                )
        );
    }

    @Autowired
    private AchievementsMapper achievementsMapper;

    @ParameterizedTest
    @MethodSource("getAchievementsInfo")
    @DisplayName("업적 목록 조회")
    void testFIndAchievementsList(String name, String description, Long attachmentNo, LocalDateTime created, LocalDateTime updated) {
        //given
        Achievements achievements = new Achievements(name, description, attachmentNo, created, updated);
//        achievementsMapper.insertAchievements(achievements);
        //when
        List<Achievements> list = achievementsMapper.getAchievements();

        //then
        assertDoesNotThrow(
                () -> !list.isEmpty() && list != null
        );
    }
}