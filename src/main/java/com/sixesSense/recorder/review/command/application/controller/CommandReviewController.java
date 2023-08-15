package com.sixesSense.recorder.review.command.application.controller;

import com.sixesSense.recorder.review.command.application.dto.ReviewDTO;
import com.sixesSense.recorder.review.command.application.dto.ReviewLikesDTO;
import com.sixesSense.recorder.review.command.application.service.CommandReviewServiceImpl;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.ReviewLikes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public ResponseEntity<ReviewDTO> writeReview(@RequestBody ReviewDTO reviewDTO){
        reviewService.reviewSave(reviewDTO);
        return new ResponseEntity<>(reviewDTO, HttpStatus.OK);
    }

    @PatchMapping("/{reviewNo}")
    @ResponseBody
    public ResponseEntity<Long> updateReview(@RequestBody ReviewDTO updatedReviewDTO, @PathVariable Long reviewNo){
        if (!(reviewService.reviewUpdate(updatedReviewDTO))) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(reviewNo);
    }

    @DeleteMapping("/{reviewNo}")
    @ResponseBody
    public ResponseEntity<Long> deleteReview(@PathVariable Long reviewNo){
        reviewService.reviewDelete(reviewNo);
        return ResponseEntity.ok(reviewNo);
    }

    @PostMapping("/{reviewNo}/like")
    @ResponseBody
    public ResponseEntity<ReviewLikesDTO> postLike(@PathVariable Long reviewNo, @RequestBody ReviewLikesDTO clickLikesDTO){
        ReviewLikesDTO reviewLikes = reviewService.countLike(reviewNo, clickLikesDTO);
        return ResponseEntity.ok(reviewLikes);
    }

//    @DeleteMapping("/{reviewNo}/like")
//    @ResponseBody
//    public ResponseEntity<ReviewLikesDTO> deleteLike(@PathVariable Long reviewNo, @RequestBody ReviewLikesDTO clickedLikesDTO){
//        ReviewLikesDTO reviewLikesDTO = reviewService.minusLike(reviewNo, clickedLikesDTO);
//        return ResponseEntity.ok(reviewLikesDTO);
//    }

}