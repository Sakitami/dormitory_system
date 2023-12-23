<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>TUST寝室管理系统</title>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- 引入 Bootstrap -->
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入 font-awesome -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="application/javascript">
        function change(url, index) {
            $(".list-group-item").removeClass("active");
            $(".list-group-item").eq(index).addClass("active");
            $("iframe").attr("src", "/" + url);
        }
    </script>
    <title>欢迎您,${systemAdmin.name}</title>
</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <ul class="nav navbar-nav navbar-left">
            <li>
                <a style="font-size: 26px;">YskysoarTUST寝室管理系统-系统管理员</a>
            </li>
        </ul>
        <span style="color: #CCCCCC;font-size: 26px;position: relative;top: 5px;"></span>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a>欢迎您,${systemAdmin.name}</a>
            </li>
            <li>
                <a href="<c:url value="/account/logout"/>">安全退出</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-2">

            <a href="javascript:void(0)" class="list-group-item active" onclick="change('dormitoryAdmin/list',0)">
                <span class="" aria-hidden="true">
                    <i class="fa fa-user-circle-o fa-fw"></i>
                </span>宿管管理
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('student/list',1)">
				<span class="" aria-hidden="true">
					<i class="fa fa-user-circle fa-fw"></i>
				</span>学生管理
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('building/list',2)">
				<span class="" aria-hidden="true">
					<i class="fa fa-home fa-fw"></i>
				</span>寝室楼管理
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('dormitory/list',3)">
				<span class="" aria-hidden="true">
					<i class="fa fa-bed fa-fw"></i>
				</span>寝室管理
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('moveout/list',4)">
				<span class="" aria-hidden="true">
					<i class="fa fa-address-card-o fa-fw"></i>
				</span>学生迁出登记
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('moveout/record',5)">
				<span class="" aria-hidden="true">
					<i class="fa fa-bookmark fa-fw"></i>
				</span>学生迁出记录
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('absent/list',6)">
				<span class="" aria-hidden="true">
					<i class="fa fa-bookmark-o fa-fw"></i>
				</span>学生缺寝记录
            </a>

        </div>
        <!--右边内容-->
        <iframe style="width: 81%; height: 600px; border: 0;" src="<c:url value="/dormitoryAdmin/list"/>"></iframe>
    </div>
</div>
<div class="footer">
    <p class="text-center">
        2023 © YskysoarTUST寝室管理系统
    </p>
</div>
</body>
</html>
