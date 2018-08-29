<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="/style-two.css" />
<title>Add Task</title>
</head>

 <button class="btn btn-warning"><a href="/showTasks">Back to Task List</a></button>
<body>
 <div class="container">
 <!---heading---->
     <header class="heading"> Add Task</header><hr></hr>
	<!---Form starting----> 
	<form action="/add" method="post">
	<div class="row ">
	
         <div class="col-sm-12">
		     <div class="row">
			     <div class="col-xs-4">
                     <label class="lastname">Description :</label></div>
				<div class ="col-xs-8">	 
		             <input type="text" name= "description" id="lname" placeholder="Description" class="form-control last" >
                </div>
		     </div>
		 </div>
     <!-----For Due Date---->
		 <div class="col-sm-12">
		     <div class="row">
			     <div class="col-xs-4">
		             <label class="mail" >Due Date :</label></div>
			     <div class="col-xs-8"	>	 
			          <input type="date" name="dueDate"  id="email" placeholder="Enter due date" class="form-control">
		         </div>
		     </div>
		 </div>
		 
		 <!--- For Status---->
         <div class="col-sm-12">
             <div class="row">
			     <div class="col-xs-4">
          	         <label class="firstname">Completion Status :</label> </div>
		         <div class="col-xs-4">
		             <label><input type="radio" name= "complete" id="gender" placeholder="Status" class="form-check " value="true" required>Complete</label>
             	</div>
             	<div class="col-xs-4">
              		<label><input type="radio" name= "complete" id="gender" placeholder="Status" class="form-check " value="false" required>Not Complete</label>
		      	</div>
		      </div>
		 </div>
	 
		     <div class="col-sm-12">
		         <button type="submit" class="btn btn-warning">Add task</button>
		   </div>
		 </div>
		 
		  
		 		 
		</form> 
</div>
</body>		
</html>
	 
	 