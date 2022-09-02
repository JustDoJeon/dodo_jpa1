package com.dodo.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST","손님");
    User("ROLE_USER","user");

    private final String key;
    private final String title;

}
