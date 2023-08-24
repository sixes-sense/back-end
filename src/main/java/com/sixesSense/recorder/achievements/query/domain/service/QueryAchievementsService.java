package com.sixesSense.recorder.achievements.query.domain.service;

import com.sixesSense.recorder.achievements.query.application.dto.ReadAchievementsResponse;
import com.sixesSense.recorder.achievements.query.domain.entity.Achievements;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QueryAchievementsService {

    Page<ReadAchievementsResponse> getAchievements(Pageable pageable) throws Exception;
}
