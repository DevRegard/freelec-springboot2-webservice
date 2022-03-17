### 22. 03/10
* [TEST] 웹사이트 구글 로그인
  - issue 1) 로그인 버튼 클릭 후, 간헐적 화이트라벨[해결]
  - 정상 로그인 확인(H2 확인)
  - 권한 변경(Guest -> User) 후, 글쓰기 정상
  
### 22. 03/13
* [Issue]: 서버 미 작동
  - [해결] 내장 서버 미실행
    - 원인: application-oauth.properties
    - 잘못된 어노테이션 삭제 및 변경 : WebConfig[+]
      - @Configurable 삭제 후, @Configuration 추가
  - [해결] 서버 무한 부팅 & 시작 화면 미출력
    - 상태: status 500
    - 조치: 03/11~12 코드 수정 (깃허브 검증)
    - 로그인 및 게시판 정상 작동
  - [파악중] 네이버 동의 화면 미출력

* [TEST] 전체 테스트
  - 방법: [Tasks -> verification -> test]
  - [문제1] CustomOAuth2UserService 찾을 수 없음
    - 원인: 소셜 로그인 설정값 없음 (= test 폴더 설정 없음)
    - 해결: 가짜 설정값 등록(test/application.properties)
  - [문제2] 302 Status Code
    - 원인: 인증되지 않은 사용자의 요청은 이동됨
    - 해결: 임의로 인증된 사용자 추가(PostsApiControllerTest)

### 22. 03/17
[전체테스트]
1) '@WebMvcTest - CustomOAuthUserService' not found
  - 원인
    : 어노테이션 잘못된 스캔 범위 문제
  - 해결
    1) Remove SecurityConfig from scan target
    2) @WithMockUser 가짜 인증된 사용자 생성
2) java.lang.IllegalArgumentException: At least one JPA metamodel must be present!
   - 원인
    : @EnableJpaAuditing, @Entity 클래스 필요함
   - 해결
    1) @EnableJpaAuditing, @SpringBootApplication 분리
    2) Application 에서 @EnableJpaAuditing 제거
    3) config/JpaConfig 생성 후 @EnableJpaAuditing 추가
3) 추가 문제 발생 (확인중)