<%--
  Created by IntelliJ IDEA.
  User: MacBook
  Date: 17/3/24
  Time: 上午12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--Just Demo--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Title</title>
    <script src="/resources/checkScript/echarts.js"></script>
    <!-- Bootstrap -->
    <link href="/resources/Bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<c:set var="username" value="${username}" scope="session"/>
<jsp:include page="../component/navbar.jsp" flush="true">
    <jsp:param name="pages" value="checklist"/>
</jsp:include>
<!—自适应布局-->
<div class="container-fluid">
    <div class="row">
        <!—左侧导航栏-->
        <jsp:include page="../search/sidebar.jsp" flush="true">
            <jsp:param name="pages" value="checklist"/>
        </jsp:include>

        <div class="main">
            
            <p>
                <!—一组按钮控件-->
                <a href="/doctor/search/checklist"><button type="button"  class="btn btn-lg btn-success">病患多维查询</button></a>
                <a href="/editor/editor"><button type="button" class="btn btn-lg btn-primary">健康社区</button></a>

            </p>
            <div class="row">
                <div class="col-md-6">
                    <!—panel面板，里面放置一些控件，下同-->
                    <div class="panel panel-primary">
                        <!—panel面板的标题，下同-->
                        <div class="panel-heading">
                            <h3 class="panel-title">最新病人列表</h3>
                        </div>
                        <!—panel面板的内容，下同-->
                        <div class="panel-body">
                            <c:forEach items="${newestThreeCheckedPatients}" var="patient">
                                <div class="alert alert-danger" role="alert">
                                    <span><strong>病人：</strong>${patient.patientId}</span>
                                    <p class="pull-right">
                                        <a style="display:inline" class="btn btn-success" href="/doctor/statistics/patient/${patient.patientId}">详情</a>
                                    </p>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">

                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">数据展示</h3>
                        </div>
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked" role="tablist">
                                <li role="presentation">
                                    <a href="/doctor/statistics/patient" class="alert alert-info">
                                        <span class="badge pull-right">${patientQuantity}</span>
                                        患者数量
                                    </a>
                                </li>
                                <li role="presentation">
                                    <a href="/doctor/statistics/check" class="alert alert-info">
                                        <span class="badge pull-right">${checkItemQuantity}</span>
                                        检查项目数量
                                    </a>
                                </li>
                                <li role="presentation">
                                    <a href="/doctor/statistics/test" class="alert alert-info">
                                        <span class="badge pull-right">${testItemQuantity}</span>
                                        检验项目数量
                                    </a>
                                </li>
                                <li>
                                <li role="presentation">
                                    <p>&nbsp</p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">病人动态</h3>
                        </div>
                        <div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>时间段</th>
                                        <th>检查指标数量</th>
                                        <th>检验指标数量</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>最近一周</td>
                                        <td>${checkQuantityOfLastWeek}</td>
                                        <td>${testQuantityOfLastWeek}</td>
                                    </tr>
                                    <tr>
                                        <td>最近一月</td>
                                        <td>${checkQuantityOfLastMonth}</td>
                                        <td>${testQuantityOfLastMonth}</td>

                                    </tr>
                                    <tr>
                                        <td>最近一年</td>
                                        <td>${checkQuantityOfLastYear}</td>
                                        <td>${testQuantityOfLastYear}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div id="chart" style="width: 600px;height:400px;float:left;" ></div>
                <div id="chart2"  style="width: 600px;height:400px;float:left;"> </div>
            </div>

            <script type="text/javascript">
                var male = "${checkQuantityOfMale}";
                var female = "${checkQuantityOfFemale}";
                var myChart = echarts.init(document.getElementById('chart'));
                var option = {
                    title : {
                        text: '病患男女比例',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data: ['男','女']
                    },
                    series : [
                        {
                            name: '来源:数据中心',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '50%'],
                            data:[
                                {value:male, name:'男'},
                                {value:female, name:'女'}
                            ],
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
                myChart.setOption(option);
            </script>

            <script type="text/javascript">
                var myChart2 = echarts.init(document.getElementById('chart2'));
                var a = ${checkQuantityOfAge2};
                var b = ${checkQuantityOfAge3};
                var c = ${checkQuantityOfAge4};
                var d = ${checkQuantityOfAge5};
                var e = ${checkQuantityOfAge6};
                var f = ${checkQuantityOfAge10};
                var option = {
                    backgroundColor: '#',

                    title: {
                        text: '年龄分布',
                        x:'center'
                    },

                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },

                    visualMap: {
                        show: false,
                        min: 80,
                        max: 600,
                        inRange: {
                            colorLightness: [0.6, 1]
                        }
                    },

                    series : [
                        {
                            name:'来源：数据中心',
                            type:'pie',
                            radius : '55%',
                            center: ['50%', '50%'],
                            data:[
                                {value:a, name:'20以下'},
                                {value:b, name:'20-30'},
                                {value:c, name:'30-40'},
                                {value:d, name:'40-50'},
                                {value:e, name:'50-60'},
                                {value:f, name:'60以上'}
//                                {value:335, name:'直接访问'},
//                                {value:310, name:'邮件营销'},
//                                {value:274, name:'联盟广告'},
//                                {value:235, name:'视频广告'},
//                                {value:400, name:'搜索引擎'}
                            ].sort(function (a, b) { return a.value - b.value}),
                            roseType: 'angle',
                            label: {
                                normal: {
                                    textStyle: {
                                        color: 'rgba(1, 1, 1, 1)'
                                    }
                                }
                            },
                            labelLine: {
                                normal: {
                                    lineStyle: {
                                        color: 'rgba(1, 1, 1, 0.5)'
                                    },
                                    smooth: 0.2,
                                    length: 10,
                                    length2: 20
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: '#c23531',
                                    shadowBlur: 200,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            },

                            animationType: 'scale',
                            animationEasing: 'elasticOut',
                            animationDelay: function (idx) {
                                return Math.random() * 200;
                            }
                        }
                    ]
                };
                myChart2.setOption(option);
            </script>

        </div>


    </div>
</div>


<script src="/resources/jQuery/jquery-3.1.1.min.js"></script>
<script src="/resources/Bootstrap/js/bootstrap.min.js"></script>

</body>
