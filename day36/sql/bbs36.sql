create table bbs36(
num int primary key,
sub varchar(50),
content text,
ref int, 
seq int default 0,
lvl int default 0
);

insert into bbs36 values (1,'test1','test',1,0,0);
commit;
insert into bbs36 values (2,'test2','test',2,0,0);
commit;
insert into bbs36 values ((select max(num)+1 from bbs36 a),'test3','test',(select max(num)+1 from bbs36 b),0,0);
commit;
insert into bbs36 values (0,'test4','test',(select 1+last_insert_id()),0,0);
commit;

select last_insert_id();
select * from bbs36 order by ref desc, seq asc;


