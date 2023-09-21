package com.sixesSense.recorder.tag.command.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CreateTagRequest {

    private Long tagId;
    private String tagName;

    public CreateTagRequest() {

    }

    public CreateTagRequest(String tagName) {
        this.tagName = tagName;
    }
}
