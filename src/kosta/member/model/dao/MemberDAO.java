package kosta.member.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.member.model.dto.MemberDTO;

public interface MemberDAO {
	/**
	 *	회원 목록 전체 검색(관리자)
	 *	select * from m_table order by m_date
	 */
	List<MemberDTO> memberAll() throws SQLException;
	
	/**
	 *	회원 아이디로 검색
	 *	select * from m_table where m_id=?
	 */
	MemberDTO memberId(String memberId) throws SQLException;
	
	/**
	 *	회원등록
	 *	insert into m_table(m_id,m_pass,m_name,m_email,m_cellphone,m_addr,m_date,m_grade,m_age) values(?,?,?,?,?,?,sysdate,default,?)
	 *	insert into m_table values(?,?,?,?,?,?,sysdate,'B',?)
	 */
	int insert(MemberDTO memberDTO) throws SQLException;
	
	/**
	  *	등록 전에 id 중복체크 : 
	  *	select id from member where id=?
	  *	return true이면 중복, false이면 중복아님
	  */
	
	boolean memberIdCheck(String memberId) throws SQLException;
	
	/**
	 *	회원정보 수정
	 *	update m_table set m_pass=?,m_email=?,m_cellphone=?,m_addr=? where m_id=?
	 */
	int update(MemberDTO memberDTO) throws SQLException;
	
	/**
	 *	회원탈퇴
	 *	delete from m_table where m_id=? and m_pass=?
	 */
	int delete(String memberId, String memberPass) throws SQLException;
	
	/**
	 *	회원정보 리스트에서 조건 검색
	 *	select * from member where id like - 아이디
	 *	select * from member where name like - 이름
	 *	select * from member where addr like - 주소
	 */
	List<MemberDTO> selectBykeySearch(String keyField, String keyWord) throws SQLException;
	
	
}
