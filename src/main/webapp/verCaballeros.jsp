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
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Listado de alumnos</h1>
				</div>
	<div class="table-responsive">
		<table class="table table-striped table-sm">
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Fuerza</th>
					<th>Experiencia</th>
					<th>Foto</th>
					<th>ArmaID</th>
					

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
					<td>${caballero.arma.id}</td>
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