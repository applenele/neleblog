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
    <script src="/scripts/jquery-1.11.2.min.js"></script>
    <script src="/scripts/login.js"></script>
    <script src="/scripts/side.js"></script>
    <link rel="stylesheet" href="/styles/index.css"/>
</head>
<body>
<div class="top">
    <div class="nav">
        <ul class="nav_list">
            <li><a href="/"><span>Daily</span><br/><span class="zh">生活</span></a></li>
            <li><a href="/"><span>FrontEnd</span><br/><span class="zh">前端</span></a></li>
            <li><a href="/"><span>BackEnd</span><br/><span class="zh">后端</span></a></li>
            <li><a href="/"><span>Message</span><br/><span class="zh">留言板</span></a></li>
            <li><a href="/"><span>About</span><br/><span class="zh">关于</span></a></li>
        </ul>
    </div>
</div>
<div class="banner">
</div>
<div class="container">
    <div class="main">
        <div class="login-box">
            <div class="inline">用户:<input type="text" id="username" placeholder="用户名"/></div>
            <div class="inline">密码:<input type="password" id="password" placeholder="密码"/></div>
            <div class="inline"><input type="button" height="30px" value="登陆" id="btnLogin"/></div>
        </div>
    </div>
    <div class="right">
        <div class="side">
            <h3>CATALOGS</h3>

            <div class="catalogs_list">
            </div>
        </div>

        <div class="side">
            <h3>CALENDAR</h3>

            <div class="calendar_list">
            </div>
        </div>
    </div>
    <div style="clear:both"></div>
</div>
<div class="footer">
    <div>Copyright © 2015 nele
    </div>
</div>
</body>
</html>
