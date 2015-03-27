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
    <script src="scripts/jquery-1.11.2.min.js"></script>
    <script src="scripts/moment.js"></script>
    <script src="scripts/side.js"></script>
    <script src="scripts/index.js"></script>
    <link rel="stylesheet" href="styles/index.css"/>
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

       <c:if test="${user!=null}">
           <div class="side">
               <div><a href="addArticel.jsp">发表帖子</a></div>
           </div>
       </c:if>
    </div>
    <div style="clear:both"></div>
</div>
<div class="footer">
    <div>Copyright © 2015 nele
    </div>
</div>
</body>
</html>
