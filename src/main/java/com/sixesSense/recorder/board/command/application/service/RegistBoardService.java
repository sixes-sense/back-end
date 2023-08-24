package com.sixesSense.recorder.board.command.application.service;

import com.sixesSense.recorder.board.command.application.dto.CreateBoardDTO;
import com.sixesSense.recorder.board.command.domain.aggregate.entity.Board;
import com.sixesSense.recorder.board.command.domain.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistBoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public RegistBoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void create(CreateBoardDTO createBoardDTO) {

        // DTO -> Entity 변환 작업
        String title = createBoardDTO.getTitle();
        String content = createBoardDTO.getContent();
        Long adminId = createBoardDTO.getAdminId();

        Board board = new Board(title, content, adminId);

        boardRepository.save(board);
    }
}
