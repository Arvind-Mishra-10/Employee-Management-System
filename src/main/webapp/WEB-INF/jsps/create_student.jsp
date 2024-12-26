<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Student registration</title>
</head>
<body>
<h1>Hello</h1>

<form action = "saveStudent" method = "post">
		<pre>
			FirstName <input type ="text" name= "firstName"/>
			LastName <input type ="text" name= "lastName"/>
			Email <input type ="text" name= "email"/>
			Mobile <input type ="text" name= "mobile"/>
			<input type ="submit" value="Save"/>
		</pre>
		</form>
		${msg}
		<a href= "list_student">View list</a>
</body>
</html>