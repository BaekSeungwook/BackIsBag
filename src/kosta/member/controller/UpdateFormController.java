package kosta.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.bag.ModelAndView;
import kosta.member.model.dto.MemberDTO;
import kosta.member.model.service.MemberService;

public class UpdateFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "errorView/error.jsp";
		String memberId = request.getParameter("memberId");
		try {
			MemberDTO dto =MemberService.memberId(memberId);
			request.setAttribute("dto", dto);
			url = "member/memberUpdate.jsp";
		} catch(SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		ModelAndView mv = new ModelAndView();
		mv.setPath(url);
		return mv;
	}
}