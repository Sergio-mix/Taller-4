$(document).ready(function () {
    var table = $('#data-table').DataTable({
        "ajax": "/json/data.json",
        "columns": [
            { "data": "date" },
            { "data": "description" },
            { "data": "image" },
            { "defaultContent": "<button type='button' class='edit btn btn-primary'><i class='fa fa-pencil-square-o'></i></button>	<button type='button' class='eliminar btn btn-danger' data-toggle='modal' data-target='#modalEliminar' ><i class='fa fa-trash-o'></i></button>" }
        ]
    });

    data_edit("#data-table tbody", table);
});