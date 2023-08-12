package com.sixesSense.recorder.review.command.domain.aggregate.entity;

import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.ReviewWriterVO;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.TagVO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Review {

    @Id
    @Column(name = "review_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewNo;

    @Column(name = "review_title")
    private String reviewTitle;

    @Column(name = "review_content")
    private String reviewContent;

    @Column(name = "review_date")
    private LocalDate reviewDate;

    @Column(name = "like_cnt")
    private Long likeCnt;

    @Column(name = "report_cnt")
    private Long reportCnt;

    @Column(name = "book_mark_cnt")
    private Long bookMarkCnt;

    @Embedded
    private TagVO tagNo;

    @Embedded
    private ReviewWriterVO reviewWriter;

    public Review(String reviewTitle, String reviewContent, LocalDate reviewDate, Long likeCnt, Long reportCnt, Long bookMarkCnt, TagVO tagNo, ReviewWriterVO reviewWriter) {
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.likeCnt = likeCnt;
        this.reportCnt = reportCnt;
        this.bookMarkCnt = bookMarkCnt;
        this.tagNo = tagNo;
        this.reviewWriter = reviewWriter;
    }

    public static Review toEntity(ReviewDTO reviewDTO){
        return new Review(
                reviewDTO.getReviewTitle(),
                reviewDTO.getReviewContent(),
                reviewDTO.getReviewDate(),
                reviewDTO.getLikeCnt(),
                reviewDTO.getReportCnt(),
                reviewDTO.getBookMarkCnt(),
                new TagVO(reviewDTO.getTagNo()),
                new ReviewWriterVO(reviewDTO.getReviewWriter())
                );
    }
}