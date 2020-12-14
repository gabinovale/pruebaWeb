<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Productos</h1>

<%String p = "pepito";%>
<c:set var="pepe" value="${p}"> </c:set>
<h1><c:out value="${pepe}" /></h1>
</body>
</html>