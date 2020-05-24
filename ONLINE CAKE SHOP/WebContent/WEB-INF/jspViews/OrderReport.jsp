<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<h1>Order Report</h1>
		<form:form modelAttribute="billBean" action="generateReport.html"
			method="post">
			<table>
				<tr>
					<td>From Price</td>
					<td><form:input path="fromPrice" /></td>
				</tr>
				<tr>
					<td>To Price</td>
					<td><form:input path="toPrice" /></td>
				</tr>
				<tr></tr>
				<tr>
					<td><input type="submit" value="Generate Report" /></td>
					<td><input type="reset" value="Cancel" /></td>
				</tr>
			</table>
			<br><br>
			<c:if test="${not empty beans}">
				<table border="4">
					<tr>
						<th>Order Id</th>
						<th>Customer Name</th>
						<th>Cake Id</th>
						<th>Quantity</th>
						<th>Bill</th>
					</tr>
					<c:forEach items="${beans}" var="itr">
						<tr>
							<td><c:out value="${itr.orderId}"></c:out></td>
							<td><c:out value="${itr.customerName}"></c:out></td>
							<td><c:out value="${itr.cakeID}"></c:out></td>
							<td><c:out value="${itr.noOfPiecesOrdered}"></c:out></td>
							<td><fmt:formatNumber value ="${itr.bill}"  type="currency" currencySymbol="INR."></fmt:formatNumber>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<br>
			<br>
			<spring:hasBindErrors name="billBean">
				<form:errors path="*" cssClass="error"></form:errors>
			</spring:hasBindErrors>
			<br>
		<a href="<c:url value="/cstlogout" />" > Logout</a>
		&nbsp;&nbsp;<a href="index.jsp">Home</a>
		</form:form>
	</center>
</body>
</html>