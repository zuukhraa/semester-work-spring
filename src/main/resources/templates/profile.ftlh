<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Личная страница</title>
</head>
<body>
<h1>Профиль!</h1>
<form action="/profile" method="post" novalidate enctype="multipart/form-data">
    <td><p class="lead">Добро пожаловать, ${signUpForm.firstName} ${signUpForm.lastName}!</p></td>
    <td><p class="lead">Ваш факультет: ${signUpForm.faculty_name}</p></td>
</form>
<h2><a href="/logout">Выход</a></h2>
</body>
</html>
