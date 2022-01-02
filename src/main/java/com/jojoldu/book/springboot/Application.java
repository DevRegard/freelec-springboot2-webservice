package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
자동 설정 : 스프링 부트, 스프링 Bean 읽기와 생성
해당 어노테이션이 있는 위치부터 설정 읽음 -> 프로젝트 최상단 유지
 */
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        /*
        springApplication.run
         : 내장 WAS 실행
        
        *내장 WAS
         : 톰캣 등 설치 없이, Jar 파일로 실행
         */
    }
}
