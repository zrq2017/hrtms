<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<link rel="stylesheet" href="${basePath}/css/login.css ">
<body>
<div class="container">
	<div class="login-container">
		<div class="title">登录</div>
		<form action="checkLogin" method="post">

			<p>用户名：</p><input type="text" class="username" name="userName" placeholder="用户名"><p/>


			<p>密 码：<input type="password" class="password" name="passWord" placeholder="密码"></p>

			<p><button class="submit">登录</button></p>
		</form>
	</div>
</div>

</body>