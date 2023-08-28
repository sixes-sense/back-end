package com.sixesSense.recorder.board.command.domain.aggregate.entity;

import com.sixesSense.recorder.board.command.application.dto.BoardDTO;
import com.sixesSense.recorder.common.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "board_table")
public class BoardEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment (mysql 기준)
    @Column(name = "id")
    private Long id;

    @Column(name = "board_title", length = 50)
    private String boardTitle;       // 제목

    @Column(length = 500, name = "board_content", columnDefinition = "TEXT")
    private String boardContents;     // 본문

    @Column
    private int boardHits;


    public static BoardEntity toSaveEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(0);    // 조회수 기본 값은 0이니까
//        return null;
        return boardEntity;
    }
}
