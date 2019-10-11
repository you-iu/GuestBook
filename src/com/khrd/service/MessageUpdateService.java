package com.khrd.service;

import java.sql.Connection;
import com.khrd.dao.MessageDAO;
import com.khrd.dto.Message;
import com.khrd.jdbc.ConnectionProvider;
import com.khrd.jdbc.JDBCUtil;

public class MessageUpdateService {
	public Message getMessage(int messageId) {
		Connection conn = null;
    	
    	try{
    		conn = ConnectionProvider.getConnection();
    		MessageDAO dao = MessageDAO.getInstance();
    		return dao.selectById(conn, messageId);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		JDBCUtil.close(conn);
    	}
		return null;
	}
	
		// -1 : 커리 실패
		// -2 : 비밀번호 불일치
		// 1 : 성공
	public int update(Message message) {

    	Connection conn = null; 
    	try{
    		conn = ConnectionProvider.getConnection();
    		MessageDAO dao = MessageDAO.getInstance(); 
    		Message dbMessage = dao.selectById(conn, message.getMessageId());
    		//비밀번호 일치여부 확인
    		if(dbMessage.getPassword().equals(message.getPassword())) {
    			return dao.update(conn, message);
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
