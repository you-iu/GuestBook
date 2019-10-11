<%@page import="com.khrd.dto.Message"%>
<%@page import="com.khrd.service.MessageUpdateService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${ result>=0}">
		<h3>수정에 완료하였습니다.</h3>
	</c:if>
<c:if test="${ result== -1}">
		<h3>수정에 실패하였습니다.</h3> 
	</c:if>
<c:if test="${ result==-2}">
		<h3>비밀번호가 일치하지않습니다.</h3>
	</c:if>
	<a href="insert.do">등록하기</a>
	<a href="list.do">목록보기</a>
</body>
</html>