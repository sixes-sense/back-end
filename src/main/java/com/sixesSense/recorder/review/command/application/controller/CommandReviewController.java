package com.sixesSense.recorder.review.command.application.controller;


import com.sixesSense.recorder.review.command.application.dto.like.request.PostLikeRequest;
import com.sixesSense.recorder.review.command.application.dto.like.response.PostLikeResponse;
import com.sixesSense.recorder.review.command.application.dto.review.request.CreateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.request.UpdateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.response.CreateReviewResponse;
import com.sixesSense.recorder.review.command.application.dto.review.response.UpdateReviewResponse;
import com.sixesSense.recorder.review.command.application.service.CommandReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("api/v1/reviews")
@RequiredArgsConstructor
public class CommandReviewController {

    private final CommandReviewServiceImpl reviewService;

    @GetMapping("/write")
    public ResponseEntity<String> writeReviewPage(){
        return ResponseEntity.ok("리뷰 작성 페이지 접근중");
    }

    @PostMapping("/write")
    @ResponseBody
    public ResponseEntity<CreateReviewResponse> writeReview(@RequestBody CreateReviewRequest createRequest){
        CreateReviewResponse createReviewResponse = reviewService.reviewSave(createRequest);
        return ResponseEntity.ok(createReviewResponse);
    }

    @PatchMapping("/{reviewNo}")
    @ResponseBody
    public ResponseEntity<UpdateReviewResponse> updateReview(@RequestBody UpdateReviewRequest updatedReviewDTO){
        UpdateReviewResponse updateReviewResponse = reviewService.reviewUpdate(updatedReviewDTO);
        return ResponseEntity.ok(updateReviewResponse);
    }

    @DeleteMapping("/{reviewNo}")
    @ResponseBody
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewNo){
        reviewService.reviewDelete(reviewNo);
        return ResponseEntity.ok("Review has been deleted successfully");
    }

    @PostMapping("/{reviewNo}/like")
    @ResponseBody
    public ResponseEntity<PostLikeResponse> postLike(@PathVariable Long reviewNo, @RequestBody PostLikeRequest postLikeRequest){
        PostLikeResponse postLikeResponse = reviewService.countLike(reviewNo, postLikeRequest);
        return ResponseEntity.ok(postLikeResponse);
    }
}