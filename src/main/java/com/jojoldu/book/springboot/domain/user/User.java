package com.jojoldu.book.springboot.domain.user;
// User 클래스: User Table

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role)
    {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    // 추후 추가 예정
    public User update(String name, String picture)
    {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey()
    {
        return this.role.getKey();
    }
}

/*
 22-02-27 오류 수정
   - 'import javax.management.relation.Role;' 제거
   - getRoleKey() 의 리턴값 오류 해결
   - 깃허브 코드 복사 후 오류 파악
 */