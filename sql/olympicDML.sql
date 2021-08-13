-- player insert[선수]
insert into player values('1', '양학선', '30', '대한민국','체조');
insert into player values('2', '안산', '21', '대한민국', '양궁');
insert into player values('3', '김연경', '33', '대한민국', '배구');
insert into player values('4','토드 프레이저','35','미국','야구');
insert into player values('5','마이클 펠프스','36','미국','수영');
insert into player values('6','리웬웬','21','중국','역도');


-- sport insert[종목]
insert into sport values('체조', '대한민국', '5');
insert into sport values('양궁', '대한민국', '3');
insert into sport values('배구', '대한민국', '0');
insert into sport values('야구', '미국', '1');
insert into sport values('수영', '미국', '3');
insert into sport values('역도', '중국', '8');


-- medal insert[메달 정보]
insert into medal values('kg','대한민국','체조','1','0','0');
insert into medal values('ka','대한민국','양궁','0','1','2');
insert into medal values('kv','대한민국','배구','0','0','0');
insert into medal values('ab','미국','야구','0','1','0');
insert into medal values('as','미국','수영','4','0','0');
insert into medal values('cw','중국','역도','7','0','1');


-- olympic insert[올림픽]
insert into olympic values(olympic_id_seq.nextval, '대한민국', '체조', '1','kg');
insert into OLYMPIC values(OLYMPIC_ID_seq.nextval, '대한민국', '양궁', '2','ka');
insert into OLYMPIC values(OLYMPIC_ID_seq.nextval, '대한민국', '배구', '3','kv');
insert into OLYMPIC values(OLYMPIC_ID_seq.nextval, '미국', '야구', '4','ab');
insert into OLYMPIC values(OLYMPIC_ID_seq.nextval, '미국', '수영', '5','as');
insert into OLYMPIC values(OLYMPIC_ID_seq.nextval, '중국', '역도', '6','cw');
commit;
