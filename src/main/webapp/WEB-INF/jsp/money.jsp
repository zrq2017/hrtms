<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<html>
<head>
    <title>课程列表</title>
    <%@ include file="/WEB-INF/jsp/common/include.jsp" %>
    <script>
        function showMoney(obj) {
            console.log(obj);
            var v=$('#m'+obj).children('td');
            console.log(v)
            $('#uMoney #name').text(v[0].innerText);
            $('#uMoney #time').text(v[1].innerText);
            $('#uMoney #address').text(v[2].innerText);
            $('#uMoney #teacher').text(v[3].innerText);
            $('#uMoney #m_id').val(obj);
            if(v[4].innerText=='空') {
                $('#uMoney #price').val(-1);
            }else{
                $('#uMoney #price').val(v[4].innerText);
            }
            $('#uMoney').show();
        }
    </script>
</head>
<body>
<div id="wrapper">
    <div class="row" >
        <div class="col-md-10 col-md-offset-1">
            <div id="aScore">
                <form class="form-inline" role="form" action="${per}/money" method="post">
                    <div class="form-group">
                        <label for="id">课程名称:</label>
                        <select class="form-control" id="id" name="course.id">
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
            <div id="uMoney" style="display: none">
                <form role="form" action="${per}/saveMoney" method="post">
                    <div class="form-group">
                        <label for="name">课程名称:</label>
                        <span id="name">课程名称</span>&nbsp;&nbsp;&nbsp;&nbsp;
                        <label for="time">课程时间:</label>
                        <span id="time">课程时间</span>&nbsp;&nbsp;&nbsp;&nbsp;
                    </div>
                    <div class="form-group">
                        <label for="address">上课地点:</label>
                        <span id="address">上课地点</span>&nbsp;&nbsp;&nbsp;&nbsp;
                        <label for="teacher">授课老师:</label>
                        <span id="teacher">授课老师</span>&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type='hidden' name='id' id='m_id'/>
                    </div>
                    <div class="form-group">
                        <label for="price">薪资（￥元）:</label>
                        <input type='text' name='price' id='price'/>
                    </div>
                    <button type="submit" class="btn btn-default">保存</button>
                </form>
            </div>
        </div>
    </div>
    <div class="row" >
        <div class="col-md-10 col-md-offset-1">
            <table class="table table-striped">
            <caption>薪酬列表</caption>
            <thead>
            <tr>
                <th>课程名称</th>
                <th>课程时间</th>
                <th>上课地点</th>
                <th>授课老师</th>
                <th>薪酬（￥元）</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${moneyList}" var="c">
            <tr id="m${c.id}">
                <td>${c.course.name}</td>
                <td>
                    <fmt:formatDate value="${c.course.time}" pattern="yyyy-MM-dd HH:mm"/>
                </td>
                <td>${c.course.address}</td>
                <td>${c.teacher.name}</td>
                <td>
                    <c:choose>
                        <c:when test="${c.price>=0}">${c.price}</c:when>
                        <c:otherwise>空</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${c.price>=0}">
                            <a href="javascript:showMoney(${c.id})">修改</a>
                        </c:when>
                        <c:otherwise>
                            <a href="javascript:showMoney(${c.id})">添加</a>
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
