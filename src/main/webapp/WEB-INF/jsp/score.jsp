<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<html>
<head>
    <title>成绩列表</title>
    <%@ include file="/WEB-INF/jsp/common/include.jsp" %>
</head>
<body>
<div id="wrapper">
    <div class="row" >
        <div class="col-md-10 col-md-offset-1">
            <div id="aScore">
                <form class="form-inline" role="form" action="${per}/score" method="post">
                    <div class="form-group">
                        <label for="id">课程名称:</label>
                        <select class="form-control" id="id" name="id">
                            <option value="">全部</option>
                            <c:forEach items="${courseList}" var="c">
                                <option value="${c.id}">${c.name}</option>
                            </c:forEach>
                        </select>
                        <button type="submit" class="btn  btn-primary">查询</button>
                    </div>
                </form>
            </div>
            <hr>
        </div>
    </div>
    <div class="row" >
        <div class="col-md-10 col-md-offset-1">
            <table class="table table-striped">
            <caption>成绩列表</caption>
            <thead>
            <tr>
                <th>雇员名称</th>
                <th>课程名称</th>
                <th>培训地点</th>
                <th>成绩</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${scoreList}" var="s">
            <tr id="s${s.id}">
                <td>${s.employee.name}</td>
                <td>${s.course.name}</td>
                <td>${s.course.address}</td>
                <td>${s.score}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
    </div>
</div>
</body>
</html>
