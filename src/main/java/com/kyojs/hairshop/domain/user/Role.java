package com.kyojs.hairshop.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("ROLE_USER", "유저"),
    HAIR_SHOP("ROLE_HAIR_SHOP", "헤어샵"),
    DESIGNER("ROLE_DESIGNER", "디자이너");

    private final String key;
    private final String title;
}
