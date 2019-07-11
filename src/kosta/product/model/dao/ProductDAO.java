package kosta.product.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.product.model.dto.ProductDTO;

public interface ProductDAO {
	
	/**
	 * ��ǰ����Ʈ
	 * select * from product order by p_date
	 */
	public List<ProductDTO> selectAll() throws SQLException;

	/**
	 * �ڵ��ȣ�� �ش��ϴ� ��ǰ�󼼺���
	 * select * from product where p_code=?
	 */
	public ProductDTO selectByCodenum(int proCode) throws SQLException;
	
	/**
	 * ��ǰ �귣��, ��ǰ�̸� �� �˻�
	 * select * from product where p_brand=?
	 */
	public List<ProductDTO> selectBySearch(String keyWord, String keyField) throws SQLException;
		  
	/**
	 * ���ڵ� ����
	 * @return : 1-���Լ��� , 0 - ���Խ���
	 * insert into product values (?,?,?,sysdate,?,?,?)
	 * */
	int insert(ProductDTO productDTO) throws SQLException;
	
	/**
	 * ��ǰ�ڵ忡 �ش��ϴ� ���ڵ� ����(���̸�, ����, �귣��, ����, �����̸�)
	 * @return : 1-�������� , 0 - ��������
	 * update product set p_name=?, p_desc=?, p_brand=?, p_price=?, filaName=? where p_code=?
	 * */
	int update(ProductDTO productDTO) throws SQLException;
	  
	/**
	 * ��ǰ�ڵ忡 �ش��ϴ� ���ڵ� ����
	 * @return : 1-�������� , 0 - ��������
	 * delete from product where p_code=?
	 * */
	int delete(int proCode) throws SQLException;
}
