package kosta.product.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.product.model.dao.ProductDAO;
import kosta.product.model.dao.ProductDAOImpl;
import kosta.product.model.dto.ProductDTO;

public class ProductService {

	private static ProductDAO proDao = new ProductDAOImpl();
	
	//전체검색
	public static List<ProductDTO> selectAll() throws SQLException {
		List<ProductDTO> list = proDao.selectAll();
		
		return list;
	}

	//글보기
	public static ProductDTO selectByCodenum(int proCode) throws SQLException {
		ProductDTO productDto = proDao.selectByCodenum(proCode);
		if(productDto==null) throw new SQLException(proCode+"에 해당하는 정보가 없습니다");
		return productDto;
	}
	
	/**
     * ProductDAOImpl의 레코드 삽입하는 메소드 호출
     * */
	public static int insert(ProductDTO productDTO) throws SQLException{
		
		int result =proDao.insert(productDTO);
		if(result==0) throw new SQLException("등록되지않았습니다.");
		return result;
	}

}
