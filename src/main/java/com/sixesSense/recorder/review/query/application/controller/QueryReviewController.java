package com.sixesSense.recorder.review.query.application.controller;


import com.sixesSense.recorder.review.query.application.dto.response.ReadReviewResponse;
import com.sixesSense.recorder.review.query.application.service.QueryReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1/reviews")
@RequiredArgsConstructor
public class QueryReviewController {

    private final QueryReviewServiceImpl queryReviewService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<Page<ReadReviewResponse>> reviewLists(@PageableDefault(sort = "review_no", direction = Sort.Direction.DESC) Pageable pageable){
        Page<ReadReviewResponse> readReviewResponses = queryReviewService.getReviews(pageable);

        return ResponseEntity.ok(readReviewResponses);
    }

    @GetMapping("/{reviewNo}")
    @ResponseBody
    public ResponseEntity<ReadReviewResponse> reviewDetail(@PathVariable Long reviewNo){
        ReadReviewResponse readReviewResponse = queryReviewService.getReviewDetail(reviewNo);

        return ResponseEntity.ok(readReviewResponse);
    }
}
