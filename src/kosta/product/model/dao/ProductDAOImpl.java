package kosta.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.product.model.dto.ProductDTO;
import kosta.util.DbUtil;

public class ProductDAOImpl implements ProductDAO {

	//��ü�˻�
	@Override
	public List<ProductDTO> selectAll() throws SQLException {
		System.out.println("DAOImpl�� selectAll()ȣ��");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<>();
		String sql = "select * from product order by p_date desc";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				ProductDTO dto = new ProductDTO(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7));
				list.add(dto);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}
	
	//Ű���忡 �ش��ϴ� �κа˻�
	@Override
	public List<ProductDTO> selectBySearch(String keyField, String keyWord) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<>();
		String sql = "select * from product ";
		try {
			if(keyField.equals("searchName")) {
				sql+="where p_name like ? order by p_date desc";
			}else if(keyField.equals("searchBrand")) {
				sql+="where p_brand like ? order by p_date desc";
			} else {
				sql+="order by p_date desc";
			}
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+keyWord.trim()+"%");
			rs= ps.executeQuery();
			while(rs.next()) {
				ProductDTO dto = new ProductDTO(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7));
				list.add(dto);
			}
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	//��ǰ��ȣ�� �ش��ϴ� �� �󼼺���
	@Override
	public ProductDTO selectByCodenum(int proCode) throws SQLException {
		System.out.println("DAOImpl�� selectByCodenum()ȣ��");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductDTO dto = null;
		String sql ="select * from product where p_code=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, proCode);
			rs=ps.executeQuery();
			if(rs.next()) {
				dto = new ProductDTO(rs.getInt(1),
						rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getInt(6), rs.getString(7));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return dto;
	}

	//�� ���
	@Override
	public int insert(ProductDTO productDTO) throws SQLException {
		System.out.println("DAOImpl�� insert()ȣ��");
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into product values (product_seq.nextval,?,?,sysdate,?,?,?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, productDTO.getProName());
			ps.setString(2, productDTO.getProDesc());
			ps.setString(3, productDTO.getProBrand());
			ps.setInt(4, productDTO.getProPrice());
			ps.setString(5, productDTO.getFileName());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	//��ǰ�ڵ忡 �ش��ϴ� �� ����
	@Override
	public int update(ProductDTO productDTO) throws SQLException {
		System.out.println("DAOImpl�� update()ȣ��");
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update product set p_name=?, p_desc=?, p_brand=?, p_price=?, filename=? where p_code=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, productDTO.getProName());
			ps.setString(2, productDTO.getProDesc());
			ps.setString(3, productDTO.getProBrand());
			ps.setInt(4, productDTO.getProPrice());
			ps.setString(5, productDTO.getFileName());
			ps.setInt(6, productDTO.getProCode());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	//����
	@Override
	public int delete(int proCode) throws SQLException {
		System.out.println("DAOImpl�� delete()ȣ��");
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from product where p_code=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, proCode);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
}
