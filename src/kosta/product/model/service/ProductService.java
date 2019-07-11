package kosta.product.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.product.model.dao.ProductDAO;
import kosta.product.model.dao.ProductDAOImpl;
import kosta.product.model.dto.ProductDTO;

public class ProductService {

	private static ProductDAO proDao = new ProductDAOImpl();
	
	/**
     * ProductDAOImpl의 전체 검색  메소드 호출
     * */
	public static List<ProductDTO> selectAll() throws SQLException {
		List<ProductDTO> list = proDao.selectAll();
		
		return list;
	}

	/**
     * ProductDAOImpl의 키워드에에 해당하는 레코드 검색  메소드 호출
     * */
	public static List<ProductDTO> selectBySearch(String keyField, String keyWord) throws SQLException {
		List<ProductDTO> list = proDao.selectBySearch(keyField, keyWord);
		return list;
	}
	
	/**
     * ProductDAOImpl의 모델번호에 해당하는 레코드 검색  메소드 호출
     * */
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

	/**
     * ProductDAOImpl의 모델번호에 해당하는 레코드 수정  메소드 호출
     * */
	public static int update(ProductDTO productDTO) throws SQLException{
		
		int result = proDao.update(productDTO);
		if(result==0) throw new SQLException("수정되지 않았습니다.");
		return result;
	}

	/**
     * ProductDAOImpl의 모델번호에 해당하는 레코드 삭제  메소드 호출
     * */
	public static int delete(int proCode) throws SQLException {
		int result = proDao.delete(proCode);
		if(result==0) throw new SQLException("삭제되지않았습니다.");
		return result;
		
	}

}
