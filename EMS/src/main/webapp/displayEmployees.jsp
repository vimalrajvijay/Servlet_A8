<%@page import="com.example.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Table</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Department</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<% List<Employee> employees = (List<Employee>)request.getAttribute("employees");
		for(Employee e : employees){
		%>	
		<tr>
			<td><%=e.getId()%></td>
			<td><%=e.getName() %></td>
			<td><%=e.getEmail() %></td>
			<td><%=e.getDepartment() %></td>
			<td><a href = "employee?action=edit&id=<%=e.getId()%>">edit</a></td>
			<td><a href = "employee?action=delete&id=<%=e.getId()%>">delete</a></td>
		</tr>
		<%} %>
		
	</table>
</body>
</html>