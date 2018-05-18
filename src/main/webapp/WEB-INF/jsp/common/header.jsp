<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<html>
<head>
    <title>头部</title>
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/css.css" />
</head>
<body>
<div class="header">
    <div class="top"> <img class="logo" src="<%=path%>/images/logo.jpg" />
        <ul class="nav">
            <li class="seleli"><a href="#">首页</a></li>
            <li><a href="<%=path%>/employee/login" target="mainbody">个人中心</a></li>
            <li><a href="<%=path%>/hello" target="mainbody">绩效管理</a></li>
            <li><a href="#" target="mainbody">人事管理</a></li>
            <li><a href="#" target="mainbody">薪酬管理</a></li>
        </ul>
    </div>
</div>
</body>
</html>
