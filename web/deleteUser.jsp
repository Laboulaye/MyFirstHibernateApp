<%--
  Created by IntelliJ IDEA.
  User: Макс
  Date: 18.07.2019
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить пользователя</title>
</head>
<body>
    Вы действительно хотите удалить пользователя ${param.id}?

    <form action="/users/${param.id}" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Удалить">
    </form>

</body>
</html>
