<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Video Game List</title>
</head>
<body>
<form method = "post" action = "navigationServlet">
<table>
<c:forEach items="${requestScope.allItems}" var="currentgame">
<tr>
<td><input type="radio" name="id" value="${currentgame.id}"></td>
<td>${currentgame.store}</td>
<td>${currentgame.game}</td>
<td>${currentgame.price}</td>
</tr>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToGame">
<input type="submit" value="delete" name="doThisToGame">
<input type="submit" value="add" name="doThisToGame">
</form>
</body>
</html>