package com.dodo.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//모든 응답 Dto는 이 클래스에 추가
@Getter //선언된 모든 필드의 get 메소드를 생성해준다.
@RequiredArgsConstructor //선언된 모든 final 필드가 포함된 생성자를 생성해줌, final이 없는 필드는 생성자에 포함되지않는다.
public class HelloResponseDto {
    private final String name;
    private final int amount;




}
