package kosta.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.bag.Controller;
import kosta.bag.ModelAndView;
import kosta.member.model.service.MemberService;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "errorView/error.jsp";
		ModelAndView mv = new ModelAndView();
		String memberId = request.getParameter("memberId");
		String memberPass = request.getParameter("memberPass");
		System.out.println("컨트롤러 테스트 : " + memberPass);
		try {
			MemberService.delete(memberId, memberPass);
			url = "product?command=select";
			mv.setRedirect(true);
		}catch(SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		mv.setPath(url);
		return mv;
	}

}
