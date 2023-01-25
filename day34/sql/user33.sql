drop table user33;
create table user33(
	num int primary key auto_increment,
	name varchar(5) unique not null,
	gender char(1) not null check (gender in ('m','f'))
);

-- dummy
insert into user33 (name,gender) values ('user1','m');
insert into user33 (name,gender) values ('user2','f');
insert into user33 (name,gender) values ('user3','f');
insert into user33 (name,gender) values ('user4','f');
insert into user33 (name,gender) values ('user5','m');
commit;
select * from user33;


