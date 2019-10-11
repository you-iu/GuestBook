package com.khrd.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dto.Message;
import com.khrd.service.MessageDeleteService;

public class MessageDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("get")) {
			return "messageDeleteForm.jsp";
		}else if(request.getMethod().equalsIgnoreCase("post")) {
			request.setCharacterEncoding("utf-8");
			String smessageId = request.getParameter("messageId");
	    	int messageId = Integer.parseInt(smessageId);
	    	String password = request.getParameter("password");

	  		MessageDeleteService service = new MessageDeleteService();
	 		int result = service.delete(messageId,password);
	 		request.setAttribute("result", result);
	    	
			return "messageDelete.jsp";
		}
		return null;
	}

}
