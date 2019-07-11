package kosta.member.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.bag.Controller;
import kosta.bag.ModelAndView;
import kosta.member.model.dto.MemberDTO;
import kosta.member.model.service.MemberService;

public class selectBySearchController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�˻���Ʈ�ѷ�");
		String url = "errorView/error.jsp";
		try { //����ó���� controller���� ó����
			String keyField = request.getParameter("keyField");
			String keyWord = request.getParameter("keyWord");
			//���� -> dao -> �� ����� list�� �����ϰ� list.jsp�� �̵�
			List<MemberDTO> list = MemberService.selectBySearch(keyField, keyWord);
			request.setAttribute("list", list);
			url= "member/memberList.jsp";
		} catch(SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		ModelAndView mv = new ModelAndView(); //�̵������ �����ϴ� ModelAndView
		mv.setPath(url);
		return mv;
		}
	}

