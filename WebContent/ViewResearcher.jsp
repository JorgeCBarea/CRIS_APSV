<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ViewResearcherJSP</title>
</head>
<body>
<h1>Researcher Profile</h1>
The researcher profile that you have looked for is 
<table  border=1 cellpadding=5>
	<tr>
		<td>Id</td><td>Name</td><td>Affiliation</td><td>Email</td>
	</tr>
	<tr>
		<td><c:out value="${researcher.id}"/>
		<td><c:out value="${researcher.name}"/>
		<td><c:out value="${researcher.affiliation}"/>
	</tr>
	<c:forEach items="${researcher.publications}" var="rsi">
	<tr>
	<td><c:out value="${rsi.title}"></c:out></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>