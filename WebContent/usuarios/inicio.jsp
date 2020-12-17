<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<%@ include file="/usuarios/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<body>
<h1 class="site-heading text-center text-white d-none d-lg-block">
    <span class="site-heading-lower">Tierra Media</span>
  </h1>
<%@ include file="/usuarios/nav.jsp"%>
<section class="page-section about-heading">
	<div id="wrapper">
		<c:set var="usuario" value="${actual.username}"/>
		<h1 class="site-heading text-center text-white">
    	<span class="site-heading-lower">Bienvenid@ &nbsp;<c:out value="${usuario}"/></span>
  		</h1>

		

		


	</div>
	<div class="gradient"></div>
</section>
	<%@ include file="/usuarios/footer.jsp"%>
	

</body>

</html>