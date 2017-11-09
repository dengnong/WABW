<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 杨宗悦
  Date: 2017/3/21
  Time: 0:33
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
<nav class="navbar navbar-default navbar-blue navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><strong>医疗管理系统</strong></a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <div>
                <ul class="nav navbar-nav">
                    <li class="<%=index%>"><a href="/doctor/home">首页</a></li>


                </ul>
            </div>
            <c:choose>
                <c:when test='${null != username && !username.equals("")}'>
                    <%--<a class="btn btn-outline-danger float-lg-right" href="/logout">登出</a>--%>
                    <div class="pull-right">
                        <div class="martop8">
                            <a href="/logout"><button type="button" class="btn  btn-danger pull-right">注销</button></a>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <%--<a class="btn btn-outline-primary float-lg-right" href="/login">登录</a>--%>
                    <div class="pull-right">
                        <div class="martop8">
                            <a href="/login"><button type="button" class="btn  btn-danger pull-right">登陆</button></a>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>

        </div>
    </div>

</nav>





<!-- Javascripts -->
<script src="/resources/jQuery/jquery-3.1.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/resources/Bootstrap/js/bootstrap.min.js"></script>
</html>

