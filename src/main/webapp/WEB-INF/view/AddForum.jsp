<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="/WEB-INF/view/header.jsp" %>
 <form:form id="newblog" modelAttribute="addnewforum" method="post" action="addNewforum">
   <table width="400px" height="150px">
    
    <tr>
     <td><form:label path="subject">subject</form:label>
     </td>
     <td><form:input class="form-control" path="subject" />
     </td>
    </tr>
    <tr>
     <td><form:label path="description">description</form:label>
     </td>
     <td><form:textarea class="form-control" path="description" />
     </td>
    </tr>
     <tr>
     <td><form:label path="username">username</form:label>
     </td>
     <td><form:input path="username" />
     </td>
    </tr>
    
      
     <tr>
     <td>
     </td>
     <td>
     </td>
    </tr>
    <tr>
     <td></td>
     <td><input type="submit" value="ADD BLOG" /></td>
    </tr>
   </table>
  </form:form>

 

</body>
</html>