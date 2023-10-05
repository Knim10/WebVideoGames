<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New List</title>
</head>
<body>
	<form action="createNewListServlet" method="post">
		List Name: <input type="text" name="listName"> User Name: <input
			type="text" name="userName"> Available Items:<br /> <select
			name="allItemsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentgame">
				<option value="${currentgame.id}">${currentgame.game}|
					${currentgame.store} | ${currentgame.price}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create List and Add Games">
	</form>
	<a href="index.jsp">Go add new games instead.</a>
</body>
</html>