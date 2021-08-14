# 🎖 Tokyo-2020-Olympic
첫번째 JDBC  Mini Project 

2020 도쿄 올림픽 정보 검색 서비스
---

## 👥 팀 구성원

---

🙆‍♀️ 서주연

🙆 유영훈

🙆‍♀️ 정은진

## 🗓️ 프로젝트 추진 타임라인

---

https://www.notion.so/08c858f1568748969a02d6e2a4d13e19?v=d6ae97a0776c4e498aa284aeee5caaba



## 🖥️ 전반적인 서비스 기술

---

올림픽 참가국, 종목, 선수 등으로 구성된 테이블을 바탕으로 올림픽과 관련한 정보들을 검색할 수 있는 서비스를 구현하였습니다.

예시로, 어느 국가가 올림픽에 참가했는지, 특정 국가가 얼마나 많은 메달을 땄는지 검색해볼 수 있으며, 선수 번호를 이용하여 선수명을 수정하는 등의 데이터 수정 서비스를 제공합니다.



## 🗃️ 엔티티 관계도

---

![drawio](https://user-images.githubusercontent.com/84673603/129448703-3bf36955-da32-44fc-8f7b-327366c0b278.jpg)




## ⚙️ 기능 구현 목록

---

<img width="209" alt="화면 캡처 2021-08-14 230949" src="https://user-images.githubusercontent.com/84673603/129449271-630e7a61-020f-47ed-b979-8f585861faed.png">

         
- 모든 올림픽 검색
    - 코드
        
        <img width="697" alt="화면 캡처 2021-08-14 231047" src="https://user-images.githubusercontent.com/84673603/129449277-993aa3a5-d38a-4b20-adc0-43f7c4abcc1b.png">

    - 실행 화면
   
        ![Untitled](https://user-images.githubusercontent.com/84673603/129448881-3b8beaf1-9320-442e-b29b-a4d8d40dcc33.png)


- 모든 올림픽 참전 국가 검색
    - 코드
      
      <img width="478" alt="화면 캡처 2021-08-14 231107" src="https://user-images.githubusercontent.com/84673603/129449299-c72b64ef-4ca0-4dee-bc4c-f3e4f0deb078.png">

      
    - 실행 화면

        ![Untitled (1)](https://user-images.githubusercontent.com/84673603/129448894-f30bd748-1437-4723-9aec-b427c3d64c07.png)


- 특정 국가 모든 메달 수 검색
    - 코드

        <img width="566" alt="화면 캡처 2021-08-14 231138" src="https://user-images.githubusercontent.com/84673603/129449319-ddb5e01c-0e56-4341-a660-3da64a51fc94.png">


    - 실행 화면
        - 성공 화면

            ![Untitled (2)](https://user-images.githubusercontent.com/84673603/129448903-f84ed857-bb7b-4abd-9e09-860c04b3922c.png)


        - 실패 화면

            ![Untitled (3)](https://user-images.githubusercontent.com/84673603/129448906-92b969d3-b1bb-4f50-9f24-1d933614b6e2.png)


- 특정 종목으로 검색
    - 코드

        <img width="574" alt="화면 캡처 2021-08-14 231203" src="https://user-images.githubusercontent.com/84673603/129449345-478f0195-851e-4b27-8cda-a0bed69b7629.png">


    - 실행 화면
        - 성공 화면

            ![Untitled (4)](https://user-images.githubusercontent.com/84673603/129448911-45a15ceb-8739-49c7-97fb-d03dd7b5bc35.png)


        - 실패 화면

            ![Untitled (5)](https://user-images.githubusercontent.com/84673603/129448915-86b174a6-1792-4711-baa7-d8a56f489d7d.png)


- 특정 선수 검색
    - 코드

        <img width="817" alt="화면 캡처 2021-08-14 231236" src="https://user-images.githubusercontent.com/84673603/129449382-ff7bac79-da90-4db8-a13f-031ea525799f.png">


    - 실행 화면
        - 성공 화면

            ![Untitled (6)](https://user-images.githubusercontent.com/84673603/129448919-96ab566e-deb4-4140-b33f-ce24bb4b5ae2.png)


        - 실패 화면

          ![Untitled (7)](https://user-images.githubusercontent.com/84673603/129448923-eec23479-d26d-465a-8692-66ab23618f6c.png)


- 특정 선수 번호로 선수 명 수정 후 검색
    - 코드

        <img width="683" alt="화면 캡처 2021-08-14 231250" src="https://user-images.githubusercontent.com/84673603/129449393-08c93e0e-c933-454c-8134-9a1ba95b58fc.png">


        <img width="685" alt="화면 캡처 2021-08-14 231302" src="https://user-images.githubusercontent.com/84673603/129449408-faeb4d3f-0027-4807-806a-2f7f69a8ce3a.png">


    - 실행 화면
        - 성공 화면

            ![Untitled (8)](https://user-images.githubusercontent.com/84673603/129448934-70fa1b60-b243-4810-bddb-990b2df9495e.png)

        - 실패 화면

            ![Untitled (9)](https://user-images.githubusercontent.com/84673603/129448938-ffa4442e-58c3-47cc-9fe5-0583c7e315a5.png)

- 메달 스코어로 랭킹 검색
    - 코드

        <img width="517" alt="화면 캡처 2021-08-14 231318" src="https://user-images.githubusercontent.com/84673603/129449413-5a652ebb-77bd-4313-9cf3-6f25b9d40bf2.png">


        - 성공 화면

            ![Untitled (10)](https://user-images.githubusercontent.com/84673603/129448941-65867b30-7412-4582-9df4-0000799ee1e7.png)

- 제일 많이 검색된 선수 출력
    - 코드

        <img width="537" alt="화면 캡처 2021-08-14 231338" src="https://user-images.githubusercontent.com/84673603/129449416-2f721c17-3b0d-4e71-8cfc-d7c9001d3d97.png">


    - 실행 화면
        - 성공 화면

            ![Untitled (11)](https://user-images.githubusercontent.com/84673603/129448944-f9e9555b-ad91-4b42-b451-e1f97ce018f7.png)

        - 실패 화면

            ![Untitled (12)](https://user-images.githubusercontent.com/84673603/129448949-131a10f8-a755-412d-8434-9f6c5d4761f4.png)
