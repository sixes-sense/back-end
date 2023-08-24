package com.sixesSense.recorder.board.command.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBoardDTO {
    private String title;           // 제목
    private String content;         // 본문
    private Long adminId;           // 글작성자


}