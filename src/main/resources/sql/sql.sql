create table user (id int,name varchar(255),age int,address varchar(255));

create table role (id int,usrId int,des varchar(255));

create table function (id int,roleId int,url varchar(255));

create table login (id int,usrId int,loginName varchar(255),password varchar(255));