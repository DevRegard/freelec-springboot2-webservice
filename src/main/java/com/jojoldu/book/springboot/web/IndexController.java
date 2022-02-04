package com.jojoldu.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    // 글 등록
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
    
    // 글 수정
    @PutMapping("/posts/update")
    public String postsUpdate() { return "posts-update"; }
    
    // 글 삭제
    @DeleteMapping("/posts/delete")
    public String postsDelete() { return "posts-delete"; }

    /** 22-01-31
        1. 블럭체인 웹 프론트엔드 화면은?
        2. NFT 웹 사이트를 출력하는 공간을 만든다면?
        3. 현재 개발하는 웹 사이트로 NFT 를 생산하고, 판매할 수 있을까?
        4. 1개월 안에 웹 사이트를 배포까지 할 수 있을까?
        5. 사람들이 원하는 NFT / 내가 만들 수 있는 NFT
    */
    
    // 의미 없는 커밋 One
    // 의미 없는 커밋 Two
    // 의미 없는 커밋 Three
    // 의미 없는 커밋 Four
}