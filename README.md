# SSAFIT Project by HEETHUB&JQuad

SSAFIT 프로젝트는 SSAFY(Samsung Software Academy For Youth)에서 프로그래밍을 학습하며 진행한 작은 프로젝트이다. 
운동 영상들을 운동 부위별로 추천해주는 웹사이트를 만들어보았다. STS3를 사용하여 Spring Legacy Project를 기반으로 만들었다. <br><br>

### 1. 프로젝트 목표 및 사용 기술
    
- 웹 MVC 아키텍처를 이해하고 활용하여 프로젝트에 적용해보려 했다. 프론트 부분은 최소한으로 구현하고 백엔드 파트 구현에 집중했다.
- Spring Framework를 사용하여 RESTful 방식으로 웹 서버를 구축하였다.</li>
- DB 연동은 MyBatis Framework를 사용하여 MySql과 연동하였다. </li>
  
### 2. 구현 기능

- 회원가입 및 로그인, 로그아웃 기능</li>
- 운동 영상 요청 : 운동 영상 정보의 다양한 출력 (조회수 많은 영상, 운동 부위별 영상)</li>
- 운동 영상에 대한 리뷰 관리 기능 : 목록, 등록, 수정, 상세, 삭제 등</li>

  
### 3. REST API 목록 및 클래스 다이어그램

<img src="https://github.com/HEETHUB/SSAFIT/assets/113952597/d2bd72a0-b1d6-4368-b3a9-91ea5cdc8c4e">

<!--<img src="https://github.com/HEETHUB/SSAFIT/assets/113952597/8dd89297-dab7-408f-92bd-aa6760506df3">-->



<img src="https://github.com/HEETHUB/SSAFIT/assets/113952597/72982add-7b6c-4457-815a-def12dc95789"/>

### 4. 아키텍처 설명 및 맡은 부분
- Model을 Service, DAO, DTO로 나누어 DTO를 MySql과 연동시킨 후 DAO를 호출하는 Service 객체의 메서드를 실행시키면 DAO가 DB에 접근하여 데이터를 가져오는 식의 아키텍처를 만들었다.
- Controller 파트는 RESTful하게 만들어 운동 영상들과 그 영상들의 리뷰, 회원정보 등을 관리하였다. 
- View 파트는 따로 만들지 않고 Talend API를 통해 내가 작성한 REST API가 잘 작동하는지 확인만 해보았다. 
- 나는 DAO와 DB 파트를 제외한 Model의 Service 파트와 Controller 전반을 맡아 코드들을 작성했다.
