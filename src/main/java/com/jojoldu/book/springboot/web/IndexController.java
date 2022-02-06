package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor // 어노테이션 추가 => 안하면 private final 변수 오류
@Controller
public class IndexController {

    // 변수 추가(조회 기능 개발 후)
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
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
}