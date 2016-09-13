<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<caption>MY PROFILE</caption>
<tr>
<th>userid :</th>
<td>${usermodel.id}</td>
</tr>
<tr>
<th>username :</th>
<td>${usermodel.username}</td>
</tr>
<tr>
<th>address:</th>
<td>${usermodel.address}</td>
</tr>
<tr>
<th>email :</th>
<td>${usermodel.email}</td>
</tr>

</body>
</html>