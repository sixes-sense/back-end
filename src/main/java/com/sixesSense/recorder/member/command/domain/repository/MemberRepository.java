package com.sixesSense.recorder.member.command.domain.repository;

import com.sixesSense.recorder.member.command.domain.aggregate.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
