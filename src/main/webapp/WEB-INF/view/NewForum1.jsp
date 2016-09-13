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
<sec:authorize access="hasRole('ROLE_USER')">
		<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>


	</sec:authorize>
       
 --------------------------------- Blog--------------------------------------
  <a href="addnewforum">Add New Blog</a>
  
  <div class="container-fluid">
		<div class="row content">
			<h1>forum</h1>

			<div class="col-sm-9">
				<div>

					<a href="addforum">Add New Forum</a>

				</div>
				
				<hr>
				
				<c:forEach items="${forum}" var="p">
				
					<h3>${p.subject}</div></h3>
					<p>${p.description}</p>
					<h3>Comments</h3>
					<p><h3>@user ${p.username}:</h3>${p.forumreply.myreply}</p>
					
				
					<a href="replyforum">Leave a Comment</a>
					<a href="viewreply?forumid=${p.forumid}">view Comments</a>
					
					<a href="like?forumid=${p.forumid}"> <span class="glyphicon glyphicon glyphicon-thumbs-up" aria-hidden="true"></a>
					<jsp:include page="myreplypage.jsp"></jsp:include>
			
			
				</c:forEach>
			
				
			</div>
			
			<br>

		
			<br>
			<br>

		<div id ="replyclick">
	<c:if test="${replyclick==true}">
	
		<jsp:include page="myreplypage.jsp"></jsp:include>
	</c:if>
		
	</div>
	</div>
  

</body>
</html>