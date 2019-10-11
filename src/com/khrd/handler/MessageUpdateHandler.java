package com.khrd.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dto.Message;
import com.khrd.service.MessageUpdateService;

public class MessageUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("get")) {
			String sMessageId = request.getParameter("messageId");
	    	int messageId = Integer.parseInt(sMessageId); 
	    	MessageUpdateService service = new MessageUpdateService();  
	    	Message message = service.getMessage(messageId);  
	    	request.setAttribute("message", message); 
			return "messageUpdateForm.jsp";
			
		}else if(request.getMethod().equalsIgnoreCase("post")) {
			request.setCharacterEncoding("utf-8");	
			String sMessageId = request.getParameter("messageId");
	    	int messageId = Integer.parseInt(sMessageId); 
			String guestName = request.getParameter("gusetName");
			String password = request.getParameter("password");
			String message = request.getParameter("message");
			Message msg = new Message(messageId, guestName, password, message);
			MessageUpdateService service = new MessageUpdateService();
	     	int result = service.update(msg);
	     	request.setAttribute("result", result);
			return "messageUpdateResult.jsp";
		}
		return null;
	}

}
