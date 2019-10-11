package com.khrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.khrd.dto.Student;
import com.khrd.jdbc.JDBCUtil;

public class StudentDAO {
	private static final StudentDAO dao = new StudentDAO();
	
	private StudentDAO() {}
	
	public static StudentDAO getInstance() {
		return dao;
	}
	
	public int insert(Connection conn, Student std) {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into student values (null,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, std.getName());
			pstmt.setInt(2, std.getKor());
			pstmt.setInt(3, std.getMath());
			pstmt.setInt(4, std.getEng());
			return pstmt.executeUpdate();//쿼리실행
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
		}
		return -1;
	}
	
	public int update(Connection conn, Student std) {
		PreparedStatement pstmt = null;
		System.out.println(std);
		try {
			String sql = "update student set name =?, kor=? , math=?, eng=? where no =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, std.getName());
			pstmt.setInt(2, std.getKor());
			pstmt.setInt(3, std.getMath());
			pstmt.setInt(4, std.getEng());
			pstmt.setInt(5, std.getNo());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
		}
		return -1;
	}
	
	public int delete(Connection conn, int no) {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from student where no=?;";
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
	
	public List<Student> selectList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Student> list = null;
		try {
			String sql = "select * from student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				Student std = new Student(rs.getInt("no"),
										rs.getString("name"),
										rs.getInt("kor"),
										rs.getInt("math"),
										rs.getInt("eng"));
				list.add(std);
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
	
	public Student selectByNo(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from student where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Student std = new Student(rs.getInt("no"),
						rs.getString("name"),
						rs.getInt("kor"),
						rs.getInt("math"),
						rs.getInt("eng"));
						return std;
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
