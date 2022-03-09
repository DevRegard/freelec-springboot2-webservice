package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto
{ // final 변수 변경 검토[불변성 확보] ~> setter 구현하지 않으면 final 효과
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author)
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity()
    {
        return Posts
                .builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

    // Todo : [빌더 패턴]  https://mangkyu.tistory.com/163#recentEntries
}
