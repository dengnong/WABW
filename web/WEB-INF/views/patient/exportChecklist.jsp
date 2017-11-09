<%--
  Created by IntelliJ IDEA.
  User: 54472
  Date: 2017/4/7
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
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
    <title>down</title>

    <link href="/resources/Bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <center><p>下载文件...</p></center>
    <div id="byt" style="display: none;">
        <table class="table table-bordered">
            <tr>
                <th>检查单号</th>
                <th>检查子类</th>
                <th>临床症状</th>
                <th>体征表现</th>
                <th>临床诊断</th>
                <th>检查医师</th>
                <th>申请时间</th>
                <th>费用指标</th>
                <th>缴费方式</th>
                <th>出单时间</th>
                <th>医生建议</th>
            </tr>
            <c:forEach items="${checklists}" var="checklist">
                <tr>
                    <td>${checklist.examNo}</td>
                    <td>${checklist.examsubClass}</td>
                    <td>${checklist.clinicSymptom}</td>
                    <td>${checklist.physicSign}</td>
                    <td>${checklist.clinicDiag}</td>
                    <td>${checklist.requestDateTime}</td>
                    <td>${checklist.chargeIndicator}</td>
                    <td>${checklist.scheduledDateTime}</td>
                    <td>${checklist.chargeType}</td>
                    <td>${checklist.realReportDateTime}</td>
                    <td>${checklist.notice}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/resources/jQuery/jquery-3.1.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/resources/Bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/checkScript/FileSaver.min.js"></script>
<script src="/resources/checkScript/Blob.js"></script>

<script >
    window.onload = function() {
        $(function () {
            $(document).ready(function () {
                var blob = new Blob([document.getElementById('byt').innerHTML], {
                    type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
                });
                var strFile = "Report.xls";
                saveAs(blob, strFile);
                return false;
            });
        });
    }
</script>
</body>
</html>
