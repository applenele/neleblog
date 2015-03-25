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
    <script src="<%=path%>/scripts/moment.js"></script>
    <script src="<%=path%>/scripts/side.js"></script>
    <link rel="stylesheet" href="<%=path%>/styles/index.css"/>
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
    <h2 class="title_tj"><p>文章推荐</p></h2>
    <div class="main">
        <h3>${article.title}</h3>
        <div class="article_content">
            ${article.content}
        </div>
        <div class="article_footer">
            <div class="ptime">Publish On ${article.ptime}</div>
            <div class="article_tags">
               <c:forEach var="item" items="${article.tags}">
                  <span class="article_tag">${item.content}</span>
               </c:forEach>
            </div>
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
