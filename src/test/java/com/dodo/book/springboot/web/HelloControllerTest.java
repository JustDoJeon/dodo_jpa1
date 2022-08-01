package com.dodo.book.springboot.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@SpringBootTest
//@ExtendWith(SpringExtension.class)
// 여러 스프링 테스트 어노테이션중, web에 집중가능, 서비스, 컴포넌트, 서비스는 사용불가
@WebMvcTest(controllers = HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    /*
에러 : java.lang.IllegalStateException: Configuration error: found multiple declarations of @BootstrapWith for test class
@SpringBootTest 와 @WebMvcTest 모두 부트스트랩위드 어노테이션을 포함했음
 */
    @Test
    public void helloDto_test() throws Exception{
        String name ="hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",name).exists())
                .andExpect(jsonPath("$.amount",amount).exists());
    }
}
