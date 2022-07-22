<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="checkRegi" method="POST">
		아이디 : <input type="text" name="userId">
		<c:choose>
        	<c:when test="${fn:length(msg) > 0}">
        		<input type="text" value="${msg}" style="border:none;">
        	</c:when>
        	<c:otherwise>
        		
        	</c:otherwise>
        </c:choose>
		<br>
		비밀번호 : <input type="password" name="userPw"><br>
		별명 : <input type="text" name="name"><br>
		<input type="submit" value="회원가입">
		<input type="button" value="메인" onclick="location.href='index'">
	</form>
</body>
</html>