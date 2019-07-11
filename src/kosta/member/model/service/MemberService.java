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
		if(result==0) throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
			return result;
	}
		
	public static MemberDTO memberId(String memberId) throws SQLException, IOException {
		MemberDTO memberDTO = memberDAO.memberId(memberId);
		if(memberDTO==null) throw new SQLException(memberId + "�� �ش��ϴ� ������ �����ϴ�.");
			return memberDTO;
			
	}
		
	/*public static int update(MemberDTO memberDTO) throws SQLException, IOException {
		MemberDTO dto = memberDAO.memberId(memberDTO.getMemberId());
		if(!dto.getMemberPass().equals(memberDTO.getMemberPass())) {
			throw new SQLException("��й�ȣ�� �ٽ� Ȯ�����ּ���");
		}
		int result = memberDAO.update(memberDTO);			
		if(result == 0) throw new SQLException("�������� �ʾҽ��ϴ�.");
			return result;
		}*/
	
	public static int update(MemberDTO memberDTO) throws SQLException, IOException {
		//System.out.println("memberDTO.getMemberPass() : " + memberDTO.getMemberPass());
		MemberDTO dbMemberDTO = memberDAO.memberId(memberDTO.getMemberId());
		if(!dbMemberDTO.getMemberPass().equals(memberDTO.getMemberPass())) {
			throw new SQLException("��й�ȣ�� �ٽ� Ȯ�����ּ���");
		}
		int result = memberDAO.update(memberDTO);			
		if(result == 0) throw new SQLException("�������� �ʾҽ��ϴ�.");
			return result;
		}
		
	public static int delete(String memberId, String memberPass) throws SQLException, IOException {
		MemberDTO dbMemberDTO = memberDAO.memberId(memberId);
		System.out.println("MemberService���� �׽�Ʈ" + memberPass);
		/*System.out.println(memberPass);
		System.out.println(memberId);*/
		if(!dbMemberDTO.getMemberPass().equals(memberPass)) {
			throw new SQLException("��й�ȣ �����Դϴ�.");
		}
		int result = memberDAO.delete(memberId, memberPass);
		if(result==0) throw new SQLException("�������� �ʾҽ��ϴ�.");
		return result;
		
		}
}
