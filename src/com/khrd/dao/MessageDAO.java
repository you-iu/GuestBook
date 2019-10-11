package com.khrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.khrd.dto.Message;
import com.khrd.dto.Student;
import com.khrd.jdbc.JDBCUtil;

public class MessageDAO {
	private static final MessageDAO dao = new MessageDAO();
	
	public static MessageDAO getInstance() {
		return dao;
	}
	
	private MessageDAO() {}
	
	public int insert(Connection conn, Message message) {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into guestbook_message values (null,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
		}
		return -1;
	}
	
	public List<Message> selectList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Message> list = null;
		try {
			String sql = "select * from guestbook_message";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				Message ms = new Message(rs.getInt("message_id"),
										rs.getString("guest_name"),
										rs.getString("password"),
										rs.getString("message")); 
										
				list.add(ms);
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
			String sql = "delete from guestbook_message where message_id=?";
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
	
	public Message selectById(Connection conn,int messageId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			String sql = "select * from guestbook_message where message_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, messageId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Message message = new Message(rs.getInt("message_id"),
					rs.getString("guest_name"),
					rs.getString("password"),
					rs.getString("message")); 
					return message; 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(rs);
		}
		
		return null;
		
	}
	
	public int update(Connection conn, Message message) {
		PreparedStatement pstmt = null;
		System.out.println(message);
		try {
			String sql = "update guestbook_message set  message=? where message_id =?";
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, message.getMessage());
			pstmt.setInt(2, message.getMessageId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
		}
		return -1;
	}
	
}
