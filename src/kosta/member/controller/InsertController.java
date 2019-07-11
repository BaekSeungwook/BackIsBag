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
		//넘어오는 값 받기
		ServletContext application = request.getServletContext();
		/*String saveDir = application.getRealPath("/save");
		int maxSize = 1024*1024*100; //100M 
		String encoding = "UTF-8";
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());*/
		//넘어오는 값 받기
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
		 * description 부분에 tag(<)를 문자(&lt;)로 변경
		 */
		//description = description.replace("<", "&lt;");
		MemberDTO dto = new MemberDTO(memberId, memberPass, memberName, memberEmail, 
				memberCellphone, memberAddr, memberDate, memberGrade, Integer.parseInt(memberAge));
		
		//만약, 파일첨부가 되었다면... 파일이름, 파일크기를 저장
		/*if(m.getFilesystemName("file") != null) {
			//파일이름
			dto.setFname(m.getFilesystemName("file"));
			//파일크기
			dto.setFsize((int)m.getFile("file").length());
		}*/
		try {
			MemberService.insert(dto);  //성공 시에... sendRedirect (상태정보 유지 필요 x)
			mv.setPath("member");
			mv.setRedirect(true);
		}catch(SQLException e) {
			request.setAttribute("errorMsg", e.getMessage()); //forward (상태정보를 유지하고)
			mv.setPath(url);
		}
		return mv;
	}

}
