/**/
create table user(
id int not null auto_increment,
name varchar(20) not null,
age int not null,
primary key(id)
)engine = innodb auto_increment = 1 default charset = utf8;

create table role(
id int not null auto_increment,
name varchar(20) not null,
primary key(id)
)engine = innodb auto_increment = 1 default charset = utf8;

create table userrole(
id int not null auto_increment,
userid int not null,
roleid int not null,
primary key(id)
)engine = innodb auto_increment = 1 default charset = utf8;


alter table userrole add constraint fk_uid foreign key(userid) references user(id);
alter table userrole add constraint fk_rid foreign key(roleid) references role(id);

insert into user(name,age) values 
('zhsy',32),
('crg',33),
('cjj',99);

insert into role(name) values 
('GM'),
('高级玩家'),
('骨灰级玩家');

insert into userrole(userid,roleid) values 
(1,1),
(1,3),
(2,1),
(2,2),
(3,1),
(3,2),
(3,3);
