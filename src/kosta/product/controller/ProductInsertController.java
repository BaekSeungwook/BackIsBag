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
		System.out.println("InsertController�� handleRequestȣ��");
		ModelAndView mv = new ModelAndView();
		
		//�Ѿ���� �� �ޱ�
		ServletContext application  = request.getServletContext();
		String saveDir = application.getRealPath("/views/product/save");
		int maxSize=1024*1024*100;//100M
		String encoding = "UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize,
				encoding, new DefaultFileRenamePolicy());
		//�Ѿ���� �� �ޱ�
		String productName = m.getParameter("productName");
		String description = m.getParameter("description");
		String brandName = m.getParameter("brandName");
		String price = m.getParameter("price");
		String fileName = m.getFilesystemName("file");
		
		
		//description�κп� tag( < )�� ����(&it;)�� ����(�ؽ�Ʈ�� �±װ����� �ȸ�����)
		description = description.replace("<", "&lt;");
		
		//������ �⺻������ ������ �Ѿ���µ����͵��� �� 5��
		ProductDTO productDTO = new ProductDTO(productName,description,brandName, Integer.parseInt(price), fileName);
		//���� ����÷�ΰ� �Ǿ��ٸ�... �����̸�, ����ũ�⸦ ����
		if(m.getFilesystemName("file")!=null) {
			//�����̸�
			productDTO.setFileName(m.getFilesystemName("file"));
		}
		//
		
		try {
			ProductService.insert(productDTO);
			mv.setPath("product");//����Ʈ(list)�� ���Ƿ� �������� ���⶧���� redirect��������̵�
			mv.setRedirect(true);//�̵���� redirect�μ���(true)
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("views/errorView/error.jsp");//errorMsg�������Ƿ� forward���
		}
		
		return mv;
	}

}
