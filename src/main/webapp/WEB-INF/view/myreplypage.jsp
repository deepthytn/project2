<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>

sdffffffffffffffffffffffffffff
<form:form commandName="replypage"  method="post" action="saveComments">
				<div class="form-group">
				
				
					<form:input type="textarea" path="myreply" class="form-control" placeholder="Comments"/>
				</div>
				<button type="submit" class="btn btn-success">Submit</button>
				</form:form>

</body>
</html>