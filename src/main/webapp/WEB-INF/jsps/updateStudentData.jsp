<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Update Student Data </title>
</head>
<body>
<h1>Update</h1>

<form action = "updateMethod" method = "post">
		<pre>
			<input type ="hidden" name= "id" value ="${studentStoredData.id}"/>
			FirstName <input type ="text" name= "firstName" value ="${studentStoredData.firstName}"/>
			LastName <input type ="text" name= "lastName" value ="${studentStoredData.lastName}"/>
			Email <input type ="text" name= "email" value ="${studentStoredData.email}"/>
			Mobile <input type ="text" name= "mobile" value ="${studentStoredData.mobile}"/>
			<input type ="submit" value="UPDATE"/>
		</pre>
		</form>
		${msg}
		
</body>
</html>