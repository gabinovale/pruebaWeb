<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Turismo en la Tierra Media</title>

  <link href="bootstrapJquery/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i" rel="stylesheet">

  <link href="css/estilo.css" rel="stylesheet">

</head>

<body>

  <h1 class="site-heading text-center text-white d-none d-lg-block">
    <span class="site-heading-lower">Tierra Media</span>
  </h1>

  <nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
    <div class="container">
      <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Menú</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav mx-auto">
          <li class="nav-item px-lg-4">
            <a class="nav-link text-uppercase text-expanded" href="index.html">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item active px-lg-4">
            <a class="nav-link text-uppercase text-expanded" href="usuarios.jsp">Usuarios</a>
          </li>
          <li class="nav-item px-lg-4">
            <a class="nav-link text-uppercase text-expanded" href="productos.jsp">Productos</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <section class="page-section about-heading">
    <div id="wrapper">
      <form name="login-form" class="login-form" action="nuevoUsuario" method="post">
  
        <div class="header">
          <h1>Nuevo usuario</h1>
        </div>
  
        <div class="content">
          <input name="username" type="text" class="input username" placeholder="Usuario" />
          <div class="user-icon"></div>
            <input name="password" type="password" class="input password" placeholder="Contraseña" />
          <div class="pass-icon"></div>   
        </div>

        <div class="footer">
          <input type="submit" name="submit" value="Crear" class="button" />
<!--           <input type="submit" name="submit" value="Registrarse" class="register" /> -->
        </div>
  
      </form>
    </div>
    <div class="gradient"></div>
  </section>

  <footer class="footer text-faded text-center py-5">
    <div class="container">
      <p class="m-0 small">Los Jedis de Java 2020</p>
    </div>
  </footer>

  <script src="bootstrapJquery/jquery/jquery.min.js"></script>
  <script src="bootstrapJquery/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
