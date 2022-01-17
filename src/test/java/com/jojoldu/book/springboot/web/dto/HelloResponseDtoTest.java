package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_action_test(){ //롬복 동작 테스트 [인자 테스트]
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); //가져온 인자와 실제 인자가 같은가?
        assertThat(dto.getAmount()).isEqualTo(amount);

        /*
        assertThat()
         - 테스트 검증 라이브러리의 '검증 메서드'
         - 검증하고 싶은 대상 : 메서드 인자로 받는다.
         - 메소드 체이닝 지원

        isEqualTo()
         - assert 동등 비교 메서드
         - assertThat() = isEqualTo() -> 성공
         */

        // `22-01-14 : 27인치, QHD, 눈 보호
    }
}
