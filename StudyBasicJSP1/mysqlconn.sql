show databases;

create table member(
	id varchar(50) not null primary key,
	passwd varchar(16) not null,
	name varchar(10) not null,
	reg_date datetime not null
);

create table test(
	num_id int not null primary key auto_increment,
	title varchar(50) not null,
	content text not null
);

desc member;

desc test;

drop table test;

show tables;

INSERT INTO member values('kingdora@dragon.com','1234','김개동',now());
INSERT INTO member values('hongkd@aaa.com','1111','홍길동',now());

select * from member;

UPDATE member set passwd='4567' where id='hongkd@aaa.com';


----------------------------------------------

create table board(

	num int not null primary key auto_increment,
	writer varchar(10) not null,
	email varchar(30),
	subject varchar(50) not null,
	passwd varchar(12) not null,
	reg_date datetime not null,
	readcount int default 0,
	ref int not null,
	re_step smallint not null,
	re_level smallint not null,
	content text not null,
	ip varchar(20) not null
);

select * from board;

