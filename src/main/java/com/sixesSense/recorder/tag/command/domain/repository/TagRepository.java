package com.sixesSense.recorder.tag.command.domain.repository;

import com.sixesSense.recorder.tag.command.domain.aggregate.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
