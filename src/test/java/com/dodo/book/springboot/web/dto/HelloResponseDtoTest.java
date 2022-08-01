package com.dodo.book.springboot.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        // assertj라는 테스트 검증 라이브러리의 검증 메소드를 통해 검증한다.
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
    /*
    junit의 assertThat이 아닌 assertj 사용이유
    - CoreMatchers 라이브러리가 추가적으로 필요하지 않다.
    - 자동완성이 좀 더 확실하게 지원된다. ( IDE에선 CoreMatchers와 같은 Matcher 라이브러리의 자동완성 지원이 약하다.)
     */

}