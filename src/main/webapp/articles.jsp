<%@page import="java.util.List"%>
<%@page import="fr.mika.model.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Les articles</h1>
<%
	List<Article> articles = (List<Article>)request.getAttribute("articles");
	String param;
	Article a;
	for (int i=0; i<articles.size(); i++) {
		a = articles.get(i);
		param = "titre="+a.getTitre()+"&auteur="+a.getUser()+"&text="+a.getContenu();
%>
<a href="<%=request.getContextPath() %>/article.jsp?<%= param%>">
<h3><%= a.getTitre() %></a></h3>
<% } %>

</body>
</html>