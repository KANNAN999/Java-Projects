<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
<center>
	<h1>Search Your Record based on Your Order Id</h1>
	<form:form modelAttribute="cakeOrderId" method="post"
		action="searchOrderToDelete.html">
		<table>
			<tr>
				<td>Enter Order Id</td>
				<td><form:input path="OrderId" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search"></td>
				<td><input type="reset" value="Cancel" /></td>
			</tr>
		</table>
		<br>
		<br>
			<br>
			<spring:hasBindErrors name="cakeOrderId">
				<form:errors path="*" cssClass="error"></form:errors>
			</spring:hasBindErrors>
			<a href="<c:url value="/cstlogout" />" > Logout</a>
			&nbsp;&nbsp;<a href="index.jsp">Home</a>
	</form:form>
</center>

</body>
</html>