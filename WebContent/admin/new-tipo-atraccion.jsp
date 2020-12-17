<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<%@ include file="/admin/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<body>
	<h1 class="site-heading text-center text-white d-none d-lg-block">
		<span class="site-heading-lower">Tierra Media</span>
	</h1>
	<%@ include file="/admin/nav.jsp"%>
	<section class="page-section about-heading">
		<div id="wrapper">
			<div class="container">
				<div id="tabla-tipos-de-atracciones" class="m-4">

					<table class="table table-dark table-hover"
						style="background-color: rgba(47, 23, 15, 0.9);">
						<thead>
							<tr>
								<th>Nombre</th>
								
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tiposDeAtraccion}" var="tipo">
								<tr>
									<td><c:out value="${tipo.descripcion}" /></td>
									
									<td><button type="button" class="btn btn-warning">Modificar</button></td>
									<td><button type="button" class="btn btn-danger">Eliminar</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#exampleModal">Nuevo tipo de atracción</button>

				<!-- Modal -->
				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Nueva
									atracción</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">
								<form name="nuevo-tipo" action="admin-nuevoTipo" method="post">
									<div class="form-row">

										<label for="validationDefault01">Nombre</label> <input name="descripcion"
												type="text" class="form-control" id="descripcion" required>
									</div>
									<button type="submit" class="btn btn-primary">Guardar</button>
								</form>
							</div>
							<!-- <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <button type="button" class="btn btn-primary">Guardar</button>
    </div> -->
						</div>
					</div>
				</div>
			</div>

		</div>
		<div class="gradient"></div>
	</section>
	<%@ include file="/admin/footer.jsp"%>
</body>
</html>