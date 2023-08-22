package com.sixesSense.recorder.achievements.query.domain.service;

import com.sixesSense.recorder.achievements.query.domain.entity.Achievements;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QueryAchievementsService {

    List<Achievements> getAchievements(Pageable pageable);
}
