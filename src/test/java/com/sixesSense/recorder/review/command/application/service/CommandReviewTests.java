package com.sixesSense.recorder.review.command.application.service;


import com.sixesSense.recorder.review.command.application.dto.like.request.PostLikeRequest;
import com.sixesSense.recorder.review.command.application.dto.like.response.PostLikeResponse;
import com.sixesSense.recorder.review.command.application.dto.review.request.CreateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.request.SearchReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.request.UpdateReviewRequest;
import com.sixesSense.recorder.review.command.application.dto.review.response.CreateReviewResponse;
import com.sixesSense.recorder.review.command.application.dto.review.response.SearchReviewResponse;
import com.sixesSense.recorder.review.command.application.dto.review.response.UpdateReviewResponse;
import com.sixesSense.recorder.review.command.application.service.object.TestObjects;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.Review;
import com.sixesSense.recorder.review.command.domain.aggregate.entity.ReviewTag;
import com.sixesSense.recorder.review.command.domain.repository.ReviewRepository;
import com.sixesSense.recorder.review.command.domain.repository.ReviewTagRepository;
import com.sixesSense.recorder.review.query.application.dto.response.ReadReviewResponse;
import com.sixesSense.recorder.review.query.application.service.QueryReviewServiceImpl;
import com.sixesSense.recorder.review.query.domain.repository.ReviewMapper;
import com.sixesSense.recorder.tag.command.domain.aggregate.entity.Tag;
import com.sixesSense.recorder.tag.command.domain.repository.TagRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@Transactional
public class CommandReviewTests {

    @Autowired
    private CommandReviewServiceImpl commandReviewService;

    @Autowired
    private QueryReviewServiceImpl queryReviewService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private ReviewTagRepository reviewTagRepository;

    @Autowired
    private TagRepository tagRepository;



    @DisplayName("리뷰를 등록할때 태그 유효성 검사 후 리뷰를 등록하는지")
    @Test
    void createReview() {
        CreateReviewRequest review = TestObjects.createContentWithReview();

        CreateReviewResponse createReviewResponse = commandReviewService.reviewSave(review);

        /* 리뷰 등록 및 리뷰 태그 생성 확인 */
        for (String tagName : review.getTagNames()){
            Tag tag = tagRepository.findByTagName(tagName);
            ReviewTag reviewTag = reviewTagRepository.findByTagIdAndReviewNo(tag.getTagId(), createReviewResponse.getReviewNo());

            Assertions.assertNotNull(reviewTag, "리뷰 태그가 생성되지 않았습니다.");
        }

        Assertions.assertNotNull(createReviewResponse, "리뷰가 생성되지 않았습니다.");
    }

    @DisplayName("리뷰 전체 조회 테스트")
    @Test
    void readReviews() {
        List<ReadReviewResponse> reviewDTOList = reviewMapper.reviewLists();

        Assertions.assertNotNull(reviewDTOList);
    }

    @DisplayName("리뷰 상세 조회 테스트")
    @Test
    void readReviewByReviewNo() {
        Long reviewNo = 1L;

        ReadReviewResponse review = reviewMapper.reviewListByReviewNo(reviewNo);

        Assertions.assertNotNull(review);
    }

    @DisplayName("리뷰 제목만 수정")
    @Test
    void updateReviewWithTitle(){
        Long reviewNo = 1L;
        ReadReviewResponse review = reviewMapper.reviewListByReviewNo(1l);
        UpdateReviewRequest updatingReview = TestObjects.updateContentWithReview(review,
                Optional.of("제목 업데이트"),
                Optional.empty());

        UpdateReviewResponse updateReviewResponse = commandReviewService.reviewUpdate(updatingReview, reviewNo);

        Assertions.assertTrue(
                updatingReview.getReviewTitle().equals(updateReviewResponse.getReviewTitle()) &&
                        updatingReview.getReviewContent().equals(updateReviewResponse.getReviewContent())
        );
    }

    @DisplayName("리뷰 내용만 수정")
    @Test
    void updateReviewWithContent(){
        Long reviewNo = 1L;
        ReadReviewResponse review = reviewMapper.reviewListByReviewNo(1l);
        UpdateReviewRequest updatingReview = TestObjects.updateContentWithReview(review,
                Optional.empty(),
                Optional.of("내용 업데이트"));

        UpdateReviewResponse updateReviewResponse = commandReviewService.reviewUpdate(updatingReview, reviewNo);

        Assertions.assertTrue(
                updatingReview.getReviewTitle().equals(updateReviewResponse.getReviewTitle()) &&
                        updatingReview.getReviewContent().equals(updateReviewResponse.getReviewContent())
        );
    }

