package com.khrd.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dto.Message;
import com.khrd.service.MessageInsertService;

public class MessageInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("get")) {
			return	"messageInsertForm.jsp";
		}else if(request.getMethod().equalsIgnoreCase("post")) {
			
			request.setCharacterEncoding("utf-8");
			String guestName = request.getParameter("guestName");
			String password = request.getParameter("password");
			String message = request.getParameter("message");
			Message msg = new Message(0, guestName, password, message);
			System.out.println(msg);
			//db저장
			MessageInsertService service = new MessageInsertService();
	    	int result = service.insert(msg);
	    	request.setAttribute("result", result);
			return "messageInsertResult.jsp";
		}
		return null;
	}

}
