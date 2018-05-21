<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<html>
<head>
    <title>课程列表</title>
    <%@ include file="/WEB-INF/jsp/common/include.jsp" %>
    <script>
        function showCourse(obj) {
            console.log(obj);
            if(obj!=null&&obj!=undefined){
                var v=$('#c'+obj).children('td');
                console.log(v)
                $('#name').val(v[0].innerText);
                $('#time').val(v[1].innerText);
                $('#address').val(v[2].innerText);
                $('#describle').val(v[3].innerText);
                $('#uCourse form').append("<input type='hidden' name='id' id='id' value='"+obj+"'/>");
            }
            $('#uCourse').show();
            $('#addBtn').hide();
        }
    </script>
</head>
<body>
<div id="wrapper">
    <div class="row" >
        <div class="col-md-10 col-md-offset-1">
            <table class="table table-striped">
            <caption>课程列表</caption>
            <thead>
            <tr>
                <th colspan="6">${msg}</th>
            </tr>
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
            <c:if test="${courseList!=null}">
            <c:forEach items="${courseList}" var="c">
            <tr id="c${c.id}">
                <td>${c.name}</td>
                <td>
                    <fmt:formatDate value="${c.time}" pattern="MM/dd/yyyy HH:mm"/>
                </td>
                <td>${c.address}</td>
                <td>${c.describle}</td>
                <td>${c.teacher.name}</td>
                <td><a href="${per}/addCourse?id=${c.id}">报名</a></td>
            </tr>
            </c:forEach>
            </c:if>
            <c:if test="${scoreList!=null}">
            <c:forEach items="${scoreList}" var="s">
                <tr id="s${s.id}">
                    <td>${s.course.name}</td>
                    <td>
                        <fmt:formatDate value="${s.course.time}" pattern="MM/dd/yyyy HH:mm"/>
                    </td>
                    <td>${s.course.address}</td>
                    <td>${s.course.describle}</td>
                    <td>${s.course.teacher.name}</td>
                    <td>
                        <c:if test="${s.score>=0}">
                            无
                        </c:if>
                        <c:if test="${s.score<0}">
                            <a href="${per}/deleteCourse?id=${s.id}">取消报名</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </c:if>
            </tbody>
        </table>
        </div>
    </div>
</div>
</body>
</html>
