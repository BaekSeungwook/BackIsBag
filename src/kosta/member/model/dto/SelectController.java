package kosta.member.model.dto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

public class SelectController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SelectController의 handleRequest호출");
		String url = "errorView/error.jsp";
		try {
			List<Electronics> list = ElectronicsService.selectAll();
			request.setAttribute("list", list);
			url="elecView/list.jsp";
		} catch (SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		ModelAndView mv = new ModelAndView();
		mv.setPath(url);//isRedirect()의 리턴값 false.(forward로보내므로)//redirect로보낼땐 mv를 true로
		return mv;
	}
}
