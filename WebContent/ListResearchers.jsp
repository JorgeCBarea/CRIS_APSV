<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Researchers:</title>
</head>
<body>
<c:if test="${not empty rs }"></c:if>
There are <c:out value="${fn:length(rs) }"></c:out>
<table border=1 cellpadding=5>
<tr>
<td>Id</td><td>Name</td><td>Affiliation</td><td>Email</td>
</tr>
			<c:forEach items="${rs}" var="rsi">
				<tr>
					<td> <a href=<c:out value="ViewResearcherServlet?rsi=${rsi.id}"/>>
             					 <c:out value="${rsi.id}" /></a></td>
					<td><c:out value="${rsi.name}"/>
					<td><c:out value="${rsi.affiliation}"/>
					<td><c:out value="${rsi.email}"/>
				</tr>	
			</c:forEach>
</table>



</body>
</html>