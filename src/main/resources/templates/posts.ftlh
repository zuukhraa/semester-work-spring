<html>
<head>
    <title>Посты</title>
</head>
<body>
<table id="posts_table">
    <tr>
        <th>Action</th>
        <th>Заголовок</th>
        <th>Текст</th>
        <th>Дата</th>
    </tr>
    <#list posts as post>
        <tr>
            <td>
                <form method="post" action="/posts/${post.id}/delete">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" value="Удалить">
                </form>
            </td>
            <td>${post.title}</td>
            <td>${post.text}</td>
            <td>${post.createdAt}</td>
            <td></td>
        </tr>
    </#list>
</table>
</body>
</html>