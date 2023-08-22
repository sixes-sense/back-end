package com.sixesSense.recorder.achievements.query.domain.repository;

import com.sixesSense.recorder.achievements.query.domain.entity.Achievements;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface AchievementsMapper {

    List<Achievements> getAchievements(Pageable pageable);

    void insertAchievements(Achievements achievements);
}
