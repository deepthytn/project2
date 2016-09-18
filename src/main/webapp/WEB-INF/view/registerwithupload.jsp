<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="header.jsp"%>
<title>Sign Up</title>


    <div class="form-container">
     
    <h1>Registration Form</h1>
     
    <form:form method="POST" modelAttribute="user" class="form-horizontal" action="registerwithupload1?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
 <form:label path="id">id</form:label><form:input path="id" />
          <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="username">User Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="username" id="username" />
                   
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="password">Password</label>
                <div class="col-md-7">
                    <form:input type="password" path="password" id="password" />
                   
                </div>
            </div>
        </div>
        
        
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">First Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="name" id="name" />
                    
                </div>
            </div>
        </div>
                     
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="emailaddress">Email Id:</label>
                <div class="col-md-7">
                    <form:input type="text" path="email" id="email" />
                    
                </div>
            </div>
        </div>
 
                  
            <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="image">Image /Picture upload </label>
                <div class="col-md-7">
                    <form:input type="file" path="image" id="image" />
                   
                </div>
            
            
            </div>
           
        </div>
	          <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="Register" class="btn btn-primary btn-sm">
            </div>
        </div>
        
    </form:form>
    </div>
   