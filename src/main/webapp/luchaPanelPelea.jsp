<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <title>Knights Information</title>
</head>
<body>
    <main role="main" class="container mt-5">
        <form method="post" enctype="multipart/form-data">
            <div class="row">
                <!-- First Knight Information -->
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="addNombre"><h2>Nombre:</h2></label>
                        <h1>${caballeroPrime.nombre}</h1>
                    </div>
                    <div class="form-group">
                        <label for="addFuerza">Fuerza:</label>
                        <div class="progress">
                            <div class="progress-bar bg-warning" role="progressbar" style="width: ${caballeroPrime.fuerza}%" aria-valuenow="${caballeroPrime.fuerza}" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addExperiencia">Experiencia:</label>
                        <div class="progress">
                            <div class="progress-bar progress-bar-striped bg-success" role="progressbar" style="width: ${caballeroPrime.experiencia}%" aria-valuenow="${caballeroPrime.experiencia}" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addFoto">Foto:</label>
                       
                    </div>
                    <div class="form-group">
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">${caballeroPrime.arma.nombre}</h5>
                                <p class="card-text">Tiene un ataque de ${caballeroPrime.arma.capacidad_danio} puntos</p>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top"  alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">${caballeroPrime.escudo.nombre}</h5>
                                <p class="card-text">Tiene una defensa de ${caballeroPrime.escudo.capacidad_defensa} puntos</p>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Second Knight Information -->
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="addNombre"><h2>Nombre:</h2></label>
                        <h1>${caballeroSecond.nombre}</h1>
                    </div>
                    <div class="form-group">
                        <label for="addFuerza">Fuerza:</label>
                        <div class="progress">
                            <div class="progress-bar bg-warning" role="progressbar" style="width: ${caballeroSecond.fuerza}%" aria-valuenow="${caballeroSecond.fuerza}" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addExperiencia">Experiencia:</label>
                        <div class="progress">
                            <div class="progress-bar progress-bar-striped bg-success" role="progressbar" style="width: ${caballeroSecond.experiencia}%" aria-valuenow="${caballeroSecond.experiencia}" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addFoto">Foto:</label>
                        
                    </div>
                    <div class="form-group">
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">${caballeroSecond.arma.nombre}</h5>
                                <p class="card-text">Tiene un ataque de ${caballeroSecond.arma.capacidad_danio} puntos</p>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top"  alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">${caballeroSecond.escudo.nombre}</h5>
                                <p class="card-text">Tiene una defensa de ${caballeroSecond.escudo.capacidad_defensa} puntos</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            

            <a href="javascript:history.back()" class="btn btn-primary mt-3">Volver</a>
        </form>
    </main>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
