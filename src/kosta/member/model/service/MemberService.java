package kosta.member.model.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import kosta.member.model.dao.MemberDAO;
import kosta.member.model.dao.MemberDAOImpl;
import kosta.member.model.dto.MemberDTO;


public class MemberService {
	private static MemberDAO memberDAO = new MemberDAOImpl();
	
	public static List<MemberDTO> memberAll() throws SQLException, IOException {
		List<MemberDTO> list = memberDAO.memberAll();
		return list;
	}
	
	public static int insert(MemberDTO memberDTO) throws SQLException, IOException {
		int result = memberDAO.insert(memberDTO);
		if(result==0) throw new SQLException("등록되지 않았습니다.");
			return result;
	}
		
	public static MemberDTO memberId(String memberId) throws SQLException, IOException {
		MemberDTO memberDTO = memberDAO.memberId(memberId);
		if(memberDTO==null) throw new SQLException(memberId + "에 해당하는 정보가 없습니다.");
			return memberDTO;
			
	}
		
	/*public static int update(MemberDTO memberDTO) throws SQLException, IOException {
		MemberDTO dto = memberDAO.memberId(memberDTO.getMemberId());
		if(!dto.getMemberPass().equals(memberDTO.getMemberPass())) {
			throw new SQLException("비밀번호를 다시 확인해주세요");
		}
		int result = memberDAO.update(memberDTO);			
		if(result == 0) throw new SQLException("수정되지 않았습니다.");
			return result;
		}*/
	
	public static int update(MemberDTO memberDTO) throws SQLException, IOException {
		//System.out.println("memberDTO.getMemberPass() : " + memberDTO.getMemberPass());
		MemberDTO dbMemberDTO = memberDAO.memberId(memberDTO.getMemberId());
		if(!dbMemberDTO.getMemberPass().equals(memberDTO.getMemberPass())) {
			throw new SQLException("비밀번호를 다시 확인해주세요");
		}
		int result = memberDAO.update(memberDTO);			
		if(result == 0) throw new SQLException("수정되지 않았습니다.");
			return result;
		}
		
	public static int delete(String memberId, String memberPass) throws SQLException, IOException {
		MemberDTO dbMemberDTO = memberDAO.memberId(memberId);
		System.out.println("MemberService에서 테스트" + memberPass);
		/*System.out.println(memberPass);
		System.out.println(memberId);*/
		if(!dbMemberDTO.getMemberPass().equals(memberPass)) {
			throw new SQLException("비밀번호 오류입니다.");
		}
		int result = memberDAO.delete(memberId, memberPass);
		if(result==0) throw new SQLException("삭제되지 않았습니다.");
		return result;
		
		}
}
