<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h1>hello</h1>
    <a href="/login" class="btn btn-primary">登录</a>
    <ul>
        <li>${user.id}</li>
        <li>${user.username}</li>
        <li>${user.password}</li>
        <li>${user.tel}</li>
        <li>${user.createTime}</li>
    </ul>
</body>
</html>