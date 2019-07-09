package kosta.product.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import kosta.bag.Controller;
import kosta.bag.ModelAndView;
import kosta.product.model.dto.ProductDTO;
import kosta.product.model.service.ProductService;

public class ProductSelectController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ProductSelectController�� handleRequestȣ��");
		String url = "views/errorView/error.jsp";
		try {
			List<ProductDTO> list = ProductService.selectAll();
			request.setAttribute("list", list);
			url="views/product/list.jsp";
			//url="index.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		ModelAndView mv = new ModelAndView();
		mv.setPath(url);//isRedirect()�� ���ϰ� false.(forward�κ����Ƿ�)//redirect�κ����� mv�� true��
		return mv;
	}
}
