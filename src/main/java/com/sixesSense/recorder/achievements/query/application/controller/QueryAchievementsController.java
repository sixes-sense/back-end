package com.sixesSense.recorder.achievements.query.application.controller;

import com.sixesSense.recorder.achievements.query.domain.entity.Achievements;
import com.sixesSense.recorder.achievements.query.domain.service.QueryAchievementsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("achievements")
@RestController
@RequiredArgsConstructor
public class QueryAchievementsController {

    public final QueryAchievementsService achievementsService;

    @GetMapping("/all")
    public ResponseEntity getAchievements(@PageableDefault Pageable pageable) {

        List<Achievements> achievementsList = achievementsService.getAchievements(pageable);

        return null;
    }
}
