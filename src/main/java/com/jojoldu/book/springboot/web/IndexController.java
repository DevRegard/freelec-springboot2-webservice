package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor // 어노테이션 추가 => 안하면 private final 변수 오류
@Controller
public class IndexController {

    // 변수 추가(조회 기능 개발 후)
    private final PostsService postsService;
    private final HttpSession httpSession; //mk- userName 모델에 추가 위함

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("posts", postsService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //mk- 로그인 성공 시 세션에 저장
        if (user != null) //mk- 세션에 저장된 값 있으면 'model -> userName' 등록
             model.addAttribute("userName", user.getName());
        //mk- 없으면(model 값 없음) -> 로그인 버튼 보이도록 함.
        return "index";
    }

    // 글 등록
    @GetMapping("/posts/save")
    public String postsSave()
    {
        return "posts-save";
    }
    
    // 글 수정
    @GetMapping("/posts/update/{id}") // *Causes of 'Whitelabel Error Page'
    public String postsUpdate(@PathVariable Long id, Model model)
    {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

    // * 주석 처리 했으나, 삭제 기능 작동함 -> 확인 필요 []
    // 글 삭제
//    @DeleteMapping("/posts/delete")
//    public String postsDelete() { return "posts-delete"; }
}