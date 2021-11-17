<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>L'article sélectionné</h1>
<h2><%= request.getParameter("titre") %></h2>
<h3>Ecrit par <%= request.getParameter("auteur") %></h3>
<p>
<%= request.getParameter("text") %>
</p>
</br></br>
<a href="<%=request.getContextPath() %>/articles">Retour</a>
</body>
</html>