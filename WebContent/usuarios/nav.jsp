<nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
	<div class="container">
		<a
			class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none"
			href="#">Menú</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item active px-lg-4"><a
					class="nav-link text-uppercase text-expanded" href="saludo">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item px-lg-4"><a
					class="nav-link text-uppercase text-expanded" href="comprar">Comprar</a>
				</li>
				<li class="nav-item px-lg-4"><a
					class="nav-link text-uppercase text-expanded" href="itinerario">Itinerario</a>
				</li>
				
				<li class="nav-item dropdown px-lg-4"><a
					class="nav-link dropdown-toggle text-uppercase text-expanded role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"" href="#">Monedas</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">$ ${actual.presupuesto}</a>
					</div>
				</li>
				<li class="nav-item dropdown px-lg-4"><a
					class="nav-link dropdown-toggle text-uppercase text-expanded role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"" href="#">Tiempo</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">${actual.tiempo} horas</a>
					</div>
				</li>
				<li class="nav-item px-lg-4"><a
					class="nav-link text-uppercase text-expanded" href="logout">Salir</a>
				</li>
			</ul>
		</div>
	</div>
</nav>