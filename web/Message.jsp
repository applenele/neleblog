<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 15/3/21
  Time: 下午3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path=this.getServletConfig().getServletContext().getContextPath();
%>
<html>
<head>
    <title>neleblog - index</title>
    <script src="<%=path%>/scripts/jquery-1.11.2.min.js"></script>
    <script src="<%=path%>/scripts/ckeditor/ckeditor.js"></script>
    <script src="<%=path%>/scripts/moment.js"></script>
    <script src="<%=path%>/scripts/side.js"></script>
    <script src="<%=path%>/scripts/message.js"></script>
    <script src="<%=path%>/scripts/top.js"></script>
    <link rel="stylesheet" href="<%=path%>/styles/index.css"/>
</head>
<body>
<div class="top">
    <div class="nav">
        <ul class="nav_list">
            <li><a class="top_item" href="javascript:LoadByCategory('Daily')"><span>Daily</span><br/><span class="zh">生活</span></a></li>
            <li><a class="top_item" href="javascript:LoadByCategory('FrontEnd')"><span>FrontEnd</span><br/><span class="zh">前端</span></a></li>
            <li><a class="top_item" href="javascript:LoadByCategory('BackEnd')"><span>BackEnd</span><br/><span class="zh">后端</span></a></li>
            <li><a class="top_item" href="<%=path%>/message.jsp"><span>Message</span><br/><span class="zh">留言板</span></a></li>
            <li><a class="top_item" href="/"><span>About</span><br/><span class="zh">关于</span></a></li>
        </ul>
    </div>
</div>
<div class="banner">
</div>
<div class="container">
    <div class="main">

        <div class="message_form">
            <p>昵称：<input type="text" id="nickname" /></p>
            <p>内容<textarea name="content"></textarea></p>
            <p><input type="button" id="btnAddMessage" value="留言"></p>
        </div>

        <div class="message_list">

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
    CKEDITOR.replace('content',{toolbar:'Basic',width:'100%',height:'60px'});
</script>
</body>
</html>