    @DisplayName("리뷰 둘다 수정")
    @Test
    void updateReviewAll(){
        Long reviewNo = 1L;
        ReadReviewResponse review = reviewMapper.reviewListByReviewNo(1l);
        UpdateReviewRequest updatingReview = TestObjects.updateContentWithReview(review,
                Optional.of("제목 업데이트"),
                Optional.of("내용 업데이트"));

        UpdateReviewResponse updateReviewResponse = commandReviewService.reviewUpdate(updatingReview, reviewNo);

        Assertions.assertTrue(
                updatingReview.getReviewTitle().equals(updateReviewResponse.getReviewTitle()) &&
                        updatingReview.getReviewContent().equals(updateReviewResponse.getReviewContent())
        );
    }

    @DisplayName("리뷰 삭제 확인")
    @Test
    void deleteReview(){
        Long reviewNo = 1L;

        Assertions.assertDoesNotThrow(
                () -> commandReviewService.reviewDelete(reviewNo)
        );

        Assertions.assertNull(reviewRepository.findByReviewNo(reviewNo));
    }

    @DisplayName("좋아요 증가 확인")
    @Test
    void increaseReviewLike(){
        Long reviewNo = 15L;
        PostLikeRequest postLikeRequest = TestObjects.countReviewLike(1l, false);
        Review reviewBefore = reviewRepository.findByReviewNo(reviewNo);
        long beforeLike = reviewBefore.getLikeCnt();

        PostLikeResponse postLikeResponse =commandReviewService.countLike(reviewNo, postLikeRequest);
        Review reviewAfter = reviewRepository.findByReviewNo(reviewNo);
        long afterLike = reviewAfter.getLikeCnt();

        Assertions.assertTrue(postLikeResponse.getIsLiked());
        Assertions.assertEquals(beforeLike+1l, afterLike);
    }

    @DisplayName("좋아요 감소 확인")
    @Test
    void decreaseReview(){
        Long reviewNo = 15L;
        PostLikeRequest postLikeRequest = TestObjects.countReviewLike(2l, true);
        Review reviewBefore = reviewRepository.findByReviewNo(reviewNo);
        Long beforeLike = Math.max(0l, reviewBefore.getLikeCnt()-1l);

        PostLikeResponse postLikeResponse =commandReviewService.countLike(reviewNo, postLikeRequest);
        Review reviewAfter = reviewRepository.findByReviewNo(reviewNo);
        Long afterLike = reviewAfter.getLikeCnt();

        Assertions.assertFalse(postLikeResponse.getIsLiked());
        Assertions.assertEquals(beforeLike, afterLike);
    }

    @DisplayName("제목만 검색")
    @Test
    void searchTitle(){
        String keyword = "매실";
        String type = "title";
        int pageStart = 0;
        int reviewSize = 10;

        Pageable pageable = PageRequest.of(pageStart,reviewSize);
        SearchReviewRequest searchReviewRequest = TestObjects.searchReviewTitle(keyword, type);

        Page<SearchReviewResponse> searchReviewResponses = queryReviewService.searchReview(searchReviewRequest, pageable);

        Assertions.assertNotNull(searchReviewResponses);
    }

    @DisplayName("내용만 검색")
    @Test
    void searchContent(){
        String keyword = "컴포즈";
        String type = "content";
        int pageStart = 0;
        int reviewSize = 10;

        Pageable pageable = PageRequest.of(pageStart,reviewSize);
        SearchReviewRequest searchReviewRequest = TestObjects.searchReviewTitle(keyword, type);

        Page<SearchReviewResponse> searchReviewResponses = queryReviewService.searchReview(searchReviewRequest, pageable);

        Assertions.assertNotNull(searchReviewResponses);
    }

    @DisplayName("전부 검색")
    @Test
    void searchAll(){
        String keyword = "컴포즈";
        String type = "both";
        int pageStart = 0;
        int reviewSize = 10;

        Pageable pageable = PageRequest.of(pageStart,reviewSize);
        SearchReviewRequest searchReviewRequest = TestObjects.searchReviewTitle(keyword, type);

        Page<SearchReviewResponse> searchReviewResponses = queryReviewService.searchReview(searchReviewRequest, pageable);

        Assertions.assertNotNull(searchReviewResponses);
    }
}