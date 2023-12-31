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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 아이디 자동생성
    @Column(name = "id")
    private Long id;            // 글 작성 번호

    @Column(name = "title", length = 50)
    private String title;       // 제목

    @Column(name = "Content", columnDefinition = "TEXT")
    private String content;     // 본문

    @Column(name = "admin_id", nullable = false)
    private Long adminId;       // 작성자(관리자)

    public Board(String title, String content, Long adminId) {
        this.title = title;
        this.content = content;
        this.adminId = adminId;

    }
}