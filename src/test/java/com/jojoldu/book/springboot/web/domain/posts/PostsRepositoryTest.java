package com.jojoldu.book.springboot.web.domain.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat; // 수동 import

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After //JUnit 단위 테스트 끝나고 수행
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void boardSave_load(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save( // insert/update 쿼리 실행(id값 있으면 update, 없으면 insert)
                Posts.builder()
                .title(title)
                .content(content)
                .author("utrTest@gmail.com")
                .build());
                /// Id 값이 없으므로, insert 수행 (실제 쿼리에는 id 값 포함된 insert)
        //when
        List<Posts> postsList = postsRepository.findAll(); //테이블, 모든 데이터 조회(findAll())

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}