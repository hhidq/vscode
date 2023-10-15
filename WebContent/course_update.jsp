<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改课程信息</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body style="background-image: url('img/login-bg.jpg');">
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改课程信息</h3>
        <form action="${pageContext.request.contextPath}/course?method=updateCourse" method="post">
          
          <!--  隐藏域 提交id-->
          <input type="hidden" name="id" value="${course.id}">

          <div class="form-group">
            <label for="courseno">课程编号：</label>
            <input type="text" class="form-control" id="courseno" name="courseno"  value="${courseno.name}" readonly="readonly" placeholder="请输入课程编号：" />
          </div>
         
          <div class="form-group">
            <label for="coursename">课程名称：</label>
            <input type="text" class="form-control" value="${course.coursename}" id="coursename"  name="coursename" placeholder="请输入课程名称：" />
          </div>

          <div class="form-group">
            <label for="type">课程类型：</label>          
            <input type="text" id="type" class="form-control" value="${course.type}" name="type" placeholder="请输入课程类型："/>
          
          </div>

          <div class="form-group">
            <label for="period">课程学时：</label>
            <input type="text" id="period" class="form-control" value="${course.period}" name="period" placeholder="请输入课程学时："/>
          </div>

          <div class="form-group">
            <label for="credit">课程学分：</label>
            <input type="text" id="credit" class="form-control" value="${course.credit}" name="credit" placeholder="请输入课程学分："/>
          </div>

          <div class="form-group" style="text-align: center">
             <input class="btn btn-primary" type="submit" value="提交" />
             <input class="btn btn-default" type="reset" value="重置" />
          </div>
        </form>
        </div>
    </body>
</html>