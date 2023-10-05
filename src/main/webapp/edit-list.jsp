<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit An Existing List</title>
</head>
<body>
	<form action="editListDetailsServlet" method="post">
		<input type="hidden" name="id" value="${listToEdit.id}"> List
		Name: <input type="text" name="listName"
			value="${listToEdit.listName}"><br /> User Name: <input
			type="text" name="userName" value="${listToEdit.userName.userName}"><br />

		Available Items: <br /> <select name="allGamesToAdd" multiple
			size="6">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<option value="${currentitem.id}">${currentitem.store}|
					${currentitem.game} | ${currentitem.price}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Edit List and Add Games">
	</form>
	<a href="index.jsp">Go add new games instead.</a>
</body>
</html>