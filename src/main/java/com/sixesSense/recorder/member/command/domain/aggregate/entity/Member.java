package com.sixesSense.recorder.member.command.domain.aggregate.entity;

import com.sixesSense.recorder.common.entity.BaseTimeEntity;
import com.sixesSense.recorder.member.command.domain.aggregate.entity.enumType.Role;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Member_TB")
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    @Comment("회원번호")
    private Long id;

    @Comment("OauthId")
    private String oauthId;

    @Comment("회원 이름")
    private String name;

    @Comment("회원 이메일")
    private String email;

    @Comment("회원 프로필사진")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Comment("회원 권한")
    private Role role;

    public String getRoleKey() {
        return this.role.getKey();
    }

    public Member(Long id, String oauthId, String name, String email, String imageUrl, Role role) {
        this.id = id;
        this.oauthId = oauthId;
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        this.role = role;
    }
    public Member(String oauthId, String name, String email, String imageUrl, Role role) {
        this(null, oauthId, name, email, imageUrl, role);
    }

    public Member update(String name, String email, String imageUrl) {
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        return this;
    }
}

