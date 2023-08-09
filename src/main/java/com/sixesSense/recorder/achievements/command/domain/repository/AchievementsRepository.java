package com.sixesSense.recorder.achievements.command.domain.repository;

import com.sixesSense.recorder.achievements.command.domain.aggregate.entity.Achievements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AchievementsRepository extends JpaRepository<Achievements, Integer> {
}