package kosta.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.bag.ModelAndView;
import kosta.member.model.dto.MemberDTO;
import kosta.member.model.service.MemberService;

public class ReadController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "errorView/error.jsp";
		ModelAndView mv = new ModelAndView();
		String memberId = request.getParameter("memberId");
		//String flag = request.getParameter("flag");
		//boolean state = flag==null? true : false;
		try {
			MemberDTO dto = MemberService.memberId(memberId);
			request.setAttribute("dto", dto);
			url = "member/memberRead.jsp";
		}catch(SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		mv.setPath(url);
		return mv;
	}

}
