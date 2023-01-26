create table user35(
	num int primary key auto_increment,
	id varchar(40) not null unique,
	pw varchar(32) not null 
);

create table bbs35(
	num int primary key auto_increment,
	id varchar(40),
	sub varchar(50) default '제목없음',
	content text,
	cnt int default 0,
	foreign key (id) references user35(id)
);
-- dummy
insert into user35 values (0,'admin@bit.com',md5('1234'));
insert into user35 values (0,'user1@bit.com',md5('1234'));
insert into user35 values (0,'user2@bit.com',md5('1234'));
insert into user35 values (0,'user3@bit.com',md5('1234'));
commit;
insert into bbs35 values (0,'admin@bit.com','test1','testing...',0);
insert into bbs35 values (0,'admin@bit.com','test2','testing...',0);
insert into bbs35 values (0,'admin@bit.com','test3','testing...',0);
insert into bbs35 values (0,'admin@bit.com','test4','testing...',0);
commit;
select * from bbs35;