package kosta.member.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.bag.ModelAndView;
import kosta.member.model.dto.MemberDTO;
import kosta.member.model.service.MemberService;


public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "errorView/error.jsp";
		try { //����ó���� controller���� ó����
			//���� -> dao -> �� ����� list�� �����ϰ� list.jsp�� �̵�
			List<MemberDTO> list = MemberService.memberAll();
			request.setAttribute("list", list);
			url="member/memberList.jsp";
		} catch(SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		ModelAndView mv = new ModelAndView(); //�̵������ �����ϴ� ModelAndView
		mv.setPath(url);
		return mv;
	}

}
