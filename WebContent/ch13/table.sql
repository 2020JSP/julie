create table t_member
    (id varchar2(10) primary key,
    pwd varchar2(10),
    name  varchar2(50),
    email varchar2(50),
    joinDate date default sysdate);