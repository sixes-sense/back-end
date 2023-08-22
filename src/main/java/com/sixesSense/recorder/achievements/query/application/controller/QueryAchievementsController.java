package com.sixesSense.recorder.achievements.query.application.controller;

import com.sixesSense.recorder.achievements.query.application.dto.ReadAchievementsResponse;
import com.sixesSense.recorder.achievements.query.application.service.QueryAchievementsServiceImpl;
import com.sixesSense.recorder.achievements.query.domain.entity.Achievements;
import com.sixesSense.recorder.achievements.query.domain.service.QueryAchievementsService;
import lombok.RequiredArgsConstructor;
import org.apache.http.Header;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

    public final QueryAchievementsServiceImpl achievementsService;

    @GetMapping("/all")
    public ResponseEntity<Page<ReadAchievementsResponse>> getAchievements(@PageableDefault Pageable pageable) {

        try{
            Page<ReadAchievementsResponse> achievementsList = achievementsService.getAchievements(pageable);
            return ResponseEntity.ok(achievementsList);
        } catch (Exception e) {
            e.printStackTrace();

            String message = e.getMessage();
            return new ResponseEntity(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
