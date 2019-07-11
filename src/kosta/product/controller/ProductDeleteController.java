package kosta.product.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.bag.Controller;
import kosta.bag.ModelAndView;
import kosta.product.model.service.ProductService;

public class ProductDeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "views/errorView/error.jsp";
		ModelAndView mv = new ModelAndView();
		String proCode = request.getParameter("proCode");
		
		try {
			ProductService.delete(Integer.parseInt(proCode));
			url="product";
			mv.setRedirect(true);
		} catch (SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		mv.setPath(url);
		return mv;
	}

}
