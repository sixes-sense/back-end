package com.sixesSense.recorder.board.command.domain.repository;

import com.sixesSense.recorder.board.command.domain.aggregate.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    // update board_table set board_hits=board_hits+1 where id=?
}
