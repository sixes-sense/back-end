package com.sixesSense.recorder.tag.command.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CreateTagDTO {

    private Long tagId;
    private String tagName;
}
