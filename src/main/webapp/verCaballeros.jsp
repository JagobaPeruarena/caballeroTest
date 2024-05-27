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
	<main role="main" class="container">
		<div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
			<h1 class="h2">Listado de Caballeros</h1>
		</div>
		<div class="form-row">
			<div class="form-group col-md-3">
				<a type="button" class="btn btn-success btn-md-3"
					href="agregarCaballero">Crear</a>
			</div>
			<div class="form-group col-md-3">
				<a type="button" class="btn btn-success btn-md-3" href="luchaPanel1">Lucha</a>
			</div>
			<div class="form-group col-md-3">
				<a type="button" class="btn btn-success btn-md-3" href="ordenarCaballeros">Ordenar</a>
			</div>
			<div class="form-group col-md-3">
				<form action="verCaballeros" method="get">
					<div class="form-row">

						<input type="text" class="form-control" id="busqueda"
							name="busqueda">
						<button type="submit" class="btn btn-primary">Buscar</button>

					</div>
				</form>
			</div>
			<div class="form-group col-md-3">
				<form action="eliminarCaballeros" method="get">
					<div class="form-row">

						<input type="text" class="form-control" id="eliminar"
							name="eliminar">
						<button type="submit" class="btn btn-danger">
							<i class="fas fa-trash-alt"></i>
						</button>

					</div>
				</form>
			</div>
		</div>

		<div class="table-responsive">
			<table class="table table-striped table-sm">
				<thead class="thead-dark">
					<tr>
						<th>#</th>
						<th>Nombre</th>
						<th>Fuerza</th>
						<th>Experiencia</th>
						<th>Foto</th>
						<th>Arma</th>
						<th>Escudo</th>
						<th>Acciones</th>


					</tr>
				</thead>
				<tbody>
					<c:forEach items="${caballeros}" var="caballero">
						<tr>
							<td>${caballero.id}</td>
							<td>${caballero.nombre}</td>
							<td>${caballero.fuerza}</td>
							<td>${caballero.experiencia}</td>
							<td>${caballero.foto}</td>
							<td>${caballero.arma.nombre}</td>
							<td>${caballero.escudo.nombre}</td>
							<td><a class="btn btn-primary btn-sm delete-btn"
								href="editarCaballero?caballeroId=${caballero.id}"> <i
									class="fas fa-edit"></i></a> <a
								class="btn btn-danger btn-sm delete-btn"
								href="eliminarCaballero?caballeroId=${caballero.id}"> <i
									class="fas fa-trash-alt"></i></a> <a
								class="btn btn-info btn-sm delete-btn"
								href="verCaballero?caballeroId=${caballero.id}"> <i
									class="fas fa-eye"></i></a></td>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</main>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>