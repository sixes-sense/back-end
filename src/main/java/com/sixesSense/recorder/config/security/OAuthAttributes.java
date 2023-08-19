package com.sixesSense.recorder.config.security;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

@Slf4j
public enum OAuthAttributes {
    GITHUB("github", (attributes) -> {
        return new UserProfile(
                String.valueOf(attributes.get("id")),
                (String) attributes.get("name"),
                (String) attributes.get("email"),
                (String) attributes.get("avatar_url")
        );
    });

    private final String registrationId;
    private final Function<Map<String, Object>, UserProfile> of;

    OAuthAttributes(String registrationId, Function<Map<String, Object>, UserProfile> of) {
        this.registrationId = registrationId;
        this.of = of;
    }

    public static UserProfile extract(String registrationId, Map<String, Object> attributes) {
        return Arrays.stream(values())
                .filter(provider -> registrationId.equals(provider.registrationId))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .of.apply(attributes);
    }
}
