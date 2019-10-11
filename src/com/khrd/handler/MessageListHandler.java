package com.khrd.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.khrd.controller.CommandHandler;
import com.khrd.dto.Message;
import com.khrd.service.MessageListService;

public class MessageListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MessageListService service = new MessageListService();
		List<Message> list = service.list();
		request.setAttribute("list", list);
		return "messageList.jsp";
	}

}
