<%@page import="com.khrd.dto.Message"%>
<%@page import="java.util.List"%>
<%@page import="com.khrd.service.MessageListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>
	table,th,td{
		border-collapse: collapse;
		border: 1px solid black;
	}
</style>

</head>
<body>

	<table>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>비밀번호</th>
				<th colspan="2">메시지</th>
				<!-- <th></th> -->
			</tr>
		<c:forEach var="m" items="${list }">
			<tr>
				<td class="messageId">${m.messageId }</td>
				<td>${m.guestName }</td>
				<td>${m.password }</td>
				<td>${m.message }</td>
				<td><button class ="btnModify">수정</button> <button class ="btnDel" >삭제</button></td>
				<!-- <td><input type="button" name="s" value="수정"><input type="button" name="x"value="삭제" ></td> -->
			</tr>
		</c:forEach>
		</table>
		<a href="insert.do">등록하기</a>
		<script>
			$(".btnDel").click(function(){
				var messageId = $(this).closest("tr").find(".messageId").text();
				location.href="delete.do?messageId="+messageId;
			})
			$(".btnModify").click(function(){
				var messageId = $(this).closest("tr").find(".messageId").text();
				location.href = "update.do?messageId="+messageId;
			})
		</script>
	
</body>
</html>