--使用数据库hrm_db
use hrm_db;
--创建employee_inf
drop table if exists employee_inf;
create table employee_inf(
    id int(11) not null auto_increment,
    primary key(id)
)ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
insert into employee_inf(id, login_name, password, status, create_date, username) values
(1,'admin','123456',2,'2018-05-20 09:33:45','超级管理员');