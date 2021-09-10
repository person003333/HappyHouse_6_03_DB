# 🎯 HappyHouse_6_03_DB

# 프로젝트 명
     🏠 Happy House Project 
    : HappyHouse 프로젝트의 데이터베이스 구축 프로젝트

<br>

## 🧑 프로젝트 참여자
    - 배문규
    - 이정훈

<br>

## 💡 진행 테이블
|분류|설명|완성 여부|
|:-:|:-:|:-:|
|기본|회원 정보 데이터 관리|⭕️|
|기본|아파트 매매 실거래가 데이터 관리|⭕️|
|기본|관심지역 데이터 관리|⭕️|
|추가|동네 업종 정보 데이터 관리|⭕️|
|추가|동네 환경 점검 정보 데이터 관리|❌|
|심화|코로나 선별 진료소 정보 데이터 관리|❌|
|심화|국가 안심 병원 정보 데이터 관리|⭕️|
<br>

# 😎 ERD
![erd1](https://lab.ssafy.com/anvo930524/happyhouse_6_03_db/-/raw/master/img/erd1.png)

![erd2](https://lab.ssafy.com/anvo930524/happyhouse_6_03_db/-/raw/master/img/erd2.png)

# 😎 메뉴 설계
## 1. 동 조회
       구군 코드와 동을 입력하면 주택 정보가 출력됨
![1](https://lab.ssafy.com/anvo930524/happyhouse_6_03_db/-/raw/master/img/1.png)

## 2. 실거래가 조회
       구군 코드와 동, 아파트를 입력하면 해당 지역 아파트 정보가 출력됨
![2](https://lab.ssafy.com/anvo930524/happyhouse_6_03_db/-/raw/master/img/2.png)

## 3. 로그인
       아이디와 비밀번호로 로그인 (로그아웃은 생략, 변수를 null로 덮으면 됨)
![3](https://lab.ssafy.com/anvo930524/happyhouse_6_03_db/-/raw/master/img/3.png)

## 4. 회원가입
       사용자 정보를 입력하여 회원가입
![4](https://lab.ssafy.com/anvo930524/happyhouse_6_03_db/-/raw/master/img/4.png)

## 5. 회원정보 수정
       수정하려는 옵션을 선택하고 정보를 수정
![5](https://lab.ssafy.com/anvo930524/happyhouse_6_03_db/-/raw/master/img/5.png)

## 6. 회원 탈퇴
       사용자 아이디를 입력받아 회원 탈퇴
![6](https://lab.ssafy.com/anvo930524/happyhouse_6_03_db/-/raw/master/img/6.png)

![6](https://lab.ssafy.com/anvo930524/happyhouse_6_03_db/-/raw/master/img/6-2.png)

## 7. 회원 조회
       현재 등록된 회원 조회 (김싸피 가입 -> 홍싸피 변경 후 삭제 전에 조회)
![7](https://lab.ssafy.com/anvo930524/happyhouse_6_03_db/-/raw/master/img/7.png)

## 8. 관심지역 등록
       로그인이 된 상태면 동 코드, 구, 동을 입력하여 관심지역 등록
![8](https://lab.ssafy.com/anvo930524/happyhouse_6_03_db/-/raw/master/img/8.png)

## 9. 관심지역 삭제
       로그인이 된 상태면 동코드를 입력하여 관심지역 삭제
![9](https://lab.ssafy.com/anvo930524/happyhouse_6_03_db/-/raw/master/img/9.png)

![9](https://lab.ssafy.com/anvo930524/happyhouse_6_03_db/-/raw/master/img/9.png)

## 10. 관심지역 조회
       로그인이 된 상태면 등록된 관심지역을 조회
       
       그 중 1군데의 동 코드를 입력받고, 1, 2번 선택 옵션을 통해 해당 지역의 의료기관과 상권을 조회
![9](https://lab.ssafy.com/anvo930524/happyhouse_6_03_db/-/raw/master/img/10.png)

![9](https://lab.ssafy.com/anvo930524/happyhouse_6_03_db/-/raw/master/img/10-2.png)

## 0. 동 조회
### 페이지 설명
       로그인 하면 Login 버튼은 사라지고  Logout, 회원 정보, 관심지역 버튼이 나타난다.
![0](https://lab.ssafy.com/anvo930524/happyhouse_6_03_db/-/raw/master/img/0.png)

