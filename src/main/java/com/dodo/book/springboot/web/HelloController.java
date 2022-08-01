package com.dodo.book.springboot.web;

import com.dodo.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러를 json으로 반환하는 컨트롤러로 만들어준다.
// 예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할수 있게 해줌
@RestController
public class HelloController {

    //Http Method인 Get의 요청을 받을수 있는 api를 만들어준다.
    // 이 프로젝트는 /hello로 요청이 들어오면 문자열 hello를 반환하는 기능을 가지게된다.
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // @RequestParam은 외부에서 api로 넘긴 파라미터를 가져오는 어노테이션이다.
    // 외부에서 name이란 이름으로 넘긴 파라미터를 메소드 파라미터 name에 저장하게된다.
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name,amount);
    }

}
