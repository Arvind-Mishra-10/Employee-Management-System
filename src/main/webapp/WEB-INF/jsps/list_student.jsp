<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table>
		<tr>
		<th>FirstName</th>
		<th>lasttName</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Actions</th>
		</tr>
		<c:forEach var="stdos" items="${stds}">
			<tr>
				<td>${stdos.firstName}</td>
				<td>${stdos.lastName}</td>
				<td>${stdos.email}</td>
				<td>${stdos.mobile}</td>
				<td><a href= "delete?id=${stdos.id}">Delete</a></td>
				<td><a href= "update?id=${stdos.id}">UPDATE</a></td>
			</tr>
			</c:forEach>		
			
	</table>
</body>
</html>