package com.sixesSense.recorder.review.command.domain.aggregate.entity;

import com.sixesSense.recorder.common.entity.BaseTimeEntity;
import com.sixesSense.recorder.review.command.application.dto.review.request.CreateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.request.UpdateReviewRequest;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.ReviewWriterVO;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.TagVO;
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
    private TagVO tagNo;

    @Embedded
    private ReviewWriterVO reviewWriter;

    @OneToMany
    private List<Comment> comments;

    public Review(String reviewTitle, String reviewContent, LocalDate reviewDate, Long likeCnt, Long reportCnt, Long bookMarkCnt, TagVO tagNo, ReviewWriterVO reviewWriter) {
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
        this.likeCnt = likeCnt;
        this.reportCnt = reportCnt;
        this.bookMarkCnt = bookMarkCnt;
        this.tagNo = tagNo;
        this.reviewWriter = reviewWriter;
    }

    public static Review toEntity(CreateReviewRequest createReviewRequest){
        return Review.builder()
                .reviewTitle(createReviewRequest.getReviewTitle())
                .reviewContent(createReviewRequest.getReviewContent())
                .likeCnt(0l)
                .reportCnt(0l)
                .bookMarkCnt(0l)
                .tagNo(new TagVO(createReviewRequest.getTagNo()))
                .reviewWriter(new ReviewWriterVO(createReviewRequest.getReviewWriter()))
                .build();
    }


    public void increaseLikesCount() {
        this.likeCnt += 1;
    }

    public void decreaseLikesCount() {
        this.likeCnt = Math.max(0L, this.likeCnt - 1);
    }

    public void updateReview(UpdateReviewRequest updatingReview){
        if(updatingReview.getReviewTitle() != null) {
            this.reviewTitle = updatingReview.getReviewTitle();
        }

        if(updatingReview.getReviewContent() != null){
            this.reviewContent = updatingReview.getReviewContent();
        }
    }

}