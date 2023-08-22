package com.sixesSense.recorder.achievements.query.application.service;

import com.sixesSense.recorder.achievements.query.domain.entity.Achievements;
import com.sixesSense.recorder.achievements.query.domain.service.QueryAchievementsService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryAchievementsServiceImpl implements QueryAchievementsService {


    @Override
    public List<Achievements> getAchievements(Pageable pageable) {

        return null;
    }
}
