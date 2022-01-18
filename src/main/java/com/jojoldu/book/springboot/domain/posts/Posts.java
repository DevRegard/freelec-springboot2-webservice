package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Getter //모든 필드 Getter 메소드 자동생성 (Setter 메소드는 생성 X)
@NoArgsConstructor //기본 생성자 자동 추가 (= public Posts() {} )
@Entity //테이블 링크 클래스(카멜케이스 ~> 언더스코어 네이밍 매칭)
public class Posts {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성규칙
    private Long id;

    @Column(length = 500, nullable = false) //기본값 외 설정시 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //빌더 패턴 클래스 생성(생성자에 포함된 필드만 포함)
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
