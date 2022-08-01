package com.dodo.book.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 이 클래스는 만들 프로젝트의 메인클래스다.
 @SpringBootApplication 으로 인해 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정된다.
 특히나 @SpringBootApplication이 있는 위치부터 설정을 읽어 가기때문에 이클래스는 항상 프로젝트의 최상단에 위치해야한다.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // 이 run으로 인해 내장was를 실행한다. 이렇게되면 항상 서버에 톰캣을 설치할 필요가 없게되고,
        // 톰캣을 따로 설치할 필요없이 스프링부트로 만들어진 Jar파일로 실행하면 된다.
        SpringApplication.run(Application.class, args);
    }

}
