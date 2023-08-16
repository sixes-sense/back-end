package com.sixesSense.recorder.review.query.application.controller;

import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.query.application.dto.QueryReviewDTO;
import com.sixesSense.recorder.review.query.application.dto.response.ReadReviewResponse;
import com.sixesSense.recorder.review.query.application.service.QueryReviewServiceImpl;
import lombok.Getter;
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
    public ResponseEntity<ReadReviewResponse> reviewLists(@PageableDefault(sort = "review_no", direction = Sort.Direction.DESC) Pageable pageable){
        Page<QueryReviewDTO> reviewPages = queryReviewService.getReviews(pageable);

        ReadReviewResponse<Long> response = new ReadReviewResponse();

        response.setSuccess(true);
        response.setCode(200);
        response.setMessage("Review all selected");
        response.setData(reviewPages.getTotalElements());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{reviewNo}")
    @ResponseBody
    public ResponseEntity<ReadReviewResponse> reviewDetail(@PathVariable Long reviewNo){
        QueryReviewDTO reviewDetail = queryReviewService.getReviewDetail(reviewNo);

        if(reviewDetail == null){
            return ResponseEntity.notFound().build();
        }

        ReadReviewResponse<Long> response = new ReadReviewResponse();

        response.setSuccess(true);
        response.setCode(200);
        response.setMessage("Review all selected");
        response.setData(reviewDetail.getReviewNo());

        return ResponseEntity.ok(response);
    }
}
