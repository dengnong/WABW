<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--Just Demo--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Title</title>

    <!-- Bootstrap -->
    <link href="/resources/Bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<jsp:include page="../component/navbar.jsp" flush="true">
    <jsp:param name="pages" value="checklist"/>
</jsp:include>

<div class="container-fluid">
    <div class="row">
        <!—左侧导航栏-->
        <jsp:include page="sidebar.jsp" flush="true">
            <jsp:param name="pages" value="checklist"/>
        </jsp:include>
        <!—右侧管理控制台-->

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="panel panel-default">
                <div class="panel-heading">
                    <sf:form method="POST">
                    性别：<select name="choseSex">
                        <option value="">- 不限 -</option>
                        <option value="男">- 男性 -</option>
                        <option value="女">- 女性 -</option>
                    </select>

                    年龄段：<input type="text" name="min" value=""> —
                    <input type="text" name="max" value="">


                    科室：<select name="selectLevel">
                        <option value=""><c:out value="- 不限 -" /></option>
                        　　<c:forEach items="${departments}" var="department">
                        　　　　<option value="${department.departmentName}">${department.departmentName}</option>
                        </c:forEach>
                    </select>
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit">Submit</button>
                    </span>
                    </sf:form>
                </div>

            </div>
        </div>
    </div>
</div>



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/resources/jQuery/jquery-3.1.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/resources/Bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
