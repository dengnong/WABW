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
    <title>Forms</title>
    <meta content='lab2023' name='author'>
    <meta content='' name='description'>
    <meta content='' name='keywords'>
    <link href="/resources/Bycss/stylesheets/application-a07755f5.css" rel="stylesheet" type="text/css" />

    
  </head>
  <body class='main page'>
    <!-- Navbar -->
    <div class='navbar navbar-default' id='navbar'>
      <a class='navbar-brand' href='admin_homepage.jsp'>
        <i class='icon-beer'></i>
       Patient management system
      </a>
      <ul class='nav navbar-nav pull-right'>
        <li class='dropdown'>
          <a class='dropdown-toggle' data-toggle='dropdown' href='#'>
            <i class='icon-envelope'></i>用户ID<b class='caret'></b></a>
      </li>
        <li>
          <a href='#'><i class='icon-cog'></i>退出</a>
        </li>
       
      </ul>
    </div>
    <div id='wrapper'>
      <!-- Sidebar -->
      <section id='sidebar'>
        <i class='icon-align-justify icon-large' id='toggle'></i>
      
            
            <a href="admin_id.jsp">Admin ID</a>
            <br /><br />
          
       
      
           
            <a href="doctor_id.jsp">医生账号</a>
            <br /><br />
          
            <a href="patient_id.jsp">患者账号</a>
            <br /><br />
         
      
     
      
     
        <div data-toggle='tooltip' id='beaker' title='Made by lab2023'></div>
  </section>
      <!-- Tools -->
      <section id='tools'>
        <ul class='breadcrumb' id='breadcrumb'>
          <li class='title'>Root超管主页</li>
     </ul>
       
      </section>
      <!-- Content -->

      <div id='content'>

            <div class='panel panel-default'>
          <div class='panel-heading'>
            <i class='icon-edit icon-large'></i>
           管理员操作指南及注意事项
          </div>
          <div class='panel-body text-center'>
          <tr>
          <td><font size="3" color="red">一些注意事项</font></td><br/>
          <td><font size="3" color="red">一些注意事项</font></td><br/>
          <td><font size="3" color="red">一些注意事项</font></td><br/>
          <td><font size="3" color="red">一些注意事项</font></td><br/>
          </tr>
          
       
          </div>
          
          
          
         
        </div>
      </div>
    </div>
    <!-- Footer -->
    <!-- Javascripts -->

  </body>
</html>
