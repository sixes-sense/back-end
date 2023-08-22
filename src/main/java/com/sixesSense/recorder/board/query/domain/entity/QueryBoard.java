package com.sixesSense.recorder.board.query.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "BOARD_TB")
public class QueryBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;                // 번호

    @Column(name ="title", length = 50)
    private String title;           // 제목

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;         // 본문

    @Column(name = "create_at")
    private LocalDateTime createAt; // 작성 날짜

    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;   // 수정날짜

    @Column(name = "admin_id", nullable = false)
    private Long adminId;           // 작성자이름
}
