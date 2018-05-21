<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<html>
<head>
    <title>成绩列表</title>
    <%@ include file="/WEB-INF/jsp/common/include.jsp" %>
    <script>
        function showMoney(obj) {
            console.log(obj);
            var v=$('#s'+obj).children('td');
            console.log(v)
            $('#aScore #name').text(v[0].innerText);
            $('#aScore #course_name').text(v[1].innerText);
            $('#aScore #address').text(v[2].innerText);
            $('#aScore #s_id').val(obj);
            if(v[3].innerText=='空') {
                $('#aScore #score').val(-1);
            }else{
                $('#aScore #score').val(v[3].innerText);
            }
            $('#aScore').show();
        }
    </script>
</head>
<body>
<div id="wrapper">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div id="aScore" style="display: none">
                <form role="form" action="${per}/saveScore" method="post">
                    <div class="form-group">
                        <label for="name">雇员名称:</label>
                        <span id="name">雇员名称</span>&nbsp;&nbsp;&nbsp;&nbsp;
                        <label for="course_name">课程名称:</label>
                        <span id="course_name">课程名称</span>&nbsp;&nbsp;&nbsp;&nbsp;
                        <label for="address">上课地点:</label>
                        <span id="address">上课地点</span>&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type='hidden' name='id' id='s_id'/>
                    </div>
                    <div class="form-group">
                        <label for="score">分数:</label>
                        <input type='text' name='score' id='score'/>
                    </div>
                    <button type="submit" class="btn btn-default">保存</button>
                </form>
                <hr>
            </div>
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
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${scoreList}" var="s">
            <tr id="s${s.id}">
                <td>${s.employee.name}</td>
                <td>${s.course.name}</td>
                <td>${s.course.address}</td>
                <td>
                    <c:choose>
                        <c:when test="${s.score>=0}">${s.score}</c:when>
                        <c:otherwise>空</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${s.score>=0}">
                            <a href="javascript:showMoney(${s.id})">修改</a>
                        </c:when>
                        <c:otherwise>
                            <a href="javascript:showMoney(${s.id})">给分</a>
                        </c:otherwise>
                    </c:choose>
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
