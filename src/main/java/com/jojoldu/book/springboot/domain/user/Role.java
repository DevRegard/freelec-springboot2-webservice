package com.jojoldu.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자"),
    VIP("ROLE_VIP", "VIP"),
    MANAGER("ROLE_MANAGER", "관리자");

    private final String key;   // * ROLE_ 필수
    private final String title;
}
