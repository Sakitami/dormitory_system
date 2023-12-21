<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录界面</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入 font-awesome -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>
<div class="container">
    <div class="form row" style="height: 300px;">
        <form class="form-horizontal col-md-offset-3" id="login_form" action="<c:url value="/account/login"/>"
              method="post">
            <h3 class="form-title" style="margin-left: 18%">用户界面</h3>
            <div class="col-md-9">
                <div class="form-group">
                    <label>
                        <i class="fa fa-user fa-lg"></i>
                        <span style="color: red;font-size: 13px;margin-left: -17px;">${usernameError}</span>
                        <span style="color: red;font-size: 13px;margin-left: -17px;">${usernameRepeat}</span>
                        <input class="form-control required" required placeholder="请输入用户名" type="text" name="username"
                               style="font-weight: normal"/>
                    </label>
                </div>
                <div class="form-group">
                    <label>
                        <i class="fa fa-lock fa-lg"></i>
                        <span style="color: red;font-size: 13px;margin-left: -17px;">${passwordError}</span>
                        <input class="form-control required" required placeholder="请输入密码" type="password"
                               name="password" style="font-weight: normal"/>
                    </label>
                </div>
                <div class="form-group">
                    <label class="radio-inline">
                        <input type="radio" name="type" checked value="systemAdmin" class="radio-inline"> 系统管理员
                    </label>
                    <label class="radio-inline" style="margin-left: 12%">
                        <input type="radio" name="type" value="dormitoryAdmin" class="radio-inline"> 寝室管理员
                    </label>
                </div>
                <div class="form-group col-md-offset-9">
                    <button type="submit" class="btn btn-success pull-left" name="action" value="login">登录</button>
                    <%--                    <button type="reset" class="btn btn-success pull-right" name="submit">重置</button>--%>
                    <button type="submit" class="btn btn-success pull-right" name="action" value="register">注册</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>