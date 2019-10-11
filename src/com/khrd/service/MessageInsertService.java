package com.khrd.service;

import java.sql.Connection;

import com.khrd.dao.MessageDAO;
import com.khrd.dto.Message;
import com.khrd.jdbc.ConnectionProvider;
import com.khrd.jdbc.JDBCUtil;

public class MessageInsertService {
	
	public int insert(Message message) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			MessageDAO dao = MessageDAO.getInstance();
			return dao.insert(conn, message);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		
		return -1;
	}
}
