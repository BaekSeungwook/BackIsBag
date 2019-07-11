package kosta.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.bag.ModelAndView;
import kosta.member.model.dto.MemberDTO;
import kosta.member.model.service.MemberService;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "errorView/error.jsp";
		ModelAndView mv = new ModelAndView();
		String memberId = request.getParameter("memberId");
		String memberPass = request.getParameter("memberPass");
		String memberEmail = request.getParameter("memberEmail");
		String memberCellphone = request.getParameter("memberCellphone");
		String memberAddr = request.getParameter("memberAddr");
		
		MemberDTO dto = new MemberDTO(memberId, memberPass, memberEmail, memberCellphone, memberAddr);
		try {
			MemberService.update(dto);
			url = "member?command=read&memberId=" + memberId;
			mv.setRedirect(true);
		}catch(SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		mv.setPath(url);
		return mv;
	}
}