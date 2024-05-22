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

<title>Crear Caballero</title>
</head>
<body>
	<main role="main" class="container mt-5">
		<h1>Crear caballero</h1>
		<c:if test="${msg .equals('error')}">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				<strong>ERROR</strong> Un valor introducido es nulo o fuera del
				rango
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<c:if test="${msg .equals('errorNombre')}">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				<strong>ERROR:NAME</strong> El nombre introducido no es valido o es nulo
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<c:if test="${msg .equals('errorValores')}">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				<strong>ERROR:VALOR</strong> Los valores introducidos en Experiencia y Fuerza no pueden ser superior a 100 o inferior a 0
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<c:if test="${msg .equals('errorInsert')}">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				<strong>ERROR:BASES</strong> Error al insertar el caballero en la base de datos
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<form action="storeCaballero" var="Caballero" method="post"
			enctype="multipart/form-data">
			<div class="form-group">
				<label for="addNombre">Nombre</label> <input type="text"
					class="form-control" id="addNombre" name="addNombre">
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="addFuerza">Fuerza</label> <input type="number"  class="form-control" id="addFuerza" name="addFuerza">
				</div>
				<div class="form-group col-md-6">
					<label for="addExperiencia">Experiencia</label> <input
						type="number" class="form-control"
						id="addExperiencia" name="addExperiencia">
				</div>
			</div>

			<div class="form-group">
				<label for="addFoto">Foto</label> <input type="file" name="addfoto" />
			</div>
			<div class="form-row">
				<div class="form-group">
					<label for="exampleFormControlSelect1">Arma</label> <select
						class="form-control" id="addArma" name="addArma">
						<c:forEach items="${armas}" var="arma">
							<option value="${arma.id}">${arma.nombre }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="form-group">
					<label for="exampleFormControlSelect1">Arma</label> <select
						class="form-control" id="addEscudo" name="addEscudo">
						<c:forEach items="${escudos}" var="escudo">
							<option value="${escudo.id}">${escudo.nombre }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Crear</button>
		</form>
	</main>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>