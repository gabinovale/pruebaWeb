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
				<div id="tabla-promociones" class="m-4">

					<table class="table table-dark table-hover"
						style="background-color: rgba(47, 23, 15, 0.9);">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Costo</th>
								<th>Tiempo</th>
								<th>Cupo Disponible</th>
								<th>Tipo de Atracción</th>
								<th>Tipo de Promo</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${promociones}" var="promo">
								<tr>
									<td><c:out value="${promo.nombre}" /></td>
									<td><c:out value="${promo.costo}" /></td>
									<td><c:out value="${promo.tiempo}" /></td>
									<td><c:out value="${promo.cupo}" /></td>
									<td><c:out value="${promo.tipoAtraccion}" /></td>
									<td><c:out value="${promo.tipoPromo}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#exampleModal">Nueva Promoción</button>

				<!-- Modal -->
				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Nueva
									Promoción</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">
								<form>
									<div class="form-row">

										<label for="validationDefault01">Nombre</label> <input
											type="text" class="form-control" id="validationDefault01"
											required>


									</div>
									<div class="form-row">
										<div class="col-md-6 mb-3">
											<label for="validationDefault02">Costo</label> <input
												type="number" class="form-control" id="validationDefault02"
												required>
										</div>
										<div class="col-md-6 mb-3">
											<label for="validationDefault03">Tiempo</label> <input
												type="number" class="form-control" id="validationDefault03"
												required>
										</div>
									</div>
									<div class="form-row">
										<div class="col-md-4 mb-3">
											<label for="validationDefault04">Cupo</label> <input
												type="number" class="form-control" id="validationDefault04"
												required>
										</div>
										<div class="col-md-8 mb-3">
											<label for="validationDefault05">Tipo de Atracción</label> <select
												class="custom-select" id="validationDefault05" required=>
												<option selected="" disabled="" value="">Elige
													una...</option>
												<option>Aventura</option>
												<option>Paisaje</option>
												<option>Degustación</option>
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

</body>
</html>