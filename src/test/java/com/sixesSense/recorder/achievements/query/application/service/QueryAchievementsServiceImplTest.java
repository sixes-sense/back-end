package com.sixesSense.recorder.achievements.query.application.service;

import com.sixesSense.recorder.achievements.command.domain.aggregate.entity.Achievements;
import com.sixesSense.recorder.achievements.command.domain.repository.AchievementsRepository;
import com.sixesSense.recorder.achievements.query.domain.repository.AchievementsMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
class QueryAchievementsServiceImplTest {

    private static Stream<Arguments> getAchievementsInfo() {
        return Stream.of(
                Arguments.of(
                    1L,
                        "업적1"
                ),
                Arguments.of(
                        2L,
                        "업적2"
                )
        );
    }

    @Autowired
    private AchievementsMapper achievementsMapper;

    @Autowired
    private AchievementsRepository achievementsRepository;

    @ParameterizedTest
    @MethodSource("getAchievementsInfo")
    @DisplayName("업적 목록 조회")
    void testFIndAchievementsList(Long no, String description) {
        //given
        Achievements achievements = new Achievements(no, description);

        //when

    }
}