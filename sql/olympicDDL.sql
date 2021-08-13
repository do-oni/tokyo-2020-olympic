---- 올림픽 (olympic) 테이블
DROP TABLE olympic cascade constraint;
--
---- 메달 (medal)
DROP TABLE medal cascade constraint;
--
---- 종목(sport)
DROP TABLE sport cascade constraint;
--
---- 선수 (player)
DROP TABLE player cascade constraint;
--
DROP SEQUENCE olympic_id_seq;

--한종목 특정 선수가 획득한 메달.  (선수 기준) A선수가 금 은 동 메달     메소드(국가별 획득한 메달 수)  종목별 획득한 메달 수?
--1 한국 양궁 A선수 5
--3 한국 양궁 C선수 4
--2 한국 펜싱 B선수 0

CREATE TABLE olympic (
	 olympic_id       NUMBER(5) PRIMARY KEY,
       country          	VARCHAR2(20)  NOT NULL,
       sportName               	VARCHAR2(20) NOT NULL,
       playerNum         	NUMBER(20) NOT NULL,
	   medal_id				VARCHAR2(20)  NOT NULL
);

CREATE TABLE medal (
		medal_id		VARCHAR2(20) PRIMARY KEY,
		country         VARCHAR2(20)  NOT NULL,
		sportname         VARCHAR2(20)  NOT NULL,
       GMedal          	NUMBER(20) NOT NULL,
       SMedal           NUMBER(20) NOT NULL,
       BMedal          	NUMBER(20) NOT NULL
);

CREATE TABLE sport (
       sportname	VARCHAR2(20) PRIMARY KEY,
       country	VARCHAR2(20)  NOT NULL,
       totalmedal	NUMBER(5) NOT NULL
);


CREATE TABLE player (
       playerNum          	NUMBER(20) PRIMARY KEY,
       name      VARCHAR2(20) NOT NULL,
       age  	NUMBER(20) NOT NULL,
	   country  	VARCHAR2(20) NOT NULL,
	   sportname  	VARCHAR2(20) NOT NULL
);

CREATE SEQUENCE olympic_id_seq;


ALTER TABLE olympic  ADD FOREIGN KEY (sportName) REFERENCES sport  (sportname);
ALTER TABLE olympic ADD FOREIGN KEY (playerNum)  REFERENCES player  (playerNum);
ALTER TABLE olympic ADD FOREIGN KEY (medal_id) REFERENCES medal  (medal_id);
