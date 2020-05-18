

-- Chapter 7 
-- 회원 테이블

CREATE TABLE TB_MEMBER(
    USER_ID VARCHAR2(10) Primary key not null
   ,USER_PWD VARCHAR2(10) not null
   ,USER_NAME VARCHAR2(50) not null
   ,USER_EMAIL varchar2(50) not null
   ,DEL_FLG varchar(1) default 'N'
   ,REG_DATE date default sysdate
)

--회원 추가
insert into TB_MEMBER values('julie','1234','줄리','julie@test.com',"N",sysdate);

--회원 테이블 생성(교재)
create table t_member(
    id varchar2(10) primary key,
    pwd varchar2(10),
    name varchar2(50),
    email varchar2(50),
    joinDate date default sysdate
)

--회원정보 추가 (교재) 
insert into t_member values('julie','1234','줄리','julie@test.com',sysdate);