<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<body>
<h1>Connexion</h1>
<br>

<form action = "<%=request.getContextPath() %>/accueil.jsp" method = "POST">
	Username : <input type = "text" name = "nom">
</form>
</body>
</html>