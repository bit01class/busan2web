create table stu33(
	num int primary key auto_increment,
	kor int not null default 0 check 
				 (kor between 0 and 100),
--				(kor>= 0 and kor <=100),
	eng int not null default 0 check 
				(eng between 0 and 100),
	math int not null default 0 check 
				(math between 0 and 100)
);
-- dummy data
insert into stu33 (kor,eng,math) values (99,88,77);
insert into stu33 (kor,eng,math) values (94,85,71);
insert into stu33 (kor,eng,math) values (93,81,74);
commit;

select * from stu33;




