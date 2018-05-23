<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<html>
<head>
    <title>用户列表</title>
    <%@ include file="/WEB-INF/jsp/common/include.jsp" %>
    <script>
        function showCourse() {
            $('#uUser').show();
            $('#addBtn').hide();
        }
    </script>
</head>
<body>
<div id="wrapper">
    <div class="row" >
        <div class="col-md-10 col-md-offset-1">
            <button id="addBtn" class="btn btn-primary" onclick="showCourse()">新增</button>
        </div>
    </div>
    <div class="row" >
        <div class="col-md-10 col-md-offset-1">
            <div id="uUser" style="display: none">
                <form role="form" action="${per}/saveUser" method="post">
                    <div class="form-group">
                        <label for="username">用户名</label>
                        <input type="text"  name="username" id="username" placeholder="请输入用户名">
                    </div>
                    <div class="form-group">
                        <label for="name">真实姓名</label>
                        <input type="text"  name="name" id="name" placeholder="请输入真实姓名">
                    </div>
                    <div class="form-group">
                        <label for="sex">性别</label>
                        <select name="sex" id="sex" style=" height: 30px;">
                            <option value="0" selected>男</option>
                            <option value="1">女</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="role">角色</label>
                        <select name="role" id="role" style=" height: 30px;">
                            <option value="employee" selected>雇员</option>
                            <option value="teacher">老师</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </div>
        </div>
    </div>
    <div class="row" >
        <div class="col-md-4 col-md-offset-1">
            <table class="table table-striped">
            <caption>雇员列表</caption>
            <thead>
            <tr>
                <th>用户名</th>
                <th>真实姓名</th>
                <th>性别</th>
                <th>角色</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userList}" var="u">
            <tr id="u${u.id}">
                <td>${u.username}</td>
                <td>${u.name}</td>
                <td>
                    <c:choose>
                        <c:when test="${u.sex==0}">
                            男
                        </c:when>
                        <c:otherwise>
                            女
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>雇员</td>
                <td>
                    <a href="${per}/deleteUser?id=${u.id}&role=employee" style="color: red;">删除</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
        <div class="col-md-4 col-md-offset-2">
            <table class="table table-striped">
            <caption>教师列表</caption>
            <thead>
            <tr>
                <th>用户名</th>
                <th>真实姓名</th>
                <th>性别</th>
                <th>角色</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tuserList}" var="u">
            <tr id="u${u.id}">
                <td>${u.username}</td>
                <td>${u.name}</td>
                <td>
                    <c:choose>
                    <c:when test="${u.sex==0}">
                        男
                    </c:when>
                    <c:otherwise>
                        女
                    </c:otherwise>
                    </c:choose>
                </td>
                <td>教师</td>
                <td>
                    <a href="${per}/deleteUser?id=${u.id}&role=teacher" style="color: red;">删除</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
    </div>
</div>
</body>
</html>
