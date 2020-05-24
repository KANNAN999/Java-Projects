<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
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
<h1>Update Order Page</h1>
<form:form modelAttribute="cakeOrderBeanUpdate" action="updateOrderById.html" method="post">
<table>
				<tr>
					<form:hidden path="orderId"/>
					<form:hidden path="bill"/>
				</tr>
			<tr>
				<td>Customer Name</td>
				<td><form:input path="customerName" /></td>
			</tr>
			<tr>
				<td>Customer Contact Number</td>
				<td><form:input path="contactNumber" /></td>
			</tr>
			<tr>
				<td>Choose a Cake</td>
				<td><form:select path="cakeID">
						<form:option label="--Select--" value="" />
						<form:options items="${cakeList}" />
					</form:select></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><form:input path="noOfPiecesOrdered" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Place Order" /></td>
				<td><input type="reset" value="Cancel"></td>
			</tr>
		</table>
		<br>
		<br>
			<br>
			<spring:hasBindErrors name="cakeOrderBeanUpdate">
				<form:errors path="*" cssClass="error"></form:errors>
			</spring:hasBindErrors>
		<br><br><br>
			<a href="<c:url value="/cstlogout" />" > Logout</a>
			&nbsp;&nbsp;<a href="index.jsp">Home</a>
</form:form>
</center>
</body>
</html>