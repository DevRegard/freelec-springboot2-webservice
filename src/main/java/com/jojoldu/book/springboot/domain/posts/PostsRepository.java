package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}

/*
JpaRepository<Entity 클래스, PK타입>
  - CRUD 메소드 자동 생성
  - 반드시 'Entity 클래스' + 'Entity Repository' 함께 위치
 */