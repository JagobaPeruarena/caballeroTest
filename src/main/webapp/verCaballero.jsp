<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<title>Insert title here</title>
</head>
<body>
	<main role="main" class="container mt-5">
		<form var="Caballero" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="addNombre"><h2>Nombre:</h2></label> <label><h1>
						${caballero.nombre}</h1></label>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="addFuerza">Fuerza</label>
					<div class="progress">
						<div class="progress-bar" role="progressbar"
							style="width: ${caballero.fuerza}%"
							aria-valuenow="${caballero.fuerza}" aria-valuemin="0"
							aria-valuemax="100"></div>
					</div>
				</div>
				<div class="form-group col-md-6">
					<label for="addExperiencia">Experiencia</label>
					<div class="progress">
						<div class="progress-bar" role="progressbar"
							style="width: ${caballero.experiencia}%"
							aria-valuenow="${caballero.experiencia}" aria-valuemin="0"
							aria-valuemax="100"></div>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="addFoto">Foto</label> <input type="file" name="addfoto" />
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<div class="card" style="width: 18rem;">
						<img class="card-img-top" src="..." alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title">${caballero.arma.nombre}</h5>
							<p class="card-text">Tiene un ataque de
								${caballero.arma.capacidad_danio} puntos</p>

						</div>
					</div>
				</div>
				<div class="form-group col-md-6">
					<div class="card" style="width: 18rem;">
						<img class="card-img-top" src="..." alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title">${caballero.escudo.nombre}</h5>
							<p class="card-text">Tiene una defensa de
								${caballero.escudo.capacidad_defensa} puntos</p>

						</div>
					</div>
				</div>
			</div>

		</form>
	</main>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>