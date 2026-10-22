<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="index.jsp" %>
<%! List list = new ArrayList<>();  %>
<%! int a = 10; %>
<%! public int add(int a, int b){return a+b;} %>
<%= a %> <br>
<%= add(10, 20) %>

<% System.out.println("Hello"); %>
<%@ include file="index.jsp" %>
</body>
</html>