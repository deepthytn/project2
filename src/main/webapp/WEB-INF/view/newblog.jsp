<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <form:form id="newblog" modelAttribute="newb" method="post" action="addNewBlog">
   <table width="400px" height="150px">
    <tr>
     <td><form:label path="blogid">blog id</form:label>
     </td>
     <td><form:input path="blogid" />
     </td>
    </tr>
    <tr>
     <td><form:label path="subject">subject</form:label>
     </td>
     <td><form:input path="subject" />
     </td>
    </tr>
    <tr>
     <td><form:label path="description">description</form:label>
     </td>
     <td><form:input path="description" />
     </td>
    </tr>
     <tr>
     <td><form:label path="username">username</form:label>
     </td>
     <td><form:input path="username" />
     </td>
    </tr>
    
      <tr>
     <td><form:label path="likes">likes</form:label>
     </td>
     <td><form:input path="likes" />
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