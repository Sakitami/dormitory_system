<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>TUST寝室管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- 引入 Bootstrap -->
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入 font-awesome -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-10">
            <!-- 顶部搜索部分 -->
            <div class="panel panel-default">
                <div class="panel-heading">搜索</div>
                <div class="panel-body">
                    <form role="form" class="form-inline" action="<c:url value="/absent/search"/>" method="post">
                        <div class="form-group">
                            <label>字段：</label>
                            <label style="font-weight: normal;margin: 0">
                                <select name="key" class="form-control">
                                    <option value="buildingName">寝室楼</option>
                                    <option value="dormitoryName">寝室</option>
                                </select>
                            </label>
                        </div>
                        <div class="form-group" style="margin-left: 20px">
                            <label>值：</label>
                            <label style="font-weight: normal;margin: 0">
                                <input type="text" class="form-control" name="value" placeholder="字段值" maxlength="12"
                                       style="width: 130px">
                            </label>
                        </div>
                        <div class="form-group " style="margin-left: 20px">
                            <button type="submit" class="btn btn-info ">
                                <span style="margin-right: 5px" aria-hidden="true">
                                    <i class="fa fa-search" aria-hidden="true">开始搜索</i>
                                </span>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <!-- 列表展示-->
            <div class="table-responsive">
                <table class="table table-hover ">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>寝室楼</th>
                        <th>寝室</th>
                        <th>姓名</th>
                        <th>原因</th>
                        <th>宿管</th>
                        <th>日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="absent">
                        <tr>
                            <td>${absent.id}</td>
                            <td>${absent.buildingName}</td>
                            <td>${absent.dormitoryName}</td>
                            <td>${absent.studentName}</td>
                            <td>${absent.reason}</td>
                            <td>${absent.dormitoryAdminName}</td>
                            <td>${absent.createDate}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

</body>

</html>