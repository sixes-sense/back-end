package com.sixesSense.recorder.board.command.application.dto;

import com.sixesSense.recorder.board.command.domain.aggregate.entity.Board;
import com.sixesSense.recorder.board.command.domain.aggregate.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

// DTO(Data Transfer Object), VO, Bean,         Entity
@Getter
@Setter
@ToString
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
public class BoardDTO {
    private Long id;
    private String BoardTitle;
    private String boardContents;
    private int boardHits;              // 게시글 조회수
    private LocalDateTime createdAt;       // 작성날짜
    private LocalDateTime lastModifiedAt;   // 수정 날짜

//    public static BoardDTO toBoardDTO(BoardEntity boardEntity) {
//        BoardDTO boardDTO = new BoardDTO();
//        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
//        boardDTO.setBoardContents(boardEntity.getBoardContents());
//        boardDTO.setBoardHits(boardEntity.getBoardHits());
//        boardDTO.setlastModifiedAt(boardEntity.getlastModifiedAt());
//
//    }

}
