package com.sixesSense.recorder.review.command.domain.aggregate.entity;

import com.sixesSense.recorder.common.entity.BaseTimeEntity;
import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.application.dto.request.CreateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.request.UpdateReviewRequest;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.ReviewWriterVO;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.ReviewTagVO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Builder
public class Review extends BaseTimeEntity {

    @Id
    @Column(name = "review_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewNo;

    @Column(name = "review_title")
    private String reviewTitle;

    @Column(name = "review_content")
    private String reviewContent;

    @Column(name = "like_cnt")
    private Long likeCnt;

    @Column(name = "report_cnt")
    private Long reportCnt;

    @Column(name = "book_mark_cnt")
    private Long bookMarkCnt;

    @Embedded
    private ReviewTagVO tagNo;

    @Embedded
    private ReviewWriterVO reviewWriter;

    public Review(String reviewTitle, String reviewContent, LocalDate reviewDate, Long likeCnt, Long reportCnt, Long bookMarkCnt, ReviewTagVO tagNo, ReviewWriterVO reviewWriter) {
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
        this.likeCnt = likeCnt;
        this.reportCnt = reportCnt;
        this.bookMarkCnt = bookMarkCnt;
        this.tagNo = tagNo;
        this.reviewWriter = reviewWriter;
    }

    public static Review toEntity(CreateReviewRequest reviewDTO){
        return Review.builder()
                .reviewTitle(reviewDTO.getReviewTitle())
                .reviewContent(reviewDTO.getReviewContent())
                .likeCnt(reviewDTO.getLikeCnt())
                .reportCnt(reviewDTO.getReportCnt())
                .bookMarkCnt(reviewDTO.getBookMarkCnt())
                .tagNo(new ReviewTagVO(reviewDTO.getTagNo()))
                .reviewWriter(new ReviewWriterVO(reviewDTO.getReviewWriter()))
                .build();
    }


    public void increaseLikesCount() {
        this.likeCnt += 1;
    }

    public void decreaseLikesCount() {
        this.likeCnt = Math.max(0L, this.likeCnt - 1);
    }

    public void updateReview(UpdateReviewRequest updatedReview){
        if(updatedReview.getReviewTitle() != null) {
            this.reviewTitle = updatedReview.getReviewTitle();
        }

        if(updatedReview.getReviewContent() != null){
            this.reviewContent = updatedReview.getReviewContent();
        }
    }
}