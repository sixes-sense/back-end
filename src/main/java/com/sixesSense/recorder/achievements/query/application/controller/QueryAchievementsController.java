package com.sixesSense.recorder.achievements.query.application.controller;

import com.sixesSense.recorder.achievements.query.application.dto.ReadAchievementsResponse;
import com.sixesSense.recorder.achievements.query.application.service.QueryAchievementsServiceImpl;
import com.sixesSense.recorder.achievements.query.domain.entity.Achievements;
import com.sixesSense.recorder.achievements.query.domain.service.QueryAchievementsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/api/v1/achievements")
@RestController
@RequiredArgsConstructor
@Tag(name = "업적 API")
public class QueryAchievementsController {

    public final QueryAchievementsServiceImpl achievementsService;

    @GetMapping("/all")
    @Operation(summary = "전체 업적 조회", description = "관리자가 만든 모든 업적이 조회 됩니다.")
    @Parameters({
            @Parameter(name = "size", description = "화면에 보여줄 요소의 숫자를 결정합니다.", example = "10"),
            @Parameter(name = "offset", description = "해당 페이지 첫 번째 원소의 수", example = "1"),
            @Parameter(name = "sort", description = "정렬 기준", schema = @Schema(allowableValues = {"achievement_no", "achievement_name", "created_at", "last_modified_at"}),
                        example = "achievement_no", in = ParameterIn.QUERY),
            @Parameter(name = "direction", description = "정렬 방향", schema = @Schema(allowableValues = {"asc", "desc"}), example = "asc")
    })
    public ResponseEntity<Page<ReadAchievementsResponse>> getAchievements(@PageableDefault @Parameter(hidden = true) Pageable pageable) {

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
