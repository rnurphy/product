package com.study.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.study.product.config.DBConfig;
import com.study.product.config.DBConnectionMgr;
import com.study.product.vo.Product;

public class ProductDao {
	
	private static ProductDao instance;
	private DBConnectionMgr pool;
	
	private ProductDao() {
		pool = DBConnectionMgr.getInstance();
	}
	
	public static ProductDao getInstance() {
		if (instance == null) {
			instance = new ProductDao();
		}
		return instance;
	}
	
	public Product findProductByName(String name) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Product product = null;
		
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");		//  DB 커넥터 드라이브 클래스 이름
//			
//			con = DriverManager.getConnection(DBConfig.URL, DBConfig.USERNAME, DBConfig.PASSWORD);
			
			con = pool.getConnection();
			
			String sql = "SELECT * FROM product_tb WHERE product_name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				product = Product.builder()
						.productId(rs.getInt(1))
						.name(rs.getString(2))
						.price(rs.getInt(3))
						.size(rs.getString(4))
						.build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (con != null) {
//					con.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		}
		return product;
	}
	
	public int saveProduct(Product product) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int successCount = 0;
		
		try {
			con = pool.getConnection();
			
			String sql = "INSERT INTO product_tb VALUES(0, ?, ?, ?)";
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getSize());
			
			successCount = pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			
			if (rs.next()) {
				product.setProductId(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return successCount;
	}
	
	public List<Product> getProductListAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Product> products = new ArrayList<>();
		
		try {
			con = pool.getConnection();
			
			String sql = "SELECT * FROM product_tb";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				products.add(Product.builder()
						.productId(rs.getInt(1))
						.name(rs.getString(2))
						.price(rs.getInt(3))
						.size(rs.getString(4))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
