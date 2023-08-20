package com.sixesSense.recorder.member.command.domain.repository;

import com.sixesSense.recorder.member.command.domain.aggregate.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByOauthId(String id);

     Optional<Member> findByOauthIdAndEmail(String id,String email);
}
