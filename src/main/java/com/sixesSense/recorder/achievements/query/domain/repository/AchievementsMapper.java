package com.sixesSense.recorder.achievements.query.domain.repository;

import com.sixesSense.recorder.achievements.query.domain.entity.Achievements;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AchievementsMapper {

    List<Achievements> getAchievements();

    void insertAchievements(Achievements achievements);
}
