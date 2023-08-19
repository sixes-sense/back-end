package com.sixesSense.recorder.member.command.domain.aggregate.entity.enumType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum Role {
    GUEST("ROLE_GUEST"),
    USER("ROLE_USER");

    private final String key;

    Role(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
