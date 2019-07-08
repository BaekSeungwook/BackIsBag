
drop table product;
drop table member;
drop table reviewboard;
drop sequence reviewboard_seq;

--*****  ȸ�����̺�  *****--
create table member(
    member_id varchar2(20) primary key,  -- ȸ�� ���̵�
    member_pass varchar2(30) not null,   -- ȸ�� ��й�ȣ
    member_name varchar2(10) not null,   -- ȸ�� �̸�
    member_birth varchar(50) not null,  -- ȸ�� �������
    member_gender varchar2(5) not null,    -- ȸ�� ����
    member_email varchar2(50),   -- ȸ�� �̸���
    member_cellphone varchar2(20) not null,  -- ȸ�� �޴�����ȣ
    member_addr varchar2(50) not null,   -- ȸ�� �ּ�
    member_date DATE default sysdate --���Գ�¥   
);

--*****  ��ǰ���̺�  *****--
create table product(
pdcode varchar2(20) primary key, --��ǰ �ڵ�
member_id varchar2(20) references member(member_id), --ȸ�� ���̵�
pdname varchar2(20) not null, -- ��ǰ �̸�
product_desc varchar2(50), --��ǰ ����
numsales number(10) not null, --�Ǹŷ�
regdate varchar2(20) not null, --����� default ��: sysdate
numstock number(10) not null, -- ���
price number(10) not null, --����
brand varchar(30) not null --�귣��
--recommend number; --(���ƿ� / ���ϱ� ����)
);

--*****  �ı����̺�  *****--
create table reviewboard(
    reviewNo number primary key, --�۹�ȣ
    pdCode varchar2(30) not null references product(pdcode) on delete cascade, --��ǰ�̸� 
    reviewTitle varchar2(20) not null, --������
    reviewFileName varchar2(30), --÷�������̸�(������ �÷��������̸�:�ߺ�����)
    reviewContent varchar2(300) not null, --�۳���
    member_id varchar2(20) references member(member_id), -- ȸ�� ���̵�
    writeDate date default sysdate, --�ۼ���¥
    score varchar2(15) not null --����
);

create sequence reviewboard_seq; -- ����������

select * from member;
select * from product;
select * from reviewboard;

rollback;
commit;
