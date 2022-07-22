<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List View</title>
</head>
<body>
 
    <div>
        <H1>DB</H1>
        <table border="1">
            <thead>
                <tr>
                    <th>userId</th>
                    <th>userPw</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${fn:length(bList) > 0}">
                        <c:forEach items="${bList}" var="Alllist">
                            <tr>
                                <td>${Alllist.userId}</td>
                                <td>${Alllist.userPw}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="4"></td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>
 	<input type="button" value="����" onclick="location.href='index'">
</body>
</html>