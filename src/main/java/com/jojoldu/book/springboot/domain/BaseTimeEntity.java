package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 생성 및 수정 시간 추상클래스
 *  : 상속 시, Entity들의 createDate, modifiedDate 자동 관리 역할
 *
 * @MappedSuperclass
 *  - JPA Entity 클래스 <- 해당 클래스 [상속]
 *  - 해당 클래스의 필드들이 상속 받은 클래스에서 칼럼으로 인식
 *
 * @EntityListeners(AuditingEntityListener.class)
 *  - 해당 클래스에 'Auditing 기능' 포함
 *
 * @CreatedDate
 *  - Entity 생성 후 저장 시, 시간 자동 저장
 *
 * @LastModifiedDate
 *  - 조회한 Entity의 값 변경 시, 시간 자동 저장
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}