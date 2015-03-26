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
    <script src="scripts/side.js"></script>
    <script src="/scripts/add.js"></script>
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
        <div>
            <input type="text" id="title"/>
        </div>
        <div>
            <textarea id="content" rows="20" cols="50"></textarea>
        </div>
        <div>
            <select id="category">
                <option value="日常">日常</option>
                <option value="java">前端</option>
                <option value="java">后端</option>
            </select>
        </div>
        <div>
            标签（以,分割）：<input type="text" id="tags"/>
        </div>
        <div>
            <input type="button"  width="30px" height="50px" id="btnAddArticle" value="增加"/>
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
