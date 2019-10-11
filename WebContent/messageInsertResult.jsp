<%@page import="com.khrd.service.MessageInsertService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ result>0}">
		<h3>등록하였습니다.</h3>
	</c:if>
	<c:if test="${ result<=0}">
		<h3>실패하였습니다.</h3>
	</c:if>
	<!-- <a href="messageInsertForm.jsp">등록하기</a> -->
	<a href="list.do">목록보기</a>
</body>
</html>