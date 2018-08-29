<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
     <meta charset="UTF-8">
     <title>Registration Form</title>
     	<meta name="viewport" content="width=device-width, initial-scale=1">
     	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
     	<link href="/style.css" rel="stylesheet">
</head>

<body>
 <div class="container">
  <button class="btn btn-warning"><a href="/">Back to Home Page</a></button>
 <!---heading---->
     <header class="heading"> Registration-Form</header><hr></hr>
	<!---Form starting----> 
	<form action= "/register" method="post">
	
	<div class="row ">
	
     <!-----For email---->
		 <div class="col-sm-12">
		     <div class="row">
			     <div class="col-xs-4">
		             <label class="mail" >Email :</label></div>
			     <div class="col-xs-8"	>	 
			          <input type="email" name="email"  id="email" placeholder="Enter your email" class="form-control" required value="${email }" >
		         </div>
		     </div>
		 </div>
	 <!-----For Password and confirm password---->
	 <c:if test="${not empty passwordTest }">
		<div class="test" style="color: white;">
		${passwordTest }
		</div>
		</c:if>
		
          <div class="col-sm-12">
		         <div class="row">
				     <div class="col-xs-4">
		 	              <label class="pass">Password :</label></div>
				  <div class="col-xs-8">
			             <input type="password" name="password1" id="password" placeholder="Enter your Password" class="form-control" required>
				 </div>
         	 </div>
		  </div>
		  
		  <div class="col-sm-12">
		         <div class="row">
				     <div class="col-xs-4">
		 	              <label class="pass">Password :</label></div>
				  <div class="col-xs-8">
			             <input type="password" name="password2" id="password" placeholder="Enter your Password" class="form-control" required>
				 </div>
         	 </div>
		  </div>
		  
    
		  	
		     <div class="col-sm-12">
		         <button class="btn btn-warning">Submit</button>
		   </div>
		 </div>
		 		 
		 </form>
</div>

	 
	 
</body>
</html>