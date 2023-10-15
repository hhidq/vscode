<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!-- HTML5文档-->
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body style="background-image: url('img/login-bg.jpg');">
<div class="container" style="width: 400px;">

    <div class="row" style="margin-top: 50px;">
		<div class="col-sm-6 col-sm-offset-3">
			<h1 class="text-center">
				<small>添加课程信息</small>
			</h1>
		</div>
	</div>
    <form action="${pageContext.request.contextPath}/course?method=addCourse" method="post">
        
        <div class="form-group">
            <label for="courseno">课程编号：</label>
            <input type="text" class="form-control" id="courseno" name="courseno" placeholder="请输入课程编号">
        </div>

        <div class="form-group">
            <label for="coursename">课程名称：</label>
            <input type="text" class="form-control" id="coursename" name="coursename" placeholder="请输入课程名称">
        </div>

        <div class="form-group">
            <label for="type">课程类型：</label>
            <input type="text" class="form-control" id="type" name="type" placeholder="请输入课程类型">
        </div>

        <div class="form-group">
            <label for="period">课程学时：</label>
            <input type="text" class="form-control" id="period" name="period" placeholder="请输入课程学时"/>
        </div>

        <div class="form-group">
            <label for="credit">课程学分：</label>
            <input type="text" class="form-control" id="credit" name="credit" placeholder="请输入课程学分"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
        </div>
    </form>
</div>
</body>
</html>