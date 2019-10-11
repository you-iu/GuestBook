package com.khrd.service;

import java.sql.Connection;
import java.util.List;

import com.khrd.dao.MessageDAO;

import com.khrd.dto.Message;

import com.khrd.jdbc.ConnectionProvider;
import com.khrd.jdbc.JDBCUtil;

public class MessageListService {
public List<Message> list(){
		
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			MessageDAO dao = MessageDAO.getInstance();
			List<Message> list = dao.selectList(conn);
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn);
		}
		
		return null;
	}
}
