SINCE: 22. 03/08

### 22. 03/10
* 인텔리제이 설정
  - 커스텀 주석: 'MK' 생성 (하늘색)
  
* index.mustache [+]
  - [로그인 기능 영역]
    - 로그인 버튼
    - 로그인 성공 시, 사용자 이름 보여주기
    
* IndexController [+]
  - userName -> model 저장하는 코드 추가
  - 로그인 성공 여부따라 세션 저장
  
* [TEST] 웹사이트 구글 로그인
  - issue 1) 로그인 버튼 클릭 후, 간헐적 화이트라벨[해결]
  - 정상 로그인 확인(H2 확인)
  - 권한 변경(Guest -> User) 후, 글쓰기 정상
  
* @LoginUser
  - 어노테이션 생성
  
* LoginUserArgumentResolver
  - {after}

### 22. 03/11

* 패키지 구조 변경
  - [config/auth] SecurityConfig
  -> [config] SecurityConfig
  
* WebConfig
  - LoginUserArgumentResolver 스프링 인식
  - WebMvcConfigurer 에 추가

* IndexController [+]
  - @LoginUser 개선 및 리팩토링

### 22. 03/12
* build.gradle [+]
  - 'spring-session-jdbc' 등록
  
* application.properties [+]
  - 세션 저장소 -> jdbc 선택 설정 코드 추가
  
### 22. 03/13
* import Api - Naver Login
  - projectName: devtest-springboot2-webservice
  - Create: Client ID & Client Secret

* application-oauth.properties
  - registration, provider

* OAuthAttributes [+]
  - Added: 네이버 여부 판단, 네이버 생성자
  - 커스텀 주석 개편: MD(method) -> bold, mk(mark) -> nonBold

* index.mustache [+] 
  - 네이버 로그인 버튼 추가

* [Issue] 서버 미 작동
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

* test/~/ application.properties 
  - 가짜 설정값 등록

* build.gradle 
  - 스프링 시큐리티 테스트 도구 추가 (spring-security-test)
  - 불필요 코드 삭제 & 주석 개편
  
* PostsApiControllerTest 
  - 임의 사용자 인증 추가 (@WithMockUser)
  - 코드 개선: 커스텀 주석 적용, 가독성 향상
  

### 22. 03/15
* PostsApiControllerTest
  - MockMvc 테스트 호환
  - MockMvc 관련 import, 테스트 메서드 리팩토링

### 22. 03/16
* [TEST] 전체 테스트
 - [문제3] @WebMvcTest - CustomOAuthUserService 찾을 수 없음
   - 원인:
   - 해결:

* HelloControllerTest [+] - 스캔 대상 변경 및 제거
* Application[-] - @EnableJpaAuditing 제거
* JpaConfig - JPA Audition 활성화

* AWS EC2
* AWS RDS
* EC2 서버 프로젝트 배포
* Travis CI 배포 자동화
* 무중단 배포

* 커스텀 주석: 클래스, 변수 추가

