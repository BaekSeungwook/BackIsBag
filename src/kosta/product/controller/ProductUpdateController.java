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
		System.out.println("ProductUpdateControllerȣ��");
		ModelAndView mv = new ModelAndView();
		
		String url ="errirView/error.jsp";
		
		//�Ѿ���� �� �ޱ�
		ServletContext application  = request.getServletContext();
		String saveDir = application.getRealPath("/views/product/save");
		int maxSize=1024*1024*100;//100M
		String encoding = "UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize,
				encoding, new DefaultFileRenamePolicy());
		//�Ѿ���� �� �ޱ�
		String proCode = m.getParameter("proCode");
		String productName = m.getParameter("productName");
		String description = m.getParameter("description");
		String brandName = m.getParameter("brandName");
		String price = m.getParameter("price");
		String fileName = m.getFilesystemName("file");
		
		
		//description�κп� tag( < )�� ����(&it;)�� ����(�ؽ�Ʈ�� �±װ����� �ȸ�����)
		description = description.replace("<", "&lt;");
		
		ProductDTO productDTO =
				new ProductDTO(Integer.parseInt(proCode), productName, description, brandName, Integer.parseInt(price), fileName);
		
		if(m.getFilesystemName("file")!=null) {
			//�����̸�
			productDTO.setFileName(m.getFilesystemName("file"));
		}
		try {	
			ProductService.update(productDTO);
			//Ű����������&&�󼼺����Ϸ��� modelNum�ʿ�. flag�� ��ȸ���� �ȴø������� ReadController�� �����º���
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
