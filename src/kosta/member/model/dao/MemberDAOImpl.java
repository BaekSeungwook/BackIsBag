package kosta.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.member.model.dto.MemberDTO;
import kosta.util.DbUtil;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public List<MemberDTO> memberAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MemberDTO> list = new ArrayList<>();
		String sql = "select * from m_table order by m_date";     //전체검색
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
					list.add(dto);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public MemberDTO memberId(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberDTO dto = null;
		String sql = "select * from m_table where m_id=?";   //회원 아이디로 검색
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return dto;
	}

	@Override
	public int insert(MemberDTO memberDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		//String sql = "insert into m_table values(?,?,?,?,?,?,sysdate,'b',?)";
		String sql = "insert into m_table values(?,?,?,?,?,?,sysdate,'b',?)";     //회원등록
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberDTO.getMemberId());
			ps.setString(2, memberDTO.getMemberPass());
			ps.setString(3, memberDTO.getMemberName());
			ps.setString(4, memberDTO.getMemberEmail());
			ps.setString(5, memberDTO.getMemberCellphone());
			ps.setString(6, memberDTO.getMemberAddr());
			ps.setInt(7, memberDTO.getMemberAge());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public boolean memberIdCheck(String memberId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean result=false;
		String sql = "select id from member where id=?";   //등록 전에 id 중복체크
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			if(rs.next()) {
				result=true;
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}

	@Override
	public int update(MemberDTO memberDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update m_table set m_pass=?,m_email=?,m_cellphone=?,m_addr=? where m_id=?";  //회원정보수정
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberDTO.getMemberPass());
			ps.setString(2, memberDTO.getMemberEmail());
			ps.setString(3, memberDTO.getMemberCellphone());
			ps.setString(4, memberDTO.getMemberAddr());
			ps.setString(5, memberDTO.getMemberId());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int delete(String memberId, String memberPass) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from m_table where m_id=?";  //회원삭제
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);
			System.out.println("MemberDAO 테스트" + memberPass);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
}
