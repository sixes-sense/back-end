package com.sixesSense.recorder.review.command.domain.repository;

import com.sixesSense.recorder.review.command.domain.aggregate.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findByCommentNo(Long commentNo);
}
