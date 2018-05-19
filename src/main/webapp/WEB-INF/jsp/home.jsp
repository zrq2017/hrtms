<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="人力资源管理平台" />
    <title>人力资源管理平台</title>
    <link type="text/css" rel="stylesheet" href="<%=path%>/bootstrap/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/css.css" />
</head>
<frameset rows="50px,*" border="0">
    <frame name="header" src="common/header" border="0"
            frameborder="no" target="mainbody"  scrolling="no"/>
    <frameset cols="241px,*">
        <frame name="leftbar" frameborder="no" src="common/leftbar" scrolling="no"/>
        <frame name="mainbody" frameborder="no" src="common/mainbody"/>
    </frameset>
    <%--<div class="footer"></div>--%>
</frameset>
</html>