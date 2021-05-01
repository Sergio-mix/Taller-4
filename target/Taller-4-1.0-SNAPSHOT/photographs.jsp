<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Carga de fotografias</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style_photographs.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<form action="Controlador?accion=Guardar" class="col-md-6" method="POST" enctype="multipart/form-data" id="form">
    <div class="card">
        <div class="card-header">
            <h3>Agregar Imagenes</h3>
        </div>
        <div class="card-body">
            <div class="form-group">
                <label>Description </label>
                <input type="text" name="txtNombre" class="form-control">
            </div>
            <div class="form-group">
                <label>Imagen</label>
                <input type="file" name="fileImagen">
            </div>
        </div>
        <div class="card-footer">
            <button class="btn btn-outline-primary" name="accion" value="Guardar">Guardar Imagen</button>
        </div>
    </div>
</form>
</body>
</html>