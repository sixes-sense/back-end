package com.sixesSense.recorder.member;

import com.sixesSense.recorder.member.command.domain.aggregate.entity.EnumType.Role;
import com.sixesSense.recorder.member.command.domain.aggregate.entity.Member;
import com.sixesSense.recorder.member.command.domain.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberInputTest {

    @Autowired
    private MemberRepository repository;

    @Test
    @DisplayName("Member 저장할때 Auditing 체킹")
    void Member() {
        //given
        Member member = Member.builder()
                .name("박태근")
                .nickName("곰은꾸어엉")
                .address("태근집주소")
                .email("태근이메일")
                .phoneNum("010-8238-9199")
                .role(Role.ROLE_MEMBER)
                .build();
        //when
        repository.save(member);
    }
}
