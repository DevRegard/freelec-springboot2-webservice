package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void helloIsReturn() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
}
/*
@RunWith(SpringRunner.class)
  -스프링 부트 테스트 ~ JUnit 연결자
  -테스트 진행) JUnit 내장된 실행자 외에 다른 실행자를 실행
  -다른 실행자 : SpringRunner 스프링 실행자

@WebMvcTest
  -Web 집중 어노테이션
  -@Controller, @ControllerAdvice 사용 가능
  -@Service, @Component, @Repository 사용 불가
  -컨트롤러만 사용할 때 선언
  
@Autowired
  -스프링이 관리하는 빈(Bean) 주입 받기

_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

private MockMvc mvc
  -웹 API 테스트
  -스프링 MVC 테스트 시작점
  -MockMvc 클래스 : HTTP GET, POST 등 API 테스트 가능

mvc.perform(get("/주소값");
  -MockMvc 통해 /주소값 으로 HTTP GET 요청
  -체이닝 지원 : 여러 검증 기능 병렬 선언 가능

.andExpect(status().isOk())
  -mvc.perform 결과 검증
  -HTTP Header <- Status 검증
  -200, 404, 500 등 상태 검증
  -isOk : 200인지 아닌지 검증

.andExpect(content().string(hello))
  -mvc.perform 결과 검증
  -응답 본문의 내용 검증
  -Controller 리턴값("hello") 검증

*/