package com.kuang.portfolio.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST","GUEST"), // 0 = GUEST , 1 = NORMAL_USER
    USER("ROLE_USER", "USER");

    private final String key;
    private final String title;
}
