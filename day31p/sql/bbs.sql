drop table IF EXISTS bbs01;
-- bbs table
create table bbs01(
	num int primary key auto_increment,
	id varchar(30) not null,
	sub varchar(50) default '제목없음',
	content text,
	nalja date
);
-- dummy data
insert into bbs01 (id,sub,content,nalja) values ('tester','test1','testing...',now());
insert into bbs01 (id,sub,content,nalja) values ('tester','test2','testing...',now());
insert into bbs01 (id,sub,content,nalja) values ('tester','test3','testing...',now());
insert into bbs01 (id,sub,content,nalja) values ('tester','test4','testing...',now());
insert into bbs01 (id,sub,content,nalja) values ('tester','test5','testing...',now());
commit;
select * from bbs01 order by num desc;