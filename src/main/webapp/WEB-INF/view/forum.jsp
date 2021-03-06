<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Product Info</title>

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootswatch/3.2.0/sandstone/bootstrap.min.css">
<script	src="//ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>

<script>
 var app = angular.module('myApp', []);
//app.controller("MyController",MyController);
function MyController($scope, $http) {

	  $scope.sortType     = 'name'; // set the default sort type
	  $scope.sortReverse  = false;  // set the default sort order
	  $scope.searchsubject   = '';     // set the default search/filter term

        $scope.getDataFromServer = function() {
                $http({
                        method : 'GET',
                        url : 'forum'
                }).success(function(data, status, headers, config) {
                        $scope.forums = data; 
                }).error(function(data, status, headers, config) {
                        
                });

        };
        
}; 


</script>

<style>
body { padding-top:50px; }
</style>

<body>


<div class="container" ng-app="myApp" ng-controller="MyController" >
  
  
  
  <form>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
        <input type="text" class="form-control" ng-model="searchsubject" placeholder="Search Product Name" >
       <!--  <button  ng-click="getDataFromServer()">List of products</button> &nbsp; --> 
       </div>      
    </div>
  </form>
  
  <div ng-init="getDataFromServer()" >
  
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
  <a href="newblogreg">Add New Blog</a>
  <div >
  <ul>
  	<li style="background:yellow;border-top:2px solid blue;padding:2em" ng-repeat="roll in forums | orderBy:sortType:sortReverse | filter:searchsubject">
  	<br/><br/>
  	Blog id:{{ roll.forumid}}<br/><br/>
  	subject:{{ roll.forumquestion}}<br/><br/>
  	{{ roll.description }}<br/><br/>
  	<a  href="reply?id={{roll.id}}">like</a> {{ roll.likes }}<br/><br/>
  	
  	</li>
  </ul>
  
 
 </div>
 </div>
 
  
</div>

</body>


</body>
</html>