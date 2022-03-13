package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor // mk) 안하면 private final 변수 오류
@Controller
public class IndexController {

    // 변수 추가(조회 기능 개발 후)
    private final PostsService postsService;
//    private final HttpSession httpSession; //mk) userName 모델에 추가 위함

    // MD) 시작 페이지
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user)
    {
        model.addAttribute("posts", postsService.findAllDesc());
//        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //mk) 로그인 성공 시 세션에 저장
        if (user != null) { // mk) 세션에 저장된 값이 있으면?
            // mk) 'model <- userName' 등록
            model.addAttribute("userName", user.getName());
            // mk) 없으면 '로그인 버튼 보이도록 구현 (model == null)
        }
        return "index";
    }

    // MD) 글 등록
    @GetMapping("/posts/save")
    public String postsSave()
    {
        return "posts-save";
    }
    
    // MD) 글 수정
    @GetMapping("/posts/update/{id}") // *Causes of 'Whitelabel Error Page'
    public String postsUpdate(@PathVariable Long id, Model model)
    {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

/*     글 삭제
    @DeleteMapping("/posts/delete")
    public String postsDelete() { return "posts-delete"; }*/
}