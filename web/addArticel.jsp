<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 15/3/22
  Time: 下午3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>neleblog - 发表文章 </title>
    <link rel="stylesheet" type="text/css" href="/styles/index.css"/>
    <script src="/scripts/jquery-1.11.2.min.js"></script>
    <script src="/scripts/add.js"></script>
</head>
<body>
<img src="/images/background2.jpg" class="bg-image">

<div class="top">
</div>
<div class="container">
    <div class="main">
        <div>
            <input type="text" id="title"/>
        </div>
        <div>
            <textarea id="content"></textarea>
        </div>
        <div>
            <select id="category">
                <option value="日常">日常</option>
                <option value="java">java</option>
            </select>
        </div>
        <div>
            标签：<input type="text"  id="tags" />
        </div>
        <div>
            <input type="button" id="btnAddArticle" value="增加"/>
        </div>
    </div>
</div>
</body>
</html>
