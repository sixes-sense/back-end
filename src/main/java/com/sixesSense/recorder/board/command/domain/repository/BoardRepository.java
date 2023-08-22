package com.sixesSense.recorder.board.command.domain.repository;

import com.sixesSense.recorder.board.command.domain.aggregate.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
