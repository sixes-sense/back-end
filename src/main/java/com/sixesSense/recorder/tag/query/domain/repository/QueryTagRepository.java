package com.sixesSense.recorder.tag.query.domain.repository;

import com.sixesSense.recorder.tag.query.domain.entity.QueryTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryTagRepository extends JpaRepository<QueryTag, Long> {
}
