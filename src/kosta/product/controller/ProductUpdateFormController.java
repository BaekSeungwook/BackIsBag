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

public class ProductUpdateFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "views/errorView/error.jsp";
		int proCode = Integer.parseInt(request.getParameter("proCode"));
		try {
			ProductDTO productDTO = ProductService.selectByCodenum(proCode);
			request.setAttribute("productDTO", productDTO);
			url = "views/product/update.jsp";
		} catch (SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		ModelAndView mv = new ModelAndView();
		mv.setPath(url);
		return mv;
	}
}
