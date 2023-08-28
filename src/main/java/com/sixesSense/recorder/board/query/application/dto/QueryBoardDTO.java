package com.sixesSense.recorder.board.query.application.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
public class QueryBoardDTO {
    private Long id;            // 요청번호
    private String boardTitle;       // 제목
    private String boardContents;     // 본문
    private int boardHits;
    private LocalDateTime createdAt;       // 작성날짜
    private LocalDateTime lastModifiedAt;   // 수정 날짜
}