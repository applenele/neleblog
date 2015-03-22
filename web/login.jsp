<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 15/3/22
  Time: 下午1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>neleblog - login</title>
    <script src="/scripts/jquery-1.11.2.min.js" ></script>
    <script src="/scripts/login.js"></script>
    <link rel="stylesheet" href="/styles/index.css" />
</head>
<body>
    <img src="/images/background2.jpg" class="bg-image">
    <div class="login-box">
        用户名:<input type="text" id="username" placeholder="用户名" /> <br />
        密码:<input type="password" id="password" placeholder="密码" /> <br >
        <input type="button" value="登陆" id="btnLogin" />
    </div>
</body>
</html>
