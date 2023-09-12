package com.sixesSense.recorder.review.command.application.service;

import com.sixesSense.recorder.review.command.application.dto.like.request.PostLikeRequest;
import com.sixesSense.recorder.review.command.application.dto.like.response.PostLikeResponse;
import com.sixesSense.recorder.review.command.application.dto.review.request.CreateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.request.UpdateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.response.CreateReviewResponse;
import com.sixesSense.recorder.review.command.application.dto.review.response.UpdateReviewResponse;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.ReviewLikes;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.ReviewTag;
import com.sixesSense.recorder.review.command.domain.repository.ReviewRepository;
import com.sixesSense.recorder.review.command.domain.repository.ReviewTagRepository;
import com.sixesSense.recorder.review.command.domain.service.ReviewService;
import com.sixesSense.recorder.review.command.infrastructure.service.ReviewValidService;
import com.sixesSense.recorder.tag.command.application.dto.CreateTagRequest;
import com.sixesSense.recorder.tag.command.application.service.CommandTagServiceImpl;
import com.sixesSense.recorder.tag.command.domain.aggregate.entity.Tag;
import com.sixesSense.recorder.tag.command.domain.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommandReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewValidService reviewInvalidService;

    private final ReviewTagRepository reviewTagRepository;

    private final CommandTagServiceImpl commandTagService;

    private final TagRepository tagRepository;

    @Override
    @Transactional
    public CreateReviewResponse reviewSave(CreateReviewRequest createReviewRequest) {
        /* createReviewRequest -> entity 변환 후 저장, 다시 dto로 변환 후 리턴 */
        Review review = Review.toEntity(createReviewRequest);
        Review createdReview = reviewRepository.save(review);

        if (createReviewRequest.getTagNames() != null && !createReviewRequest.getTagNames().isEmpty()){
            for(String tagName : createReviewRequest.getTagNames()){
                /*
                * 받아온 태그명이 태그 테이블에 존재하는지 확인합니다.
                * 태그명이 없다면 새로 생성하고 있다면 유효성을 통과합니다.
                * 생성된 태그를 조회하고 해당 태그의 아이디와 리뷰 번호를 중간 엔티티에 저장합니다.
                * */
                Tag tag = tagRepository.findByTagName(tagName);

                if (tag == null){
                    CreateTagRequest createTagRequest = new CreateTagRequest(tagName);
                    commandTagService.createTag(createTagRequest);

                    tag = tagRepository.findByTagName(tagName);
                }
                ReviewTag reviewTag = ReviewTag.toEntity(tag.getTagId(), createdReview.getReviewNo());
                reviewTagRepository.save(reviewTag);
            }
        }

        CreateReviewResponse createReviewResponse = CreateReviewResponse.toCreateResponse(createdReview);

        return createReviewResponse;
    }


    @Override
    @Transactional
    public UpdateReviewResponse reviewUpdate(UpdateReviewRequest updateReviewRequest, Long reviewNo) {
        Review review = reviewRepository.findByReviewNo(reviewNo);

        review.updateReview(updateReviewRequest);
        UpdateReviewResponse updateReviewResponse = UpdateReviewResponse.toUpdateResponse(review);

        return updateReviewResponse;
    }

    @Override
    @Transactional
    public void reviewDelete(Long reviewNo) {
        reviewRepository.deleteById(reviewNo);
    }

    @Override
    @Transactional
    public PostLikeResponse countLike(Long reviewNo, PostLikeRequest postLikeRequest) {
        Review review = reviewRepository.findByReviewNo(reviewNo);
        ReviewLikes reviewLikes = ReviewLikes.toEntity(postLikeRequest);

        /* 좋아요 누른적 있는지 체크 후 좋아요 업데이트 */
        PostLikeResponse postLikeResponse = reviewInvalidService.checkLikeIsClicked(review, reviewLikes);

        return postLikeResponse;
    }
}
