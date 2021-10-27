create table board(
    seq number(5) primary key,
    title varchar2(200) not null,
    writer varchar2(50) not null,
    content varchar2(2000),
    regdate date default sysdate,
    cnt number default 0
);

create table users(
    id varchar2(8) primary key,
    password varchar2(8) not null,
    name varchar2(30), not null,
    regDate date default sysdate,
    role varchar2 default 'user'
);