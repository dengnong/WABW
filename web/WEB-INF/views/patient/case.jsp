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

<div class="container">

    <div class="row">
        <!—左侧导航栏-->
        <jsp:include page="../search/sidebar.jsp" flush="true">
            <jsp:param name="pages" value="checklist"/>
        </jsp:include>
        <div class="pull-right">
            <a href="/doctor/exportChecklist/${patient.patientId}" target="_blank"><button type="button"  class="btn btn-lg btn-success">导出所有检查清单</button></a>
        </div>
        <table class="table table-bordered">
            <caption>病人信息</caption>
            <tr>
                <td>病人ID：${patient.patientId}</td>
                <td>出生日期：${patient.dateOfBirth}</td>
                <td>性别：${patient.sex}</td>
            </tr>
        </table>

        <c:forEach items="${checklists}" var="checklist">
            <table class="table table-bordered">
                <caption>检查清单 ${checklists.indexOf(checklist)+1} / ${checklists.size()}</caption>
                <tr>
                    <td colspan="2">检查单号：${checklist.examNo}</td>
                    <td colspan="2">检查子类：${checklist.examsubClass}</td>
                </tr>
                <tr>
                    <td colspan="4">临床症状：${checklist.clinicSymptom}</td>
                </tr>
                <tr>
                    <td colspan="4">体征表现：${checklist.physicSign}</td>
                </tr>
                <tr>
                    <td colspan="4">临床诊断：${checklist.clinicDiag}</td>
                </tr>
                <tr>
                    <td colspan="2">检查医师：</td>
                    <td colspan="2">申请时间：${checklist.requestDateTime}</td>
                </tr>
                <tr>
                    <td colspan="2">费用指标：${checklist.chargeIndicator}</td>
                    <td colspan="2">安排时间：${checklist.scheduledDateTime}</td>
                </tr>
                <tr>
                    <td colspan="2">缴费方式：${checklist.chargeType}</td>
                    <td colspan="2">出单时间：${checklist.realReportDateTime}</td>
                </tr>
                <tr>
                    <td colspan="4">健康提醒：${checklist.notice}</td>
                </tr>
            </table>
        </c:forEach>

        <c:forEach items="${testLists}" var="testList">
            <table class="table table-bordered">
                <caption>检验清单 ${testLists.indexOf(testList)+1} / ${testLists.size()}</caption>
                <tr>
                    <td colspan="2">检验单号：${testList.testNo}</td>
                    <td colspan="2">临床诊断：${testList.relevantClincDiag}</td>
                </tr>
                <tr>
                    <td colspan="2">检验样本：${testList.specimen}</td>
                    <td colspan="2">项目编号：</td>
                </tr>

                <tr>
                    <td colspan="2">检查时间：${testList.requestdDateTime}</td>
                    <td colspan="2">取样时间：${testList.pecmSampleDateTime}</td>
                </tr>
                <tr>
                    <td colspan="2">检查状态：${testList.resultStatus}</td>
                    <td colspan="2">出单时间：${testList.resultRptDateTime}</td>
                </tr>
                <tr>
                    <td>门诊编号：${testList.orderingDept}</td>
                    <td>主治医师：${testList.orderProvider}</td>
                    <td>记录人员：${testList.transcriptionist}</td>
                    <td>验证签字：${testList.verifiedBy}</td>
                </tr>
            </table>
        </c:forEach>
    </div>
</div>

<%--<script>--%>
    <%--$(function () {--%>
        <%--$('Button').click(function () {--%>
            <%--var blob = new Blob([document.getElementById('tab').innerHTML], {--%>
                <%--type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"--%>
            <%--});--%>
            <%--var strFile = "Report.xls";--%>
            <%--saveAs(blob, strFile);--%>
            <%--return false;--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/resources/jQuery/jquery-3.1.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/resources/Bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/checkScript/FileSaver.min.js"></script>
<script src="/resources/checkScript/Blob.js"></script>
</body>
</html>

