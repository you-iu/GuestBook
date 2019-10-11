<%@page import="com.khrd.service.MessageDeleteService"%>
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
		<h3>삭제완료.</h3>
	</c:if>
	<c:if test="${ result<=0}">
		<h3>비밀번호가 틀렸습니다.</h3>
	</c:if>
	<a href="insert.do">등록하기</a>
	<a href="list.do">목록보기</a>
</body>
</html>