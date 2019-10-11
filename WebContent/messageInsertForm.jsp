<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert.do" method="post">
	<fieldset>
		이름<input type ="text" name="guestName"><br>
		비밀번호<input type ="password" name="password"><br>
		<textarea rows="10" cols="40" name="message"></textarea>
		<br>
		<input type="submit" value ="확인">
	</fieldset>
	</form>
</body>
</html>