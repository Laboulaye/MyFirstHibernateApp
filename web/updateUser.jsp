<%--
  Created by IntelliJ IDEA.
  User: Макс
  Date: 18.07.2019
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить данные пользователя</title>
</head>
    <body>

    Редактировать пользователя

    <form action="/users/${param.id}" method="post">
        <input type="hidden" name = "id" value="${param.id}">
        <input type="text" name="name" value="${param.name}" placeholder=${param.name}>
        <input type="text" name="age" value="${param.age}" placeholder=${param.age}>
        <input type="hidden" name="_method" value="put">
        <input type="submit" value="Обновить">
    </form>


    </body>
</html>
