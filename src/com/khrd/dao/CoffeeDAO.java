package com.khrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.khrd.dto.Coffee;
import com.khrd.dto.Message;
import com.khrd.dto.Student;
import com.khrd.jdbc.JDBCUtil;

public class CoffeeDAO {
private static final CoffeeDAO dao = new CoffeeDAO();
	
	public static CoffeeDAO getInstance() {
		return dao;
	}
	
	private CoffeeDAO() {}
	
	public int insert(Connection conn, Coffee coffee) {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into coffee values (null,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffee.getName());
			pstmt.setInt(2, coffee.getPrice());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
		}
		return -1;
	}
	
	public List<Coffee> selectList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Coffee> list = null;
		try {
			String sql = "select * from coffee";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				Coffee coffee = new Coffee(rs.getInt("no"),
										rs.getString("name"),
										rs.getInt("price")); 								
				list.add(coffee);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(rs);
		}
		
		return null;
		
	}
	
	public int delete(Connection conn, int no) {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from coffee where no=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
		}
		return -1;
	}
	
	public int update(Connection conn, Coffee coffee) {
		PreparedStatement pstmt = null;
		System.out.println(coffee);
		try {
			String sql = "update coffee set name =?, price=? where no =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffee.getName());
			pstmt.setInt(2, coffee.getPrice());
			pstmt.setInt(3, coffee.getNo());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
		}
		return -1;
	}
	
	public Coffee selectByNo(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from coffee where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Coffee coffee = new Coffee(rs.getInt("no"),
						rs.getString("name"),
						rs.getInt("price"));
						return coffee;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(rs);
		}
		return null;
	}
}
