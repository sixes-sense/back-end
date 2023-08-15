package com.sixesSense.recorder.achievementsDomain.command.domain.repository;

import com.sixesSense.recorder.achievementsDomain.command.domain.aggregate.entity.Achievements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AchievementsRepository extends JpaRepository<Achievements, Integer> {
}