<%--
  Created by IntelliJ IDEA.
  User: 杨宗悦
  Date: 2017/3/21
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html class='no-js' lang='en'>
<head>
    <meta charset='utf-8'>
    <meta content='IE=edge,chrome=1' http-equiv='X-UA-Compatible'>
    <meta content='lab2023' name='author'>
    <meta content='' name='description'>
    <meta content='' name='keywords'>
    <link href="/resources/Bycss/stylesheets/application-a07755f5.css" rel="stylesheet" type="text/css" />
    <link href="/resources/Bycss/images/favicon.ico" rel="icon" type="image/ico" />
    <link href="/resources/Bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/YangResetCSS/reset.css" rel="stylesheet">
</head>
<%
    String pages="0";
    if (request.getParameter("pages").equals("0")){
        pages="";
    }
    else {
        pages=request.getParameter("pages");
    }
    String index="";
    String function="";
    String function1="";
    String function2="";
    String function3="";
    String function4="";
    String help="";
    if (pages.equals("index")){
        index="active";
    }
    else if (pages.equals("checklist")){
        function="active";
        function1="active";
    }
    else if (pages.equals("xxx")){
        help="active";
    }
    else if (pages.equals("xxx")){
        function="active";
        function2="active";
    }
    else if (pages.equals("xxx")){
        function="active";
        function3="active";
    }else if (pages.equals("xxx")){
        function="active";
        function4="active";
    }

%>
<%--<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">--%>
    <%--<ul class="nav nav-sidebar">--%>
        <%--<li class="<%= index%>"><a href="#">首页</a></li>--%>
    <%--</ul>--%>
    <%--<ul class="nav nav-sidebar">--%>
        <%--<li class="<%= function1%>"><a href="#">病例查询</a></li>--%>
        <%--<li class="<%= function2%>"><a href="#">我的病例</a></li>--%>
        <%--<li ><a href="#"></a></li>--%>
    <%--</ul>--%>
    <%--<ul class="nav nav-sidebar">--%>
        <%--<li class="<%= function3%>"><a href="#">设置</a></li>--%>
        <%--<li class="<%= help%>"><a href="#">帮助</a></li>--%>
    <%--</ul>--%>
<%--</div>--%>


<div class="hr_40"></div>


<!-- Javascripts -->
<script src="/resources/jQuery/jquery-3.1.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/resources/Bootstrap/js/bootstrap.min.js"></script>
</html>

