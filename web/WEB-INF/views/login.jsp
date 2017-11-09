<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MainasuK
  Date: 2017-3-5
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html class='no-js' lang='en'>
<head>
    <meta charset='utf-8'>
    <meta content='IE=edge,chrome=1' http-equiv='X-UA-Compatible'>
    <title>登录</title>
    <meta content='lab2023' name='author'>
    <meta content='' name='description'>
    <meta content='' name='keywords'>
    <link href="/resources/Bycss/stylesheets/application-a07755f5.css" rel="stylesheet" type="text/css" />
    <link href="/resources/Bycss/images/favicon.ico" rel="icon" type="image/ico" />
    <link href="/resources/Bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class='login'>

<div class='wrapper'>
    <div class='row'>
        <div class='col-lg-12'>
            <div class='brand text-center'>
                <h1>
                    <div class='logo-icon'>
                        <i class='icon-beer'></i></div>
                    <h3>
                        Patient management system
                    </h3>
                </h1>
            </div>
        </div>
    </div>
    <div class='row'>
        <div class='col-lg-12'>
           <sf:form method="post">
                <fieldset class='text-center'>
                    <legend><h5>Login to your account</h5></legend>
                    <div class='form-group'>
                        <input class='form-control' placeholder='账号' type='text' name="username">
                    </div>
                    <div class='form-group'>
                        <input class='form-control' placeholder='密码' type='password' name="password">
                    </div>
                    <div class='text-center'>
                        <div class='checkbox'>
                            <label>
                                <input type='checkbox'>
                                Remember me on this computer
                            </label>
                        </div>

                        <input class="btn btn-success" type="submit" value="登录">
                        <br/>
                        <br/>
                        <a href="forgot_password.jsp">忘记密码?</a>
                    </div>
                </fieldset>
               <c:if test="${null != param.error}">
                   <!-- Display error message -->
                   <small style="color: red">用户名或密码错误</small>
               </c:if>
               </sf:form>
        </div>
    </div>
</div>



<%--<div class="panel-heading">--%>
    <%--<c:if test='${null != username && "" != username}'>--%>
        <%--欢迎登陆，${username}--%>
    <%--</c:if>--%>
    <%--Heading--%>
<%--</div>--%>
<%--<div class="panel-body">--%>
    <%--Body--%>
<%--</div>--%>
<%--<div class="panel-footer">--%>
    <%--Footer--%>
<%--</div>--%>
<!-- Footer -->

<!-- Javascripts -->
<script src="/resources/jQuery/jquery-3.1.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/resources/Bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
