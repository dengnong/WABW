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
    <title>Forgot password</title>
    <meta content='lab2023' name='author'>
    <meta content='' name='description'>
    <meta content='' name='keywords'>
    <link href="/resources/Bycss/stylesheets/application-a07755f5.css" rel="stylesheet" type="text/css" />
    <link href="/resources/Bycss/images/favicon.ico" rel="icon" type="image/ico" />
    
  </head>
  <body class='login'>
    <div class='wrapper'>
      <div class='row'>
        <div class='col-lg-12'>
          <form>
            <fieldset>
              <legend>重置你的密码</legend>
            </fieldset>
            <div class='form-group'>
              <label class='control-label'>账号ID</label>
              <input class='form-control' placeholder='输入手机号码' type='text'>
               <label class='control-label'>身份证ID</label>
              <input class='form-control' placeholder='输入身份证号' type='text'>
               <label class='control-label'>姓名</label>
              <input class='form-control' placeholder='输入姓名' type='text'>
               <label class='control-label'>新密码</label>
              <input class='form-control' placeholder='输入新密码' type='text'>
               <label class='control-label'>确认密码</label>
              <input class='form-control' placeholder='再次输入新密码' type='text'>
            </div>
        <div align="center">
          <a class="btn btn-default" href="/">提交</a>
            <br />   <br />
          <a href="login.jsp">返回到主页</a>
            
          
        </div>
          </form>
        </div>
      </div>
    </div>
    <!-- Footer -->
    <!-- Javascripts -->
    
  </body>
</html>
