<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<html>
<head>
    <title>课程列表</title>
    <%@ include file="/WEB-INF/jsp/common/include.jsp" %>
</head>
<body>
<div id="wrapper">
    <div class="row" >
        <div class="col-md-10 col-md-offset-1">
            <table class="table table-striped">
                <caption>课程列表</caption>
                <thead>
                <tr>
                    <th>课程名称</th>
                    <th>课程时间</th>
                    <th>上课地点</th>
                    <th>简介</th>
                    <th>授课老师</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${courseList}" var="c">
                <tr id="c${c.id}">
                    <td>${c.name}</td>
                    <td>
                        <fmt:formatDate value="${c.time}" pattern="MM/dd/yyyy HH:mm"/>
                    </td>
                    <td>${c.address}</td>
                    <td>${c.describle}</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty c.teacher}">
                                ${c.teacher.name}
                            </c:when>
                            <c:otherwise>
                                无
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:if test="${empty c.teacher}">
                        <a href="${per}/chooseCourse?id=${c.id}">授课</a>
                        </c:if>
                        <c:if test="${c.teacher.id==sessionScope.User.id}">
                        <a href="${per}/deleteCourse?id=${c.id}" style="color: red;">取消授课</a>
                        </c:if>
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
