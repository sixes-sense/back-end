package com.sixesSense.recorder.board.command.application.service;

import com.sixesSense.recorder.board.command.domain.aggregate.entity.Board;
import com.sixesSense.recorder.board.command.domain.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteBoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public DeleteBoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public void delete(Long id) {

        Board board = boardRepository.findById(id)
                // Optional 객체에서 값이 존재하면 해당 값을 반환, 없으면 RuntimeException을 발생
                .orElseThrow(RuntimeException::new);

        boardRepository.delete(board);

    }
}
