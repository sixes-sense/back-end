package com.sixesSense.recorder.achievements.query.application.service;

import com.sixesSense.recorder.achievements.query.application.dto.ReadAchievementsResponse;
import com.sixesSense.recorder.achievements.query.domain.entity.Achievements;
import com.sixesSense.recorder.achievements.query.domain.repository.AchievementsMapper;
import com.sixesSense.recorder.achievements.query.domain.service.QueryAchievementsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAchievementsServiceImpl implements QueryAchievementsService {

    private final AchievementsMapper achievementsMapper;
    private final ModelMapper modelMapper;

    @Override
    public Page<ReadAchievementsResponse> getAchievements(Pageable pageable) throws Exception {

        List<Achievements> achievements = achievementsMapper.getAchievements(pageable);
        Long size = achievementsMapper.getAchievementsSize();

        if((achievements.isEmpty() || achievements == null) || size == null) {
            throw new Exception("NOT_FOUND_ACHIEVEMENTS");
        } else {
            List<ReadAchievementsResponse> readAchievementsResponses = achievements.stream().map(achievement -> modelMapper.map(achievement, ReadAchievementsResponse.class)).collect(Collectors.toList());
            return new PageImpl<>(readAchievementsResponses, pageable, size);
        }
    }
}
