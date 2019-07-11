package kosta.product.controller;

import java.io.IOException;
import java.net.URLEncoder;
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

public class ProductUpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ProductUpdateController호출");
		ModelAndView mv = new ModelAndView();
		
		String url ="errirView/error.jsp";
		
		//넘어오는 값 받기
		ServletContext application  = request.getServletContext();
		String saveDir = application.getRealPath("/views/product/save");
		int maxSize=1024*1024*100;//100M
		String encoding = "UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize,
				encoding, new DefaultFileRenamePolicy());
		//넘어오는 값 받기
		String proCode = m.getParameter("proCode");
		String productName = m.getParameter("productName");
		String description = m.getParameter("description");
		String brandName = m.getParameter("brandName");
		String price = m.getParameter("price");
		String fileName = m.getFilesystemName("file");
		
		
		//description부분에 tag( < )를 문자(&it;)로 변경(텍스트에 태그가들어가도 안먹히게)
		description = description.replace("<", "&lt;");
		
		ProductDTO productDTO =
				new ProductDTO(Integer.parseInt(proCode), productName, description, brandName, Integer.parseInt(price), fileName);
		
		if(m.getFilesystemName("file")!=null) {
			//파일이름
			productDTO.setFileName(m.getFilesystemName("file"));
		}
		try {	
			ProductService.update(productDTO);
			//키값가져오기&&상세보기하려면 modelNum필요. flag는 조회수를 안늘리기위해 ReadController로 보내는변수
			url = "product?command=productread&proCode="+productDTO.getProCode();
			//url = "elec?command=read&modelNum="+modelNum+"&flag=1";
			mv.setRedirect(true);
			
		} catch (SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		mv.setPath(url);
		return mv;
		
	}

}
