create table bbs36(
num int primary key auto_increment,
sub varchar(50),
content text,
ref int, 
seq int default 0,
lvl int default 0
);

insert into bbs36 values (0,'test1','test',1,0,0);
commit;
insert into bbs36 values (0,'test2','test',2,0,0);
commit;
insert into bbs36 values (0,'test3','test',3,0,0);
commit;
insert into bbs36 values (0,'test4','test',(select 1+last_insert_id()),0,0);
commit;

select last_insert_id();
select * from bbs36 order by ref desc, seq asc;


