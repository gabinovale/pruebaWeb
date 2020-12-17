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
				<div id="tabla-atracciones" class="m-4">

					<table class="table table-dark table-hover"
						style="background-color: rgba(47, 23, 15, 0.9);">
						<thead>
							<tr>
								<th>Nombre</th>
								<th></th>
								<th>Costo</th>
								<th>Tiempo</th>
								<th>Cupo Disponible</th>
								<th>Tipo de Atracción</th>
								<th></th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${promocionesPreferentes}" var="promo">
								<tr>
									<td><c:out value="${promo.nombre}" /></td>
									<td>
									<div class="dropdown">
											<a class="dropdown-toggle text-uppercase text-expanded role="
												button" data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false" " href="#">Atracciones</a>
											<div class="dropdown-menu">
												<c:forEach items="${promo.atracciones}" var="atrac">
													<a class="dropdown-item" href="#"><c:out value="${atrac.nombre}" /></a>
												</c:forEach>
											</div>
									</div> 
									</td>
									
									<td><c:out value="${promo.costo}" /></td>
									<td><c:out value="${promo.tiempo}" /></td>
									<td><c:out value="${promo.cupo}" /></td>
									<td><c:out value="${promo.tipoAtraccion}" /></td>
									
									<td><button type="button" class="btn btn-success">Comprar</button></td>
								</tr>
							</c:forEach>
							
							<c:forEach items="${atraccionesPreferentes}" var="atr">
								<tr>
									<td><c:out value="${atr.nombre}" /></td>
									<td></td>
					
									<td><c:out value="${atr.costo}" /></td>
									<td><c:out value="${atr.tiempo}" /></td>
									<td><c:out value="${atr.cupo}" /></td>
									<td><c:out value="${atr.tipoAtraccion}" /></td>
									
										<td> 
										<form name="" action="nuevaCompra" method="post">
										<input id="prodId" name="prodId" type="hidden" value="${atr.id}">
										<button type="submit" class="btn btn-success">Comprar</button></form>
										</td>
									
								</tr>
							</c:forEach>
							<c:forEach items="${otrasPromociones}" var="promo">
								<tr>
									<td><c:out value="${promo.nombre}" /></td>
									<td>
									<div class="dropdown">
											<a class="dropdown-toggle text-uppercase text-expanded role="
												button" data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false" " href="#">Atracciones</a>
											<div class="dropdown-menu">
												<c:forEach items="${promo.atracciones}" var="atrac">
													<a class="dropdown-item" href="#"><c:out value="${atrac.nombre}" /></a>
												</c:forEach>
											</div>
									</div> 
									</td>
									
									<td><c:out value="${promo.costo}" /></td>
									<td><c:out value="${promo.tiempo}" /></td>
									<td><c:out value="${promo.cupo}" /></td>
									<td><c:out value="${promo.tipoAtraccion}" /></td>
									
									<td><button type="button" class="btn btn-success">Comprar</button></td>
								</tr>
							</c:forEach>
							<c:forEach items="${otrasAtracciones}" var="atr">
								<tr>
									<td><c:out value="${atr.nombre}" /></td>
									<td></td>
									<td><c:out value="${atr.costo}" /></td>
									<td><c:out value="${atr.tiempo}" /></td>
									<td><c:out value="${atr.cupo}" /></td>
									<td><c:out value="${atr.tipoAtraccion}" /></td>
									
									<td> 
										<form name="" action="nuevaCompra" method="post">
										<input id="prodId" name="prodId" type="hidden" value="${atr.id}">
										<button type="submit" class="btn btn-success">Comprar</button></form>
									</td>

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