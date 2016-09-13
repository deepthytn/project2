<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>

erdsf
		<c:if test="${!empty replylist}">
		<c:forEach items="${replylist}" var="p">
			<table>
				<tr>
					
					
					
					<th align="left" width="80">Reply</th>
					
					
				</tr>
				<tr>
					<th align="left" width="120">User Name</th>
					<td align="left" >${p.username}</td>
					
					
				</tr>
				<tr>
				<th align="left" width="80">Reply</th>
					<td align="left" >${p.myreply}</td>
				</tr>
			</table>
			</c:forEach>
		</c:if>
	</div>

</body>
</html>