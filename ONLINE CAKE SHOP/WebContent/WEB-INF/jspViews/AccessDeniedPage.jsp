<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Access Denied Handler</title>

</head>
<body >
	<h3>Logged in User: ${pageContext.request.userPrincipal.name} is not authorized to access the page</h3>
	<%session.invalidate(); %>
	<h4><a href="index.jsp"> Home</a></h4>

</body>