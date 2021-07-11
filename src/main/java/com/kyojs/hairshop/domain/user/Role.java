package com.kyojs.hairshop.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("ROLE_USER"),
    HAIR_SHOP("ROLE_HAIR_SHOP"),
    DESIGNER("ROLE_DESIGNER");

    private final String key;
}
