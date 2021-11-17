<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	
%>
<h1>Mes infos</h1>
<h2>Username : <%=request.getAttribute("username") %></h2>
<h2>Email : <%=request.getAttribute("email") %></h2>
<h2>Nombre d'articles : <%=request.getAttribute("nbArticles") %></h2>

</br></br>
<a href="<%=request.getContextPath() %>/accueil.jsp">Retour</a>
</body>
</html>