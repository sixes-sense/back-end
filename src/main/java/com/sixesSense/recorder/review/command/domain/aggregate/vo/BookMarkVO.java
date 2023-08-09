package com.sixesSense.recorder.review.command.domain.aggregate.vo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookMarkVO {

    // 북마크랑 상의 필요
    @Column(name = "book_mark_no")
    private Integer bookMarkNo;

    @Column(name = "book_mark_cnt")
    private Integer bookMarkCnt;
}
