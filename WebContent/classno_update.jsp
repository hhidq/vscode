<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改学生信息</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body style="background-image: url('img/login-bg.jpg');">
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改班级信息</h3>
        <form action="${pageContext.request.contextPath}/classno?method=updateClassNo" method="post">
          <!--隐藏域 提交id-->
          <input type="hidden" name="id" value="${classNo.id}">

          <div class="form-group">
            <label for="cno">班级编号：</label>
            <input type="text" class="form-control" id="cno" name="cno"  value="${classNo.cno}" placeholder="请输入班级编号" />
          </div>

          <div class="form-group">
            <label for="className">班级名称：</label>
            <input type="text" class="form-control" value="${classNo.className}" id="className"  name="className" placeholder="请输入班级名称" />
          </div>

          <div class="form-group">
            <label for="department">所属院系：</label>
            
            <input type="text" id="department" class="form-control" value="${classNo.department}" name="department" placeholder="请输入所属院系"/>
          
          </div>
		  <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
          </div>
          
        </form>
        </div>
    </body>
</html>