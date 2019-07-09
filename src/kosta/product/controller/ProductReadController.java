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
		System.out.println("ProductReadController의 handleRequest호출");

		String url = "errorView/error.jsp";
		ModelAndView mv = new ModelAndView();
		//list.jsp에서 <a href="elec?command=read&modelNum의 modelNum과 get의 modelNum이 같아야한다
		int proCode = Integer.parseInt(request.getParameter("proCode"));
		//UpdateController에서 &flag로 flag를 보낸것을 받는다(수정에서 넘어왔다는 표시)
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
