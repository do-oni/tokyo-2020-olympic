# 🎖 Tokyo-2020-Olympic
첫번째 JDBC  Mini Project 

2020 도쿄 올림픽 정보 검색 서비스

## 👥 팀 구성원

---

🙆‍♀️ 서주연

🙆 유영훈

🙆‍♀️ 정은진

## 🗓️ 프로젝트 추진 타임라인

---

https://www.notion.so/08c858f1568748969a02d6e2a4d13e19?v=d6ae97a0776c4e498aa284aeee5caaba

## 🖥️ 전반적인 서비스 기술

올림픽 참가국, 종목, 선수 등으로 구성된 테이블을 바탕으로 올림픽과 관련한 정보들을 검색할 수 있는 서비스를 구현하였습니다.

예시로, 어느 국가가 올림픽에 참가했는지, 특정 국가가 얼마나 많은 메달을 땄는지 검색해볼 수 있으며, 선수 번호를 이용하여 선수명을 수정하는 등의 데이터 수정 서비스를 제공합니다.

## 🗃️ 엔티티 관계도

![drawio](https://user-images.githubusercontent.com/84673603/129448703-3bf36955-da32-44fc-8f7b-327366c0b278.jpg)


## ⚙️ 기능 구현 목록

---

- 모든 올림픽 검색
    - 메소드 명 :  OlympicController.getAllOlympic()
    - 파라미터 :  없음
    - 실행 화면

        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bfa61f50-2a55-4695-a4b9-ec4af979e862/Untitled.png)

- 모든 올림픽 참전 국가 검색
    - 메소드 명 :  OlympicController.getCountries()
    - 파라미터 :  없음
    - 실행 화면

        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/348b04d4-7435-4ba3-99bc-3442e872c0ab/Untitled.png)

- 특정 국가 모든 메달 수 검색
    - 메소드 명: OlympicController.getMedalCnt()
    - 파라미터 : String - 국가 명
    - 실행 화면
        - 성공 화면

            ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bc748acc-565e-43bf-921e-d3674dd0565b/Untitled.png)

        - 실패 화면

            ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/42de485a-c5cf-4cb0-9cd3-364ece4491a7/Untitled.png)

- 특정 종목으로 검색
    - 메소드 명: OlympicController.getSport()
    - 파라미터 : String, String - 국가 명 , 종목
    - 실행 화면
        - 성공 화면

            ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e954e283-0be3-4e1c-8659-34250a701644/Untitled.png)

        - 실패 화면

            ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8ad8ef9e-12d1-4551-8724-23be746fd0a1/Untitled.png)

- 특정 선수 검색
    - 메소드 명: OlympicController.getPlayer()
    - 파라미터 : String , String  - 국가 명 , 선수 이름
    - 실행 화면
        - 성공 화면

            ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/81d6d1a5-2a30-44ed-8787-c3cf7266a884/Untitled.png)

        - 실패 화면

        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b017ed8e-e2de-4abc-9168-b93edea4afc1/Untitled.png)

- 특정 선수 번호로 선수 명 수정 후 검색
    - 메소드 명: OlympicController.updatePlayer()
    - 파라미터 : String, Int - 선수 이름, 선수 번호
    - 실행 화면
        - 성공 화면

            ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d684b90a-663c-4d44-9bc4-28b543f94453/Untitled.png)

        - 실패 화면

            ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bb8cb27b-b4ce-4482-b529-058fbaa01d2a/Untitled.png)

- 메달 스코어로 랭킹 검색
    - 메소드 명: OlympicController.updatePlayer()
    - 파라미터 : 없음
    - 실행 화면
        - 성공 화면

            ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8c43741d-a283-4837-9a75-e3e3728d41b4/Untitled.png)

- 제일 많이 검색된 선수 출력
    - 메소드 명: OlympicController.searchLog()
    - 파라미터 : 없음
    - 실행 화면
        - 성공 화면

            ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ffdc1c1c-ed6f-45b1-8005-4f8b1379786a/Untitled.png)

        - 실패 화면

            ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ccfd08f7-ca5f-4271-ab4f-b7d8c962dd20/Untitled.png)
