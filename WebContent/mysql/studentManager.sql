create database StudentInfo;
use StudentInfo;
drop table if exists student;
drop table if exists user;
drop table if exists class;
drop table if exists course;

create table user(
	id int auto_increment primary key,
	username nvarchar(20) null,
    password nvarchar(20) null,
    name nvarchar(20) null,
	gender nchar(10) null,
	age int null,
	address nvarchar(20) null,
	phone nvarchar(11) unique null,
	email nvarchar(30) null
);

create table student(
	id int auto_increment primary key,
	name nvarchar(20) null,
	gender nvarchar(10) null,
	age int null,
	classno nvarchar(20) null,
	phone nvarchar(11) unique null,
	email nvarchar(30) null
);

create table class(
	id int auto_increment primary key,
	cno nvarchar(10) null,
	classname nvarchar(30) null,
	department nvarchar(30) null
);

create table course(
	id int auto_increment primary key,
	courseno nvarchar(20) null,
    coursename nvarchar(20) null,
    type nvarchar(8) null,
	period int null,
    credit double null
);


