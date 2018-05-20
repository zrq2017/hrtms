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
            <button id="addBtn" class="btn btn-primary" onclick="showCourse()">新增</button>
        </div>
    </div>
    <div class="row" >
        <div class="col-md-10 col-md-offset-1">
            <div id="uCourse" style="display: none">
                <form role="form" action="${per}/saveCourse" method="post">
                    <div class="form-group">
                        <label for="name">课程名称</label>
                        <input type="text" class="form-control" name="name" id="name" placeholder="请输入课程名称">
                    </div>
                    <div class="form-group">
                        <label for="time">课程时间</label>
                        <input type="text" class="form-control" name="time" id="time" placeholder="请输入课程时间">
                    </div>
                    <div class="form-group">
                        <label for="address">上课地点</label>
                        <input type="text" class="form-control" name="address" id="address" placeholder="请输入上课地点">
                    </div>
                    <div class="form-group">
                        <label for="describle">简介</label>
                        <input type="text" class="form-control" name="describle" id="describle" placeholder="请输入简介">
                    </div>
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </div>
        </div>
    </div>
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
                <td>${c.teacher.name}</td>
                <td>
                    <a href="javascript:showCourse(${c.id})">修改</a>
                    <a href="${per}/deleteCourse?id=${c.id}" style="color: red;">删除</a>
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
