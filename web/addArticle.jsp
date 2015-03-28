<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 15/3/22
  Time: 下午3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = this.getServletConfig().getServletContext().getContextPath();
%>
<html>
<head>
    <title>neleblog - 发表文章 </title>
    <link rel="stylesheet" type="text/css" href="/styles/index.css"/>
    <script src="/scripts/jquery-1.11.2.min.js"></script>
    <script src="<%=path%>/scripts/ckeditor/ckeditor.js"></script>
    <script src="scripts/side.js"></script>
    <script src="/scripts/add.js"></script>
</head>
<body>
<div class="top">
    <div class="nav">
        <ul class="nav_list">
            <li><a href="/"><span><a href="javascript:LoadByCategory('Daily')">Daily</a></span><br/><span class="zh">生活</span></a></li>
            <li><a href="/"><span><a href="javascript:LoadByCategory('FrontEnd')">FrontEnd</a></span><br/><span class="zh">前端</span></a></li>
            <li><a href="/"><span><a href="javascript:LoadByCategory('BackEnd')">BackEnd</a></span><br/><span class="zh">后端</span></a></li>
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
            <textarea id="content" name="content" rows="20" cols="50"></textarea>
        </div>
        <div>
            <select id="category">
                <option value="Daily">Daily</option>
                <option value="FrontEnd">FrontEnd</option>
                <option value="BackEnd">BackEnd</option>
            </select>
        </div>
        <div>
            标签（以,分割）：<input type="text" id="tags"/>
        </div>
        <div style="margin-top: 10px;">
            <input type="button"  style="border:none;width: 50px;height: 30px;" id="btnAddArticle" value="增加"/>
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
<script>
    CKEDITOR.replace('content', {toolbar: 'Basic', width: '100%', height: '300px'});
</script>
</body>
</html>
