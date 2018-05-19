<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<html>
<head>
    <title>左侧导航</title>
    <link type="text/css" rel="stylesheet" href="<%=path%>/bootstrap/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/css.css" />
</head>
<body>
<div class="leftbar">
    <div class="lm01"> <img class="peptx" src="<%=path%>/images/tximg.jpg" />
        <div class="pepdet">
            <p class="pepname"><c:out value="${sessionScope.User.username}"/></p>
            <p><c:out value="${sessionScope.User.name}"/></p>
            <p><button class="btn btn-primary" onclick="logout()">注销</button></p>
            <script>
                function logout() {
                    window.top.location.href="<%=path%>/logout"
                }
            </script>
        </div>
        <div class="clear"></div>
    </div>
    <div class="lm02">
        <div class="title"><img class="icon" src="<%=path%>/images/dataicon.jpg" />
            <h2>日历</h2>
        </div>
        <div class="detail"> <img class="" src="<%=path%>/images/kj_01.jpg" /> </div>
    </div>
    <div class="lm03">
        <div class="title"><img style="padding-right:5px;" class="icon" src="<%=path%>/images/weaicon.jpg" />
            <h2>天气</h2>
        </div>
        <div class="detail"> <img class="" style="width:212px;height:170px;" src="<%=path%>/images/kj_02.jpg" /> </div>
    </div>
</div>
</body>
</html>
