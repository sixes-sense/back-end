package com.sixesSense.recorder.board.command.domain.aggregate.entity;


import com.sixesSense.recorder.common.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "Board_TB")
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;            // 글 작성 번호

    @Column(name = "title", length = 50)
    private String title;       // 제목

    @Column(name = "Content", columnDefinition = "TEXT", nullable = false)
    private String content;     // 본문

    @Column(name = "requester_id", nullable = false)
    private long adminId;       // 작성자(관리자)

    public Board(long id, String title, String content, long adminId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.adminId = adminId;

    }
}