package kosta.product.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.bag.Controller;
import kosta.bag.ModelAndView;
import kosta.product.model.dto.ProductDTO;
import kosta.product.model.service.ProductService;

public class ProductReadController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ProductReadController�� handleRequestȣ��");

		String url = "errorView/error.jsp";
		ModelAndView mv = new ModelAndView();
		//list.jsp���� <a href="elec?command=read&modelNum�� modelNum�� get�� modelNum�� ���ƾ��Ѵ�
		int proCode = Integer.parseInt(request.getParameter("proCode"));
		//UpdateController���� &flag�� flag�� �������� �޴´�(�������� �Ѿ�Դٴ� ǥ��)
		String flag = request.getParameter("flag"); 
		try{
			ProductDTO productDTO = 
					ProductService.selectByCodenum(proCode);
			request.setAttribute("productDTO", productDTO);
			url="views/product/read.jsp";
		} catch (SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		mv.setPath(url);
		return mv;
	}

}
