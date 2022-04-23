<!doctype html>
<html lang="en">
<meta charset="UTF-8">
<head>
    <title>Личная страница</title>
</head>
<body>
<h1>Профиль!</h1>
<td><p class="lead">Добро пожаловать, ${firstName} ${lastName}!</p></td>
<td><p class="lead">Ваш факультет: ${account.faculty_name}</p></td>
<br>

<form action="/profile/${account.id}/post" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    <td><p class="lead"><a href="/posts">Все посты</a></p></td>
    <td><p class="lead"><a href="profile/update">Изменить данные</a></p></td>
    <td><p class="lead">Добавить пост:</p></td>

    <input type="text" name="title" placeholder="Title">
    <input type="text" name="text" placeholder="Text">

    <input type="submit" value="Add">
</form>
<h2><a href="/logout">Выход</a></h2>
</body>
</html>
