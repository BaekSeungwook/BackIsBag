package kosta.member.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.member.model.dto.MemberDTO;

public interface MemberDAO {
	/**
	 *	ȸ�� ��� ��ü �˻�(������)
	 *	select * from m_table order by m_date
	 */
	List<MemberDTO> memberAll() throws SQLException;
	
	/**
	 *	ȸ�� ���̵�� �˻�
	 *	select * from m_table where m_id=?
	 */
	MemberDTO memberId(String memberId) throws SQLException;
	
	/**
	 *	ȸ�����
	 *	insert into m_table(m_id,m_pass,m_name,m_email,m_cellphone,m_addr,m_date,m_grade,m_age) values(?,?,?,?,?,?,sysdate,default,?)
	 *	insert into m_table values(?,?,?,?,?,?,sysdate,'B',?)
	 */
	int insert(MemberDTO memberDTO) throws SQLException;
	
	/**
	  *	��� ���� id �ߺ�üũ : 
	  *	select id from member where id=?
	  *	return true�̸� �ߺ�, false�̸� �ߺ��ƴ�
	  */
	
	boolean memberIdCheck(String memberId) throws SQLException;
	
	/**
	 *	ȸ������ ����
	 *	update m_table set m_pass=?,m_email=?,m_cellphone=?,m_addr=? where m_id=?
	 */
	int update(MemberDTO memberDTO) throws SQLException;
	
	/**
	 *	ȸ��Ż��
	 *	delete from m_table where m_id=? and m_pass=?
	 */
	int delete(String memberId, String memberPass) throws SQLException;
	
	/**
	 *	ȸ������ ����Ʈ���� ���� �˻�
	 *	select * from member where id like - ���̵�
	 *	select * from member where name like - �̸�
	 *	select * from member where addr like - �ּ�
	 */
	List<MemberDTO> selectBykeySearch(String keyField, String keyWord) throws SQLException;
	
	
}
