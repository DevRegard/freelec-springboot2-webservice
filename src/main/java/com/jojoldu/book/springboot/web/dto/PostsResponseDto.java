package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto
{

    private Long id;
    private String title;
    private String content;
    private String author;

    // 게시판 응답 DTO
    public PostsResponseDto(Posts entity)
    {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();

        // 'Entity' 의 필드 중 일부만 사용
        //  -> 생성자로 Entity 받아 필드 초기화
    }
}
