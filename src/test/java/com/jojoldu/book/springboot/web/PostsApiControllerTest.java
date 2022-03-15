package com.jojoldu.book.springboot.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat; //수동 삽입
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
게시판 API 테스트
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //JPA 기능까지 테스트 + 랜덤 포트 실행
public class PostsApiControllerTest
{

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup()
    {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @After
    public void tearDown() throws Exception
    {
        postsRepository.deleteAll(); // mk] DELETE FROM posts WHERE id=?
    }

    // MD] 게시판 등록 테스트
    @Test
    @WithMockUser(roles = "USER") // mk] 모의(가짜) 사용자
    public void posts_Enrollment() throws Exception
    {
        // mk] Given
        String title = "title";
        String content = "content";
        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author("author") //Why? 제목과 내용은 별도 변수로 지정, 작성자는 직접 입력
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts";
            /** TODO 공통 분모 'static' 변수 진행: '문자열+Int+문자열' 패턴 변수화 테스트 검토
             * - 전체 테스트 불가 가능성
             * - 결합도 문제
             * - 참고: static, port, url 서로 참조 불가
             */

        // mk] When
        mvc.perform(post(url)   // mk] 생성된 MockMvc 통해 API 테스트
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // mk] Then
        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);

//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
    }

    // MD] 게시판 수정 테스트
    @Test
    @WithMockUser(roles = "USER") // mk] roles 권한 설정 가능
    public void posts_Update() throws Exception
    {
        // mk] Given
        Posts savePosts = postsRepository.save(
                Posts.builder()
                .title("제목1 테스트")
                .content("글 내용1, 글 내용2, 글 내용3")
                .author("홍길동")
                .build()
        );

        Long updateId = savePosts.getId();
        String expectedTitle = "제목2 테스트";
        String expectedContent = "글 내용4, 글 내용5, 글 내용6";

        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder() //update
                .title(expectedTitle)
                .content(expectedContent)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId; /** 오류 원인 : url 슬래시 부재 */

        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
        // TODO) HttpEntity() :

        // mk] When
        mvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());
//        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        // mk] Then
        List<Posts> all = postsRepository.findAll(); // mk] SELECT (*) FROM
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);

//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
    }
    /**
     * mk] posts_Enrollment()
     *  Hibernate: insert into posts (author, content, title) values (?, ?, ?)
     * mk] posts_Update() -save()
     *  Hibernate: update posts set author=?, content=?, title=? where id=?
     */
}