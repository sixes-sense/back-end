package com.sixesSense.recorder.review.command.application.controller.object;

import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.ReviewWriterVO;
import com.sixesSense.recorder.review.command.domain.aggregate.vo.TagVO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestObjects {

    public static Review createContentWithReview(String title, String content){
        ReviewWriterVO reviewWriter = new ReviewWriterVO();
        TagVO tag = new TagVO();

        return new Review(title, content, LocalDate.now(), 0L, 0L, 0L, tag, reviewWriter);
    }
}
