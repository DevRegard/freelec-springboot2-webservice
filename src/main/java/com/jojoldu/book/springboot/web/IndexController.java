package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/posts/update/{id}") // *Causes of 'Whitelabel Error Page'
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
    
    // 글 삭제
//    @DeleteMapping("/posts/delete")
//    public String postsDelete() { return "posts-delete"; }
}