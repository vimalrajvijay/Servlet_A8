<%@page import="com.example.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Employee employee = (Employee)request.getAttribute("employee"); 
boolean emp = employee!=null;
%>
<form action="employee" method = "post" ><br>
<input type="hidden" name="action" value = <%=emp?"edit":"create" %>>
<%if(emp){  %>
	<input type="hidden" name="id" value = <%=employee.getId() %>>
<% }%>
Name : <input type = "text" name = "name" value = <%=emp?employee.getName():"" %>><br>
Email: <input type = "email" name = "email" value = <%=emp?employee.getEmail():"" %>><br>
Department : <input type = "text" name = "dept" value = <%=emp?employee.getDepartment():"" %>>
<button type = "submit"><%=emp?"Edit":"Add" %></button>
</form>
</body>
</html>