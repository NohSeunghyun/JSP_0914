drop table dog;

create table dog(
	id number primary key,--상품아이디 auto_increment는 mySql에서만 사용가능
	kind varchar2(12) not null,--개품종
	price number not null,--개 가격
	image varchar2(20) not null,--개 이미지
	country varchar2(12) not null,--원산지
	height number,--평균 개 신장
	weight number,--평균 개 몸무게
	content varchar2(400),--개 설명
	readcount number--조회수
);

drop sequence dog_seq;

create sequence dog_seq;

insert into dog values(dog_seq.nextval, '푸들', 1000, 'pu.jpg', '프랑스', 1, 20, '털 많다', 0);
insert into dog values(dog_seq.nextval, '불독', 2000, 'bul.jpg', '독일', 1, 20, '못생겼다', 0);
insert into dog values(dog_seq.nextval, '진돗개', 3000, 'jin.jpg', '대한민국', 1, 20, '최고다', 0);
insert into dog values(dog_seq.nextval, '허스키', 4000, 'h.jpg', '북극', 1, 20, '멋지다', 0);

commit

select * from dog;