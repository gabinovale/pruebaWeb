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
		
		<div class="container">
				<div id="tabla-itinerarios" class="m-4">

					<table class="table table-dark table-hover"
						style="background-color: rgba(47, 23, 15, 0.9);">
						<thead>
							<tr>
								<th>Producto</th>
								<th>Costo</th>
								<th>Tiempo</th>
								<th>Tipo de Atracción</th>
								
								
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${compras}" var="c">
								<tr>
									
									<td><c:out value="${c.atraccion.nombre}" /></td>
									<td><c:out value="${c.atraccion.costo}" /></td>
									
									<td><c:out value="${c.atraccion.tiempo}" /></td>
									
									<td><c:out value="${c.atraccion.tipoAtraccion}" /></td>

									
									
								</tr>
							</c:forEach>
							
							
						</tbody>
					</table>
				</div>	


	</div>
	<div class="gradient"></div>
</section>
	<%@ include file="/usuarios/footer.jsp"%>
	

</body>

</html>