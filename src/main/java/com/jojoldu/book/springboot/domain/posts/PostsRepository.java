package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}

/*
JpaRepository<Entity 클래스, PK 타입>
  - CRUD 메소드 자동 생성
  - 반드시 'Entity 클래스' + 'Entity Repository' 함께 위치
 */