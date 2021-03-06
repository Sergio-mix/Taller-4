<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login servlet with cookies </title>
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:ital,wght@1,300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<form action="login-with-cookies">
    <div id="conteiner">
        <h2 id="title">Username</h2>
        <p><input type="text" name="username" required placeholder="Username" id="txtName"></p>
        <input type="submit" value="Login" id="button">
        <script src="js/index.js" defer></script>
    </div>
</form>
</body>
</html>