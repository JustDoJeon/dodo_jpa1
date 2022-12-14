package com.dodo.book.springboot.config.auth.dto;

import com.dodo.book.springboot.domain.user.Users;
import com.dodo.book.springboot.domain.user.Users;
import lombok.Getter;

import java.io.Serializable;

//인증된 사용자 정보만 필요.
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(Users user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}