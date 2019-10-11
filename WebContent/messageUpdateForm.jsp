<%@page import="com.khrd.dto.Message"%>
<%@page import="com.khrd.service.MessageUpdateService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	fieldset{
		width : 350px;
	}
</style>
</head>
<body>
	<form action="update.do" method="post">
		<fieldset>
			<input type="hidden" name = "messageId" value="${message.messageId }"><br> 
			이름<input type="text" name = "guestName" value ="${message.guestName }" disabled="disabled"><br> 
			비밀번호<input type="text" name = "password" ><br>
			메시지<textarea rows="10" cols="40" name="message">${message.message }</textarea><br>
			<input type="submit" value="수정">
		</fieldset>
	</form>
</body>
</html>