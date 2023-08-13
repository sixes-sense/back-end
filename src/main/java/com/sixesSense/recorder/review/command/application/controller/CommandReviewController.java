package com.sixesSense.recorder.review.command.application.controller;

import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("api/v1/reviews")
public class CommandReviewController {

    @PostMapping("/reviews/write")
    public void writeReview(@RequestBody ReviewDTO reviewDTO){

    }
}