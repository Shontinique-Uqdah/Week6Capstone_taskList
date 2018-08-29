<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Home</title>
</head>
<body>

<h1 class="center">Task List
</h1>
	
	
		
		<table class="table table-hover">
			<thead>
			<tr>
			<td>
		</td>
		</tr>
				<tr>
					<th>Description</th><th>Deadline</th><th>Complete</th><th colspan="2"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="task" items="${tasks}">
				<tr>
					<td>${task.description}</td>
					<td>${task.dueDate}</td>
					<td><input type="checkbox" name="complete" ${task.complete ? "checked = 'checked'" : "" } disabled></td>
					<td><button class= "btn btn-danger"><a href="/complete/${task.id }">Mark as Complete</a></button></td>
					<td><button class= "btn btn-danger"><a href="/delete/${task.id }">Delete</a></button></td>
					
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<button class= "btn btn-secondary"><a href="/add">Add a Task</a></button>
		<button class= "btn btn-danger"><a href="/logout">Logout</a></button>
		
	</div>
	
	<!-- Try disabled and read only for the checkboxes -->


</body>
</html>