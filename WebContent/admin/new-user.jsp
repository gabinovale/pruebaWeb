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
				<div id="tabla-atracciones" class="m-4">

					<table class="table table-dark table-hover"
						style="background-color: rgba(47, 23, 15, 0.9);">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Presupuesto</th>
								<th>Tiempo</th>
								<th>Preferencia</th>
								<th>Es admin?</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${usuarios}" var="us">
							
								<tr>
									<td><c:out value="${us.username}" /></td>
									<td><c:out value="${us.presupuesto}" /></td>
									<td><c:out value="${us.tiempo}" /></td>
									<td><c:out value="${us.preferencia}" /></td>
									<td><c:choose>
											<c:when test="${us.admin == 1}">
          										  Si
    									     </c:when>

											<c:otherwise>
     									          No
   										     </c:otherwise>
										</c:choose></td>
									<td><button type="button" class="btn btn-warning">Modificar</button></td>
									<td><button type="button" class="btn btn-danger">Eliminar</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#exampleModal">Nuevo usuario</button>

				<!-- Modal -->
				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h1 class="modal-title" id="exampleModalLabel">Nuevo
									usuario</h1>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">

								<form name="nuevo-usuario" action="admin-nuevoUsuario" method="post">
									<div class="form-row">
										<div class="col-md-6 mb-3">
											<label for="nombre">Nombre</label> <input name="username"
												type="text" class="form-control" id="nombre" required>

										</div>
										<div class="col-md-6 mb-3">
											<label for="pass">Password</label> <input name="password"
												type="password" class="form-control" id="pass" required>
										</div>

									</div>
									<div class="form-row">
										<div class="col-md-6 mb-3">
										
											<label for="presupuesto">Presupuesto</label> 
											<div class="input-group mb-3">
											<input
												name="presupuesto" type="number" class="form-control"
												id="presupuesto" aria-describedby="basic-addon2" required>
											<div class="input-group-append">
												<span class="input-group-text" id="basic-addon2">monedas</span>
											</div>
											</div>
										</div>
										<div class="col-md-6 mb-3">
											<label for="tiempo">Tiempo</label> 
											<div class="input-group mb-3">
											<input name="tiempo"
												type="number" class="form-control" id="tiempo" step="0.5"
												required>
											<div class="input-group-append">
												<span class="input-group-text" id="basic-addon2">horas</span>
											</div>
											</div>
										</div>
									</div>
									<div class="form-row">
										<div class="col-md-4 mb-3">

											<div class="col-sm-12">
												<div class="form-check">
													<input class="form-check-input" type="checkbox"
														id="check-admin" name="is-admin"> <label
														class="form-check-label" for="check-admin"> ¿Es
														Admin? </label>
												</div>
											</div>
										</div>
										<div class="col-md-8 mb-3">
											<label for="preferencia">Preferencia</label> <select
												name="preferencia" class="custom-select" id="preferencia"
												required=>
												<option selected="" disabled="" value="">Elige
													una...</option>
												<c:forEach items="${tiposDeAtraccion}" var="tipo">
													<option><c:out value="${tipo.descripcion}" /></option>
												</c:forEach>


											</select>
										</div>

									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-primary">Guardar</button>
									</div>
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