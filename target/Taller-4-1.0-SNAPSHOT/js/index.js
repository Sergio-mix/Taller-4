const button = document.getElementById('button');
button.addEventListener('click', () => {
    doOpen('photographs.jsp');
});

function doOpen(url) {
    document.location.target = "_blank";
    document.location.href = url;
}