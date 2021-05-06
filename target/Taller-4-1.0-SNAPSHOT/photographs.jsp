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
<form action="accion" class="col-md-6" method="post" enctype="multipart/form-data">
    <div class="card">
        <div class="card-header">
            <h3>Agregar Imagenes</h3>
        </div>
        <div class="card-body">
            <div class="form-group">
                <label>Description </label>
                <input type="text" name="txtNombre" required class="form-control">
            </div>
            <div class="form-group">
                <label>Imagen</label>
                <input type="file" name="fileImagen" required>
            </div>
        </div>
        <div class="card-footer">
            <input type="submit" class="btn btn-outline-primary" name="btnEnviar" value="Guardar">
            <input type="submit" class="btn btn-outline-primary" name="btnEnviar" value="Mostrar">
        </div>
    </div>
</form>
</body>
</html>