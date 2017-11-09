<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<jsp:include page="../../component/navbar.jsp" flush="true">
    <jsp:param name="pages" value="checklist"/>
</jsp:include>

<div class="container">
    <div class="row">
        <!—左侧导航栏-->
        <jsp:include page="../../search/sidebar.jsp" flush="true">
            <jsp:param name="pages" value="checklist"/>
        </jsp:include>
        <!—右侧管理控制台-->

        <div class="main">

            <table class="table table-hover">
                <tr>
                    <th>检验项目编号</th>
                    <th>检验项目名称</th>
                </tr>

                <c:forEach items="${testItems}" var="testItem">
                    <tr>
                        <td>${testItem.itemCode}</td>
                        <td>${testItem.itemName}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/resources/jQuery/jquery-3.1.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/resources/Bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
