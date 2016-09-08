<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><link href="<c:url value="/resources/css/reg.css" />"
	rel="stylesheet">
	
	<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
	
	<link href="<c:url value="/resources/css/style.css" />"
	rel="stylesheet">
	
	<link href="<c:url value="/resources/css/font-awesome.css" />"
	rel="stylesheet">

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<body > 

<div class="login">
		<div class="main-agileits">
				<div class="form-w3agile form1">
						
						
						
						<form:form  method="post" modelAttribute="user">
						<table align="center">
			<tr>
			
				<td>
						
							${user.id}
					</td></tr>		
								<br />
								<tr>
			
				<td>
							${user.name}
						</td></tr>	
							<br/><tr>
			
				<td>
							${user.password}	
							</td></tr>
							<br /><tr>
			
				
			
				
			
				<td>
							${user.address}
							</td></tr>
							<br />
							<tr>
			
				<td>
							<button name="_eventId_edit" type="submit" class="btn btn-default">Edit</button><br/>
							<button name="_eventId_submit" type="submit" class="btn btn-default">Confirm Details</button>
							</td></tr></table>
						</form:form>
					</div>
					</div>
				
			</div>
		</div>
	
</body>
</html>