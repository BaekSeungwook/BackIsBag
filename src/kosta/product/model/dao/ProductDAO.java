package kosta.product.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.product.model.dto.ProductDTO;

public interface ProductDAO {
	
	/**
	 * 상품리스트
	 * select * from product order by p_date
	 */
	public List<ProductDTO> selectAll() throws SQLException;

	/**
	 * 코드번호에 해당하는 상품상세보기
	 * select * from product where p_code=?
	 */
	public ProductDTO selectByCodenum(int proCode) throws SQLException;
	
	/**
	 * 제품 브랜드 별 검색
	 * select * from product where p_brand=?
	 */
	public ProductDTO selectByBrand(String proBrand) throws SQLException;
	
	/**
	 * 제품 이름 검색
	 * select * from product where p_name=?
	 */
	public ProductDTO selectByName(String proName) throws SQLException;
		  
	  
	/**
	 * 레코드 삽입
	 * @return : 1-삽입성공 , 0 - 삽입실패
	 * insert into product values (?,?,?,sysdate,?,?,?)
	 * */
	int insert(ProductDTO productDTO) throws SQLException;
	
	/**
	 * 상품코드에 해당하는 레코드 수정(모델이름, 가격, 내용만)
	 * @return : 1-수정성공 , 0 - 수정실패
	 * update product set p_name=?, p_desc=?, p_brand=?, p_price=? where p_code=?
	 * */
	int update(ProductDTO productDTO) throws SQLException;
	  
	/**
	 * 상품코드에 해당하는 레코드 삭제
	 * @return : 1-삭제성공 , 0 - 삭제실패
	 * delete from product where p_code=?
	 * */
	int delete(int proCode) throws SQLException;
	  
	
}
