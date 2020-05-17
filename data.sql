create database lidarlab;

use lidarlab;

create table banner (
	`id` int not null auto_increment comment '宣传图id',
    `picture` varchar(256) not null comment '图片存储地址',
    `text` varchar(256) not null comment '图片描述',
    primary key(`id`)
) engine=InnoDB default charset=utf8mb4;

create table people (
	`id` int not null auto_increment comment '成员id',
    `picture` varchar(256) not null comment '图片存储地址',
    `name` varchar(50) not null comment '成员姓名',
    `detail` longtext comment '详细信息',
    `type` char(2) not null comment '学生S老师T大写',
    primary key(`id`)
) engine=InnoDB default charset=utf8mb4;

create table research (
    `id` int auto_increment comment '自增主键',
    `name` varchar(80) not null comment '研究名称',
    `picture` varchar(256) not null comment '图片',
    `detail` longtext not null comment '详细信息的富文本',
    primary key (`id`)
) engine=InnoDB default charset=utf8mb4;

create table kvtable(
    `id` int auto_increment not null comment '自增主键',
    `name` varchar(30) not null comment '名称',
    `content` longtext comment '内容',
    primary key (`id`)
) engine = InnoDB default charset = utf8mb4;

create table user (
	`username` varchar(30) not null comment '用户名',
    `password` varchar(30) not null comment '密码',
    `auth` varchar(20) not null comment '用户角色',
    primary key (`username`)
) engine=InnoDB default charset=utf8mb4;