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
								<th>Costo</th>
								<th>Tiempo</th>
								<th>Cupo Disponible</th>
								<th>Tipo de Atracción</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${atracciones}" var="atr">
							<c:choose>
								<c:when test="${atr.disponible == 0}">
								<tr>
									<td><c:out value="${atr.nombre}" /></td>
									<td><c:out value="${atr.costo}" /></td>
									<td><c:out value="${atr.tiempo}" /></td>
									<td><c:out value="${atr.cupo}" /></td>
									<td><c:out value="${atr.tipoAtraccion}" /></td>
									<td><button type="button" class="btn btn-warning">Modificar</button></td>
									<td><button type="button" class="btn btn-danger">Eliminar</button></td>
								</tr>
								</c:when>

											<c:otherwise>
     									         
   										     </c:otherwise>
								</c:choose>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#exampleModal">Nueva atracción</button>

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
								<form name="nueva-atraccion" action="admin-nuevaAtraccion" method="post">
									<div class="form-row">

										<label for="validationDefault01">Nombre</label> <input name="nombre"
												type="text" class="form-control" id="nombre" required>


									</div>
									<div class="form-row">
										<div class="col-md-6 mb-3">
											<label for="validationDefault02">Costo</label><input
												name="costo" type="number" class="form-control"
												id="costo" aria-describedby="basic-addon2" required>
										</div>
										
										<div class="col-md-6 mb-3">
											<label for="validationDefault03">Tiempo</label>
											<div class="input-group mb-3">
											 <input name="tiempo"
												type="number" class="form-control" id="tiempo" required>
												<div class="input-group-append">
												<span class="input-group-text" id="basic-addon2">horas</span>
											</div>
										</div>
									</div>
									<div class="form-row">
										<div class="col-md-4 mb-3">
											<label for="validationDefault04">Cupo</label> <input name="cupo"
												type="number" class="form-control" id="cupo" required>
										</div>
										
										<div class="col-md-8 mb-3">
											<label for="tipo_de_atraccion_id">Tipo de Atracción</label> <select
												name="tipo_de_atraccion_id" class="custom-select" id="tipo_de_atraccion_id"
												required=>
												<option selected="" disabled="" value="">Elige
													una...</option>
												<c:forEach items="${tiposDeAtraccion}" var="tipo">
													<option><c:out value="${tipo.descripcion}" /></option>
												</c:forEach>


											</select>
										</div>

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