const button = document.getElementById('button');
button.addEventListener('click', () => {
    doOpen('Photographs.html');
});

function doOpen(url) {
    document.location.target = "_blank";
    document.location.href = url;
}