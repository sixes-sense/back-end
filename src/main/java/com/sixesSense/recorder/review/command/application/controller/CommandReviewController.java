package com.sixesSense.recorder.review.command.application.controller;

import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.application.service.CommandReviewServiceImpl;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("api/v1/reviews")
@RequiredArgsConstructor
public class CommandReviewController {

    private final CommandReviewServiceImpl reviewService;

    @PostMapping("/write")
    @ResponseBody
    public ResponseEntity<Review> writeReview(@RequestBody ReviewDTO reviewDTO){
        Review review = reviewService.reviewSave(reviewDTO);
        return ResponseEntity.ok(review);
    }
}