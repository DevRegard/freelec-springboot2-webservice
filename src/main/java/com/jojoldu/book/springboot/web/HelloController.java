package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** REST Controller 사용
@RestController
 -JSON 데이터를 반환하는 컨트롤러
 -@ResponseBody 를 각 메서드 마다 선언했던 것을 생략하는 역할
 */
@RestController
public class HelloController
{
    /** 어노테이션 설명
     MK] @GetMapping
     - HTTP Method - Get 요청을 받을 수 있는 API
     - @RequestMapping(method = RequestMethod.GET) 역할
     - /hello 요청 -> 문자열 hello 반환

     MK] @RequestParam
     - '외부 ~> API' 로 넘긴 파라미터 가져오기
     - 외부에서 name(@RequestParam("name") 이란 이름으로 넘긴 파라미터를 메소드 파라미터 name(String name)에 저장
     */
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    } // -> HelloController/helloIsReturn()

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount)
    {
        return new HelloResponseDto(name, amount); // -> HelloController/helloDtoIsReturn()
    }
}