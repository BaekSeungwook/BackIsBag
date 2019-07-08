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
		System.out.println("SelectController�� handleRequestȣ��");
		String url = "errorView/error.jsp";
		try {
			List<Electronics> list = ElectronicsService.selectAll();
			request.setAttribute("list", list);
			url="elecView/list.jsp";
		} catch (SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		ModelAndView mv = new ModelAndView();
		mv.setPath(url);//isRedirect()�� ���ϰ� false.(forward�κ����Ƿ�)//redirect�κ����� mv�� true��
		return mv;
	}
}
