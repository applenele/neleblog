<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 15/3/21
  Time: 下午3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>neleblog - index</title>
    <script src="scripts/index.js"></script>
    <link rel="stylesheet" href="styles/index.css"/>
</head>
<body>
<img src="/images/background2.jpg" class="bg-image">

<div class="top">
    asd
</div>
<div class="container">
    <div class="main">
        <div class="article">
            <h3>test</h3>
            <div>asdasd</div>
        </div>
    </div>
    <div class="right">
        <div class="side">
            <div>日常</div>
            <div>日常</div>
            <div>日常</div>
        </div>
       <c:if test="${user=='admin'}" >
           <div><a href="addArticel.jsp">发表文章</a></div>
       </c:if>
    </div>
</div>
<div class="footer">
    <div><a href="login.jsp">登陆</a></div>
</div>
</body>
</html>
