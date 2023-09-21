package com.sixesSense.recorder.tag.command.application.controller;

import com.sixesSense.recorder.tag.command.application.dto.CreateTagRequest;
import com.sixesSense.recorder.tag.command.application.service.CommandTagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tag")
public class CommandTagController {
    private final CommandTagServiceImpl tagService;

    @Autowired
    public CommandTagController(CommandTagServiceImpl tagService) {
        this.tagService = tagService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> createTag(@RequestBody CreateTagRequest tagRequest) {

        tagService.createTag(tagRequest);
        return ResponseEntity.ok("태그가 저장되었습니다.");
    }
}
