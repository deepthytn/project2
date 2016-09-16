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
       
 --------------------------------- Forum--------------------------------------
  <a href="addnewforum">Add New forum</a>
  
  <div class="container-fluid">
		<div class="row content">
			<h1>forum</h1>

			<div class="col-sm-9">
				<div>

					<a href="addforum">Add New Forum</a>

				</div>
				
				
				
				<c:forEach items="${forum}" var="p">
				
				<p ><span style="font-weight:bold">@user ${p.username} posted:</p><br/>
					<p><span style="font-weight:bold">subject :</span><h2>${p.subject}</h2></p><br/>
					<p><span style="font-weight:bold">description</span>${p.description}</p><br/>
					
					
					<div>
				
					<a href="replyforum?forumid=${p.forumid}">Leave a Comment</a>
					<a href="viewreply?forumid=${p.forumid}">view Comments</a>
					
					<a href="like?forumid=${p.forumid}"> <span class="glyphicon glyphicon glyphicon-thumbs-up" aria-hidden="true"></a>
					<div>
			
			<div id ="replyclick">
	<c:if test="${replyclick==true}">
	<c:if test="${p.forumid==forumid}">
	
		<%@include file="/WEB-INF/view/myreplypage.jsp" %>
		</c:if>
	</c:if>
	<br/><br/>
	
	<div id ="viewreply">$
	<c:if test="${viewreplyclick==true}">
	<c:if test="${p.forumid==forumid}">
	<%@include file="/WEB-INF/view/viewallforumrepl.jsp" %>
	</c:if>	
		
	</c:if>
	<br/><br/>
	<hr/>
				</c:forEach>
			<div class="col-sm-3">
				
			</div>
			
			<br>

		
			<br>
			<br>

		
		
	</div>
	</div>
  

</body>
</html>