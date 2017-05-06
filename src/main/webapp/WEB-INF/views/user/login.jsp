<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
    <div class="bg-info">
        <c:if test="${not empty message}" >
            ${message.state}:${message.message}
        </c:if>
    </div>
    <div class="container">
        <form action="/login" method="post">
            <label for="tel">手机号:</label>
            <input type="text" id="tel" name="tel" class="form-control">

            <label for="password">密码:</label>
            <input type="password" id="password" name="password" class="form-control">

            <button class="btn btn-primary" type="submit">登录</button>
        </form>
    </div>
</body>
</html>