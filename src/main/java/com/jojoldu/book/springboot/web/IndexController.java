package com.jojoldu.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String postsUpdate() { return "posts-update"; }
    
    // 글 삭제
    public String postsDelete() { return "posts-delete"; }
}
