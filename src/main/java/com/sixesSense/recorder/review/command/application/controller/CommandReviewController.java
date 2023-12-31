package com.sixesSense.recorder.review.command.application.controller;


import com.sixesSense.recorder.review.command.application.dto.comment.request.CreateCommentRequest;
import com.sixesSense.recorder.review.command.application.dto.comment.response.CreateCommentResponse;
import com.sixesSense.recorder.review.command.application.dto.like.request.PostLikeRequest;
import com.sixesSense.recorder.review.command.application.dto.like.response.PostLikeResponse;
import com.sixesSense.recorder.review.command.application.dto.review.request.CreateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.request.UpdateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.response.CreateReviewResponse;
import com.sixesSense.recorder.review.command.application.dto.review.response.UpdateReviewResponse;
import com.sixesSense.recorder.review.command.application.service.CommandCommentServiceImpl;
import com.sixesSense.recorder.review.command.application.service.CommandReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/reviews")
@RequiredArgsConstructor
public class CommandReviewController {

    private final CommandReviewServiceImpl reviewService;

    private final CommandCommentServiceImpl commandCommentService;

    @GetMapping("/write")
    public ResponseEntity<String> writeReviewPage(){
        return ResponseEntity.ok("리뷰 작성 페이지 접근중");
    }

    @PostMapping("/write")
    public ResponseEntity<CreateReviewResponse> writeReview(@RequestBody CreateReviewRequest createRequest){
        CreateReviewResponse createReviewResponse = reviewService.reviewSave(createRequest);
        return ResponseEntity.ok(createReviewResponse);
    }

    @PatchMapping("/{reviewNo}")
    public ResponseEntity<UpdateReviewResponse> updateReview(@RequestBody UpdateReviewRequest updateReviewRequest, @PathVariable Long reviewNo){
        UpdateReviewResponse updateReviewResponse = reviewService.reviewUpdate(updateReviewRequest, reviewNo);
        return ResponseEntity.ok(updateReviewResponse);
    }

    @DeleteMapping("/{reviewNo}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewNo){
        reviewService.reviewDelete(reviewNo);
        return ResponseEntity.ok("Review has been deleted successfully");
    }

    @PostMapping("/{reviewNo}/like")
    public ResponseEntity<PostLikeResponse> postLike(@PathVariable Long reviewNo, @RequestBody PostLikeRequest postLikeRequest){
        PostLikeResponse postLikeResponse = reviewService.countLike(reviewNo, postLikeRequest);
        return ResponseEntity.ok(postLikeResponse);
    }

    @PostMapping("/{reviewNo}/comment")
    public ResponseEntity<CreateCommentResponse> create(@PathVariable Long reviewNo, @RequestBody CreateCommentRequest request){
        CreateCommentResponse response = commandCommentService.createComment(request, reviewNo);

        return ResponseEntity.ok(response);
    }

}