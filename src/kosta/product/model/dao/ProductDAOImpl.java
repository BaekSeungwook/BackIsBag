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

	@Override
	public List<ProductDTO> selectAll() throws SQLException {
		System.out.println("DAOImpl의 selectAll()호출");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<>();
		String sql = "select * from product order by p_date";
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

	//view
	@Override
	public ProductDTO selectByCodenum(int proCode) throws SQLException {
		System.out.println("DAOImpl의 selectByCodenum()호출");
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
			System.out.println(dto.getProName());
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return dto;
	}

	@Override
	public ProductDTO selectByBrand(String proBrand) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO selectByName(String proName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ProductDTO productDTO) throws SQLException {
		System.out.println("DAOImpl의 insert()호출");
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

	@Override
	public int update(ProductDTO productDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int proCode) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
