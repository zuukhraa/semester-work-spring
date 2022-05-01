<!doctype html>
<html lang="en">
<meta charset="UTF-8">
<head>
    <title>Личная страница</title>
    <style>
        .avatar {
            vertical-align: middle;
            width: 100px;
            height: 100px;
            border-radius: 50%;
        }
    </style>
</head>
<body>
<h1>Профиль!</h1>
<td><p class="lead">Добро пожаловать, ${account.firstName} ${account.lastName}!</p></td>
<td><p class="lead">Ваш факультет: ${account.faculty_name}</p></td>
<br>
<#if account.avatar ?? >
    <img src="http://localhost:8081/profile/files/${account.avatar}" alt="image" class="avatar">
</#if>
<form action="/profile/${account.id}/post" method="post">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    <td><p class="lead"><a href="/posts">Все посты</a></p></td>
    <td><p class="lead"><a href="profile/update">Изменить данные</a></p></td>
    <td><p class="lead">Добавить пост:</p></td>

    <input type="text" name="title" placeholder="Title">
    <input type="text" name="text" placeholder="Text">

    <input type="submit" value="Add">
</form>

<td><p class="lead">Загрузить аватар:</p></td>
<form action="/profile/files/${account.id}/upload" method="post" enctype="multipart/form-data">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="file" name="file">
    <input type="submit" value="Загрузить">
</form>

<h2><a href="/logout">Выход</a></h2>
</body>
</html>
