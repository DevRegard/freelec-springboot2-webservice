package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/** MK] 어노테이션 설명
 Function] @SpringBootApplication
 -자동 설정 : 스프링 부트, 스프링 Bean 읽기와 생성
 -해당 어노테이션이 있는 위치부터 설정 읽음 -> 프로젝트 최상단 유지

 Function] SpringApplication.run
 -내장 WAS 실행
 -톰캣 등 설치 없이, Jar 파일로 실행
 */
//@EnableJpaAuditing 가 삭제됨 //JPA Auditing 활성화
@SpringBootApplication
public class Application
{
    public static void main(String[] args)
    { // Web Tomcat 실행
        SpringApplication.run(Application.class, args);
    }
}