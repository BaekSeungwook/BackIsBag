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
     * ProductDAOImpl�� ��ü �˻�  �޼ҵ� ȣ��
     * */
	public static List<ProductDTO> selectAll() throws SQLException {
		List<ProductDTO> list = proDao.selectAll();
		
		return list;
	}

	/**
     * ProductDAOImpl�� Ű���忡�� �ش��ϴ� ���ڵ� �˻�  �޼ҵ� ȣ��
     * */
	public static List<ProductDTO> selectBySearch(String keyField, String keyWord) throws SQLException {
		List<ProductDTO> list = proDao.selectBySearch(keyField, keyWord);
		return list;
	}
	
	/**
     * ProductDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻�  �޼ҵ� ȣ��
     * */
	public static ProductDTO selectByCodenum(int proCode) throws SQLException {
		ProductDTO productDto = proDao.selectByCodenum(proCode);
		if(productDto==null) throw new SQLException(proCode+"�� �ش��ϴ� ������ �����ϴ�");
		return productDto;
	}
	
	/**
     * ProductDAOImpl�� ���ڵ� �����ϴ� �޼ҵ� ȣ��
     * */
	public static int insert(ProductDTO productDTO) throws SQLException{
		
		int result =proDao.insert(productDTO);
		if(result==0) throw new SQLException("��ϵ����ʾҽ��ϴ�.");
		return result;
	}

	/**
     * ProductDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����  �޼ҵ� ȣ��
     * */
	public static int update(ProductDTO productDTO) throws SQLException{
		
		int result = proDao.update(productDTO);
		if(result==0) throw new SQLException("�������� �ʾҽ��ϴ�.");
		return result;
	}

	/**
     * ProductDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����  �޼ҵ� ȣ��
     * */
	public static int delete(int proCode) throws SQLException {
		int result = proDao.delete(proCode);
		if(result==0) throw new SQLException("���������ʾҽ��ϴ�.");
		return result;
		
	}

}
