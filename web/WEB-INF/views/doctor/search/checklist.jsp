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
<jsp:include page="../../component/navbar.jsp" flush="true">
    <jsp:param name="pages" value="checklist"/>
</jsp:include>
<!—自适应布局-->
<div class="container">
    <div class="row">
        <!—左侧导航栏-->
        <jsp:include page="../../search/sidebar.jsp" flush="true">
            <jsp:param name="pages" value="checklist"/>
        </jsp:include>
        <!—右侧管理控制台-->
        <div class="main">

                <sf:form  method="POST" name="searchCheckList" onsubmit="return validate_checklist(this);">
                        <div class="col-xs-2">
                            <select name="examClass" id="examClass" class="form-control">
                                <option value=""><c:out value="-检查项-" /></option>
                                　　<c:forEach items="${checkItems}" var="checkItem">
                                　　　　<option value="${checkItem.examclass}">${checkItem.examclass}</option>
                            </c:forEach>
                            </select>
                        </div>

                            <%--<a id="add" onclick="addSelect('select-container');">增加查询条件</a>--%>
                        <div class="row">
                            <a class="btn btn-default" id="add" role="button" onclick="addSelect('select-container');">增加查询条件</a>
                            <button class="btn btn-default" type="submit">Submit</button>
                            <div class="pull-right">
                                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">
                                    历史搜索
                                </button>
                            </div>
                        </div>
                        <div id="select-container" >
                        </div>
                </sf:form>
        </div>

        <table class=" table table-striped table-bordered table-hover ">
            <tr>
                <th>patientID</th>
                <th>patientSex</th>
                <th>patientBirth</th>
                <th>Check List</th>
                <th>检查子类</th>
                <th>前期诊断</th>
                <th>详细描述</th>
                <th>Check List5</th>
                <th>确诊病状</th>
                <th>Check List7</th>
                <th>Check List8</th>
                <th>Check List9</th>
                <th>Check List10</th>
                <th>Check List11</th>
                <th>Check List12</th>
                <th>Check List13</th>
                <th>缴费类型</th>
                <th>Check List15</th>
                <th>Check List16</th>
            </tr>

            <c:forEach items="${patientExams}" var="patientExam">
                <tr>
                    <td>${patientExam.patient.patientId}</td>
                    <td>${patientExam.patient.sex}</td>
                    <td>${patientExam.patient.dateOfBirth}</td>
                    <td>${patientExam.checklist.visitId}</td>
                    <td>${patientExam.checklist.examsubClass}</td>
                    <td>${patientExam.checklist.clinicSymptom}</td>
                    <td>${patientExam.checklist.physicSign}</td>
                    <td>${patientExam.checklist.relevantDiag}</td>
                    <td>${patientExam.checklist.clinicDiag}</td>
                    <td>${patientExam.checklist.performedby}</td>
                    <td>${patientExam.checklist.patientsource}</td>
                    <td>${patientExam.checklist.requestDateTime}</td>
                    <td>${patientExam.checklist.requestDept}</td>
                    <td>${patientExam.checklist.scheduledDateTime}</td>
                    <td>${patientExam.checklist.notice}</td>
                    <td>${patientExam.checklist.resultStatus}</td>
                    <td>${patientExam.checklist.chargeIndicator}</td>
                    <td>${patientExam.checklist.chargeType}</td>
                    <td>${patientExam.checklist.realReportDateTime}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">最近搜索历史</h4>
            </div>
            <div>
                <table class=" table table-striped table-bordered table-hover" >
                    <tr>
                        <th >1</th>
                        <th>2</th>
                        <th>3</th>
                    </tr>
                    <%--<c:forEach items="" var="">--%>
                        <tr>
                            <td>a</td>
                            <td>a</td>
                            <td>a</td>
                        </tr>
                    <%--</c:forEach>--%>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script>

    function dateGenerate() {
        var date = new Date(), dateArray = new Array(), i;
        curYear = date.getFullYear();

        dateArray[0]="并含";
        dateArray[1]="并或";
        dateArray[2]="不含";
        return dateArray;
    }
    var tem=0;
    var inputtem=0;
    function addSelect(divname) {
        tem++;
        inputtem++;
        var newDiv=document.createElement('div');
        var html = '<select   name=item'+tem+' >', dates = dateGenerate(), i;
        for(i = 0; i < dates.length; i++) {
            html += "<option value='"+dates[i]+"'>"+dates[i]+"</option>";
        }
        html += '</select>-<input  name=input'+inputtem+' required="required">';
        html += '<a href="#" onclick="delSelect(this.parentNode)">X</a>';
        newDiv.innerHTML= html;
        document.getElementById(divname).appendChild(newDiv);
    }

    function delSelect(_element) {
        var _parentElement = _element.parentNode;
        if(_parentElement){
            _parentElement.removeChild(_element);
        }

    }

    function submitSelect(){
        var forms1 = document.submitSelect;
        forms1.submit();//form表单提交
    }

</script>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/resources/jQuery/jquery-3.1.1.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/resources/Bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/checkScript/inputCheck.js"></script>

</body>
</html>
