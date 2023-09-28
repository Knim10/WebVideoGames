<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
<form action ="addItemServlet"method="post">
Store: <input type ="text"name ="store">
Game: <input type ="text"name ="game">
Price: <input type ="text"name ="price">
<input type ="submit"value="Add Game">
</form><br />
<a href ="viewAllItemsServlet">View the complete list of games</a>
</body>
</html>