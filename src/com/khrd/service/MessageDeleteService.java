package com.khrd.service;

import java.sql.Connection;

import com.khrd.dao.MessageDAO;
import com.khrd.dto.Message;
import com.khrd.jdbc.ConnectionProvider;
import com.khrd.jdbc.JDBCUtil;

public class MessageDeleteService {
	
	// -1 : 커리 실패
	// -2 : 비밀번호 불일치
	// 1 : 성공
	public int delete(int messageId , String password) {
    	Connection conn = null; 
    	try{
    		conn = ConnectionProvider.getConnection();
    		MessageDAO dao = MessageDAO.getInstance();
    		Message dbMessage =	dao.selectById(conn, messageId); 
    		if(dbMessage.getPassword().equals(password)) {
    			return dao.delete(conn, messageId);
    		}else {
    			return -2;
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		JDBCUtil.close(conn);
    	}
		return -1;
	}
}
