package com.sixesSense.recorder.review.command.domain.aggregate.entity;

import com.sixesSense.recorder.review.command.domain.aggregate.vo.BookMarkVO;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.ReportVO;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.ReviewWriterVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Review {

    @Id
    @Column(name = "review_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewNo;

    @Column(name = "review_content")
    private String reviewContent;

    @Column(name = "review_date")
    private LocalDate reviewDate;

    @Column(name = "like_cnt")
    private Integer likeCnt;

    @Embedded
    private ReviewWriterVO reviewWriter;

    @Embedded
    private BookMarkVO bookMarkCnt;

    @Embedded
    private ReportVO reportCnt;

}