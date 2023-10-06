package com.sixesSense.recorder.tag.command.application.controller;

import com.sixesSense.recorder.tag.command.application.dto.CreateTagRequest;
import com.sixesSense.recorder.tag.command.application.service.CommandTagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/tag")
public class CommandTagController {
    private final CommandTagServiceImpl tagService;

    @Autowired
    public CommandTagController(CommandTagServiceImpl tagService) {
        this.tagService = tagService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> createTag(@Valid @RequestBody CreateTagRequest tagRequest) {
        try {
            tagService.createTag(tagRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("태그가 성공적으로 저장되었습니다.");
        } catch (IllegalArgumentException e) {
            // 서비스에서 던진 IllegalArgumentException 처리
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // 그 외 예외 처리
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("태그 저장 중 오류 발생: " + e.getMessage());
        }
    }

}
