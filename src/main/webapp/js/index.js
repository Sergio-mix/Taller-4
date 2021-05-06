const button = document.getElementById('button');
button.addEventListener('click', () => {
    doOpen('photographs.jsp');
});

function doOpen(url) {
    document.location.target = "_blank";
    document.location.href = url;
}

function printTable(elementId, servlet, columns,actions = []) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var tbodyRef = document.getElementById(elementId).getElementsByTagName('tbody')[0];
            data.map(d => {
                var newRow = tbodyRef.insertRow();
                columns.map(c => {
                    var cell = newRow.insertCell();
                    var text = document.createTextNode(d[c]);
                    cell.appendChild(text);
                });
                if (actions.includes('create-book')) {
                    var cell = newRow.insertCell();
                    var action = document.createElement('button');
                    //  action.setAttribute('onclick', 'location.href="./upload.jsp?file=' + d['file'] +'ocation.href="./upload"'+ d['upload']+';');
                    var text = document.createTextNode('Descargar');
                    action.appendChild(text);
                    cell.appendChild(action);
                }
            });
        }
    }
    xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
    xhr.send(null);
}
// Printing authors

printTable(elementId = 'authorsTbl', servlet = 'GetCities', columns = ['nombre', 'fecha', 'descripcion', <img src="C:\\Users\\SergioHZ\\IdeaProjects\\Taller-4\\src\\main\\resources\\images\\"  width="500" height="600"/> ],actions = ['create-book']);


