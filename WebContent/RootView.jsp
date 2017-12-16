<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>	Researcher</title>
</head>
<body>
<h1>Welcome root</h1>
<h2>Add Researcher:</h2>
<c:if test="${not empty isCreated}">
You have just created a new researcher
</c:if>
<form action="/APSV/CreateResearcherServlet" method="GET">
	<table border=1 cellpadding=5>
		<tr>
			<td>ID</td><td>Name</td><td>Affiliation</td><td>Email</td><td>Password</td>
		</tr>
		<tr>
			<td><input type="text" name="id"></td>
			<td><input type="text" name="name"></td>
			<td><input type="text" name="email"></td>
			<td><input type="text" name="affiliation"></td>
			<td><input type="text" name="password"></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form>
</body>
</html>