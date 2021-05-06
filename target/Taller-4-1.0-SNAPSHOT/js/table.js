//Esta clase nos permite cargar los datos que se encuentran en el json a la tabla

//funcion para leer y cargar los datos del json a la tabla agregando las columnas con su correspondiente registro
$(document).ready(function () {
    $('#data-table').DataTable({

        "ajax": "/json/data.json",
        "columns": [
            { "data": "date" },
            { "data": "description" },
            { "data": "image" },
            { "defaultContent": "user" }
        ]
    });


});