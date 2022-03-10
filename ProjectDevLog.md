SINCE: 22. 03/08

### 22. 03/10
* 인텔리제이 설정
  - 커스텀 주석: 'mark' 생성
  - MK (하늘색)


* index.mustache
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

### 22. 03/
* WebConfig
* IndexController [+]
* build.gradle [+]
* application-oauth.properties [+]
* OAuthAttributes [+]
* index.mustache [+]
* [TEST] 웹사이트 네이버 로그인

< After >
1) AWS EC2
2) AWS RDS
3) EC2 서버 프로젝트 배포
4) Travis CI 배포 자동화
5) 무중단 배포


