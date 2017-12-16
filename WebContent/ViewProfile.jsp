<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Researchers:</title>
</head>
<body>
ViewResearcher:
<c:if test="${not empty researcher }">
Welcome <c:out value="${researcher.name}"/>
<form action="/APSV/GenerateCVServlet" method="GET">
	<input type="hidden" name="id" value=<c:out value="${researcher.id}"/>>
	<input type="submit" value="Generate CV">
</form>

<form action="/APSV/CreatePublicationServlet" method="GET">
	<input type="text" name="id">
	<input type="text" name="title">
	<input type="text" name="citeCount">
	<input type="submit" value="Create Publication">
</form>
These are your data
<form action="/APSV/UpdateProfileServlet" method="GET">
ID: <input type="text" name="id" value=<c:out value="${researcher.id}"/>>
Name: <input type="text" name="name" value=<c:out value="${researcher.name}"/>>
Email: <input type="text" name="email" value=<c:out value="${researcher.email}"/>>
Affiliation: <input type="text" name="affiliation" value=<c:out value="${researcher.affiliation}"/>>
Password: <input type="text" name="password" value=<c:out value="${researcher.password}"/>>
<input type="submit" value="Update Values">
</form>
<table border=1 cellpadding=5>
<tr>
	<td>Id</td><td>Title</td><td>Cities</td><td>Id</td><td>Authors</td>
</tr>
	<c:forEach items="${researcher.publications}" var="pi">
		<tr>
			<td><c:out value="${pi.id}"/></td>
			<td><c:out value="${pi.title}"/></td>
			<td><c:out value="${pi.citeCount}"/></td>
			<td><c:out value="${fn:length(pi.authors)}"/></td>
		</tr>	
	</c:forEach>
</table>
</c:if>
</body>
</html>