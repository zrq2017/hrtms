<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<html>
<head>
    <title>个人信息</title>
    <%@ include file="/WEB-INF/jsp/common/include.jsp" %>
    <script>
        function showEdit() {
            $('#name').removeAttr("disabled");
            $('#username').removeAttr("disabled");
            $('#sex').removeAttr("disabled");
            $('#year').removeAttr("disabled");
            $('#saveBtn').show();
            $('#updateBtn').hide();
        }
    </script>
</head>
<body>
<div id="wrapper">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="${ctx}/saveInfo" method="post">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th colspan="2" align="center">个人信息表</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>姓名</td>
                        <td>
                            <input type="text"  name="name" id="name" value="${sessionScope.User.name}" disabled/>
                        </td>
                    </tr>
                    <tr>
                        <td>用户名</td>
                        <td>
                            <input type="text"  name="username" id="username" value="${sessionScope.User.username}" disabled/>
                        </td>
                    </tr>
                    <tr>
                        <td>性别</td>
                        <td>
                            <select name="sex" id="sex"  value="${sessionScope.User.sex}" disabled style=" height: 30px;">
                                <c:if test="${sessionScope.User.sex==0}">
                                    <option value="0" selected>男</option>
                                    <option value="1">女</option>
                                </c:if>
                                <c:if test="${sessionScope.User.sex==1}">
                                    <option value="0">男</option>
                                    <option value="1" selected>女</option>
                                </c:if>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>年龄</td>
                        <td>
                            <input type="text"  name="year" id="year" value="${sessionScope.User.year}" disabled/>
                            <input type="hidden" name="id" id="id" value="${sessionScope.User.id}">
                        </td>
                    </tr>
                    </tbody>
                </table>
                <button type="button" class="btn btn-warning" id="updateBtn" onclick="showEdit()">修改</button>
                <button type="submit" class="btn btn-primary" id="saveBtn" style="display: none">保存</button>
            </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
