package com.sixesSense.recorder.review.command.domain.repository;

import com.sixesSense.recorder.review.command.domain.aggregate.entity.ReviewTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewTagRepository extends JpaRepository<ReviewTag, Long> {
    ReviewTag findByTagIdAndReviewNo(Long tagId, Long reviewNo);
}
