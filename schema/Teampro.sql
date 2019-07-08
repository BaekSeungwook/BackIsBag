
drop table product;
drop table member;
drop table reviewboard;
drop sequence reviewboard_seq;

--*****  회원테이블  *****--
create table member(
    member_id varchar2(20) primary key,  -- 회원 아이디
    member_pass varchar2(30) not null,   -- 회원 비밀번호
    member_name varchar2(10) not null,   -- 회원 이름
    member_birth varchar(50) not null,  -- 회원 생년월일
    member_gender varchar2(5) not null,    -- 회원 성별
    member_email varchar2(50),   -- 회원 이메일
    member_cellphone varchar2(20) not null,  -- 회원 휴대폰번호
    member_addr varchar2(50) not null,   -- 회원 주소
    member_date DATE default sysdate --가입날짜   
);

--*****  상품테이블  *****--
create table product(
pdcode varchar2(20) primary key, --상품 코드
member_id varchar2(20) references member(member_id), --회원 아이디
pdname varchar2(20) not null, -- 상품 이름
product_desc varchar2(50), --상품 설명
numsales number(10) not null, --판매량
regdate varchar2(20) not null, --등록일 default 값: sysdate
numstock number(10) not null, -- 재고량
price number(10) not null, --가격
brand varchar(30) not null --브랜드
--recommend number; --(좋아요 / 찜하기 점수)
);

--*****  후기테이블  *****--
create table reviewboard(
    reviewNo number primary key, --글번호
    pdCode varchar2(30) not null references product(pdcode) on delete cascade, --상품이름 
    reviewTitle varchar2(20) not null, --글제목
    reviewFileName varchar2(30), --첨부파일이름(서버에 올려진파일이름:중복방지)
    reviewContent varchar2(300) not null, --글내용
    member_id varchar2(20) references member(member_id), -- 회원 아이디
    writeDate date default sysdate, --작성날짜
    score varchar2(15) not null --평점
);

create sequence reviewboard_seq; -- 시퀀스생성

select * from member;
select * from product;
select * from reviewboard;

rollback;
commit;
