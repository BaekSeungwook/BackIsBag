package kosta.product.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.bag.Controller;
import kosta.bag.ModelAndView;
import kosta.product.model.dto.ProductDTO;
import kosta.product.model.service.ProductService;

public class ProductInsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("InsertController의 handleRequest호출");
		ModelAndView mv = new ModelAndView();
		
		//넘어오는 값 받기
		ServletContext application  = request.getServletContext();
		String saveDir = application.getRealPath("/views/product/save");
		int maxSize=1024*1024*100;//100M
		String encoding = "UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize,
				encoding, new DefaultFileRenamePolicy());
		//넘어오는 값 받기
		String productName = m.getParameter("productName");
		String description = m.getParameter("description");
		String brandName = m.getParameter("brandName");
		String price = m.getParameter("price");
		String fileName = m.getFilesystemName("file");
		
		
		//description부분에 tag( < )를 문자(&it;)로 변경(텍스트에 태그가들어가도 안먹히게)
		description = description.replace("<", "&lt;");
		
		//폼에서 기본적으로 무조건 넘어오는데이터들은 총 5개
		ProductDTO productDTO = new ProductDTO(productName,description,brandName, Integer.parseInt(price), fileName);
		//만약 파일첨부가 되었다면... 파일이름, 파일크기를 조정
		if(m.getFilesystemName("file")!=null) {
			//파일이름
			productDTO.setFileName(m.getFilesystemName("file"));
		}
		//
		
		try {
			ProductService.insert(productDTO);
			mv.setPath("product");//리스트(list)로 가므로 가져갈게 없기때문에 redirect방식으로이동
			mv.setRedirect(true);//이동방식 redirect로설정(true)
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("views/errorView/error.jsp");//errorMsg가지고가므로 forward방식
		}
		
		return mv;
	}

}
