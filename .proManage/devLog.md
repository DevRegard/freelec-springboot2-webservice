SINCE: 22. 03/08

### 22. 03/10
* 인텔리제이 설정 - 커스텀 주석: 'MK' 생성 (하늘색)
* index.mustache [+] - [로그인 기능 영역]
  - 로그인 버튼
  - 로그인 성공 시, 사용자 이름 보여주기
* IndexController [+]
  - userName -> model 저장하는 코드 추가
  - 로그인 성공 여부따라 세션 저장
* @LoginUser - 어노테이션 생성
* LoginUserArgumentResolver - {after}

### 22. 03/11
* 패키지 구조 변경: [config/auth] SecurityConfig -> [config] SecurityConfig
* WebConfig - LoginUserArgumentResolver 스프링 인식
* IndexController [+] - @LoginUser 개선 및 리팩토링

### 22. 03/12
* build.gradle [+] - 'spring-session-jdbc' 등록
* application.properties [+] - 세션 저장소 -> jdbc 선택 설정 코드 추가

### 22. 03/13
* 네이버 API 등록
  - projectName: devtest-springboot2-webservice
  - Create: Client ID & Client Secret
* application-oauth.properties - registration, provider
* OAuthAttributes [+] - Added: 네이버 여부 판단, 네이버 생성자
* 커스텀 주석 개편: MD(method) -> bold, mk(mark) -> nonBold
* index.mustache [+] - 네이버 로그인 버튼 추가
* devIssue - 서버 미작동, 전체 테스트
* test/~/ application.properties - 가짜 설정값 등록 
* build.gradle - 스프링 시큐리티 테스트 도구 추가 (spring-security-test)
* 불필요 코드 삭제 & 주석 개편
* PostsApiControllerTest - 임의 사용자 인증 추가 (@WithMockUser)
* 코드 개선: 커스텀 주석 적용, 가독성 향상

### 22. 03/15
* PostsApiControllerTest
  - MockMvc 테스트 호환
  - MockMvc 관련 import, 테스트 메서드 리팩토링

### 22. 03/17
* Create '.proManage'
* Rename 'ProjectDevLog.md' to 'devLog'
* [+] devIssue.md
* [+] devRequest.md
* HelloControllerTest[+] - 어노테이션 수정(스캔 대상 변경)
* devLog.md - 내용 간소화, 테스트/문제 관련 내용 이동
* Application[-] - @EnableJpaAuditing 제거
* config/JpaConfig - JPA Audition 활성화

### Soon
* AWS EC2
* AWS RDS
* EC2 서버 프로젝트 배포
* Travis CI 배포 자동화
* 무중단 배포

* 커스텀 주석: 클래스, 변수 추가

