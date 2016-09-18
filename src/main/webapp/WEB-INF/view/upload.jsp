<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
<title>Upload File Request Page</title>
</head>
<body>
 <form  action="./uploadFile1" method="post" >
		File to upload: <!--  <input type="file" name="file">-->
 
		Name: <input type="text" name="name">
 
 
		<input type="submit" value="Upload"> Press here to upload the file!
	</form>		
</body>
</html>