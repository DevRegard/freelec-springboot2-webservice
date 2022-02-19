package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
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

    /**
     * 게시판 글 등록 테스트
     */
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

    /**
     * JPA Auding 테스트(자동 날짜 생성 및 수정)
     */
    @Test
    public void BaseTimeEntity_Enrollment() {
        //given
        LocalDateTime now = LocalDateTime.of(2022, 1,21,21,36,20);
        postsRepository.save(Posts.builder()
                .title("동의보감")
                .content("동의~ 어 보감")
                .author("정약용")
                .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate = " + posts.getCreateDate() + "   modifiedDate = " + posts.getModifiedDate());
        // >>>>>>>>> createDate = 2022-01-21T21:46:27.230   modifiedDate = 2022-01-21T21:46:27.230
        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}