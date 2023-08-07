package com.sixesSense.recorder.exampleDomain.command.domain.repository;

import com.sixesSense.recorder.exampleDomain.command.domain.aggregate.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExampleRepository extends JpaRepository<Example, Integer> {
}