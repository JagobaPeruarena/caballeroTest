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

<title>SeleccionarCaballeroSecond</title>
</head>
<body>
	<main role="main" class="container mt-5">
		<h1>SeleccionarCaballeroSecond</h1>

		<form action="luchaPanelPelea" method="get">
		<input type="hidden" name="caballeroPrime" id="caballeroPrime" value="${caballeroPrime}" >
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
					<c:if test="${caballero.id!=caballeroPrime }">
					<td><input class="form-check-input" type="radio" name="caballeroSecond" id="caballeroSecond" value="${caballero.id}" > </td>
					<td>${caballero.id}</td>
					<td>${caballero.nombre}</td>
					<td>${caballero.fuerza}</td>
					<td>${caballero.experiencia}</td>
					<td>${caballero.foto}</td>
					<td>${caballero.arma.nombre}</td>
					<td>${caballero.escudo.nombre}</td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
		</table>
			<div class="form-row">
				<button type="submit" class="btn btn-primary">Crear</button>
				<a href="javascript:history.back()" style="float: right"
					class="btn btn-primary mt-3">Volver</a>
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