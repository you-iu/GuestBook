<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="delete.do" method="post">
 메시지를 삭제하시려면 암호를 입력하세요:<br>
 <input type="hidden" name="messageId" value="${param.messageId }" >
 암호:<input type="text" name="password"><br>
 <input type="submit" value="메시지 삭제하기">
 </form>
</body>
</html>