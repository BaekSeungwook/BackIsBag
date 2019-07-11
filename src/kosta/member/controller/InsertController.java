package kosta.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.bag.Controller;
import kosta.bag.ModelAndView;
import kosta.member.model.dto.MemberDTO;
import kosta.member.model.service.MemberService;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "errorView/error.jsp";
		ModelAndView mv = new ModelAndView();
		//�Ѿ���� �� �ޱ�
		ServletContext application = request.getServletContext();
		/*String saveDir = application.getRealPath("/save");
		int maxSize = 1024*1024*100; //100M 
		String encoding = "UTF-8";
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());*/
		//�Ѿ���� �� �ޱ�
		String memberId = request.getParameter("memberId");
		String memberPass = request.getParameter("memberPass");
		String memberName = request.getParameter("memberName");
		String memberEmail = request.getParameter("memberEmail");
		String memberCellphone = request.getParameter("memberCellphone");
		String memberAddr = request.getParameter("memberAddr");
		String memberDate = request.getParameter("memberDate");
		String memberGrade = request.getParameter("memberGrade");
		String memberAge = request.getParameter("memberAge");
		
		/*
		 * description �κп� tag(<)�� ����(&lt;)�� ����
		 */
		//description = description.replace("<", "&lt;");
		MemberDTO dto = new MemberDTO(memberId, memberPass, memberName, memberEmail, 
				memberCellphone, memberAddr, memberDate, memberGrade, Integer.parseInt(memberAge));
		
		//����, ����÷�ΰ� �Ǿ��ٸ�... �����̸�, ����ũ�⸦ ����
		/*if(m.getFilesystemName("file") != null) {
			//�����̸�
			dto.setFname(m.getFilesystemName("file"));
			//����ũ��
			dto.setFsize((int)m.getFile("file").length());
		}*/
		try {
			MemberService.insert(dto);  //���� �ÿ�... sendRedirect (�������� ���� �ʿ� x)
			mv.setPath("member");
			mv.setRedirect(true);
		}catch(SQLException e) {
			request.setAttribute("errorMsg", e.getMessage()); //forward (���������� �����ϰ�)
			mv.setPath(url);
		}
		return mv;
	}

}
