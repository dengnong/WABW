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
<jsp:include page="../component/navbar.jsp" flush="true">
    <jsp:param name="pages" value="checklist"/>
</jsp:include>
<!—自适应布局-->
<div class="container-fluid">
    <div class="row">
        <!—左侧导航栏-->
        <jsp:include page="sidebar.jsp" flush="true">
            <jsp:param name="pages" value="checklist"/>
        </jsp:include>
        <!—右侧管理控制台-->

        <div class="main">
            <table class="">
                <tr>
                    <th>Check List</th>
                    <th>Check List2</th>
                    <th>Check List3</th>
                    <th>Check List4</th>
                    <th>Check List5</th>
                    <th>Check List6</th>
                    <th>Check List7</th>
                    <th>Check List8</th>
                    <th>Check List9</th>
                    <th>Check List10</th>
                    <th>Check List11</th>
                    <th>Check List12</th>
                    <th>Check List13</th>
                    <th>Check List14</th>
                    <th>Check List15</th>
                    <th>Check List16</th>
                    <th>Check List17</th>
                    <th>Check List18</th>


                </tr>

                <c:forEach items="${checklist}" var="patientExam">
                    <tr>
                        <td>${ patientExam.checklist.examNo}</td>
                        <td>${ patientExam.checklist.patientId}</td>
                        <td>${ patientExam.checklist.visitId}</td>
                        <td>${ patientExam.checklist.examsubClass}</td>
                        <td>${ patientExam.checklist.clinicSymptom}</td>
                        <td>${ patientExam.checklist.physicSign}</td>
                        <td>${ patientExam.checklist.relevantDiag}</td>
                        <td>${ patientExam.checklist.clinicDiag}</td>
                        <td>${ patientExam.checklist.performedby}</td>
                        <td>${ patientExam.checklist.patientsource}</td>
                        <td>${ patientExam.checklist.requestDateTime}</td>
                        <td>${ patientExam.checklist.requestDept}</td>
                        <td>${ patientExam.checklist.scheduledDateTime}</td>
                        <td>${ patientExam.checklist.notice}</td>
                        <td>${ patientExam.checklist.resultStatus}</td>
                        <td>${ patientExam.checklist.chargeIndicator}</td>
                        <td>${ patientExam.checklist.chargeType}</td>
                        <td>${ patientExam.checklist.realReportDateTime}</td>

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
