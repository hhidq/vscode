<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>网站后台管理</title>
 
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    <style type="text/css">
        @media (min-width: 768px) {
           #slider_sub{
               width: 200px;
               margin-top: 51px;
               position: absolute;
               z-index: 1;
               height: 600px;
           }
            .mysearch{
                margin: 10px 0;
            }
            .page_main{
                margin-left: 205px;
            }
        }
    </style>
    
</head>
<body style="background: rgba(92,88,116,0.34)">
	<!-- style="background-image: url('img/background1.png');" -->
    <nav class="navbar navbar-default navbar-static-top">
        <div class="navbar-header">
            <!--缩放 -->
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#slider_sub">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">学生管理系统主页</a>
        </div>
        <ul class="nav navbar-nav navbar-right" style="margin-right: 25px">
            <li><a href="${pageContext.request.contextPath}/user?method=findUser&id=${user.id}"><span class="badge" style="background: #C12E2A">${user.username}</span></a></li>
            <li><a href="${pageContext.request.contextPath}/user?method=destroyUser"><span class="glyphicon glyphicon-off"></span>&nbsp;注销</a></li>
        
        </ul>
 
        <!-- 侧边栏  -->
        <div class="navbar-default navbar-collapse" id="slider_sub">
            <ul class="nav">
                <li>

			        <form class="form-inline" action="${pageContext.request.contextPath}/student?method=findAll" method="post">
			            
			            <!--搜索 -->
	                    <div class="input-group mysearch">
	                        <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName2" >
	                        <span class="input-group-btn">
	                            <button type="submit" class="btn btn-default">
	                                <span class="glyphicon glyphicon-search"></span>
	                            </button>
	                        </span>
	 
	                    </div>
			        </form>

                    
                </li>
                
                <li><a href="${pageContext.request.contextPath}/index.jsp" class="collapse" data-toggle="collapse">首页<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                     <!-- <ul id="sub2" class="nav collapse">
                        <li><a href="#"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;信息管理</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;学生管理</a></li>
                    </ul> -->
                </li>
                <li><a href="${pageContext.request.contextPath}/student?method=findAll"  class="collapse" data-toggle="collapse">学生管理<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                    
                </li>
                <li><a href="${pageContext.request.contextPath}/classno?method=findAll"  class="collapse" data-toggle="collapse">班级管理<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                    
                </li>
                <li><a href="${pageContext.request.contextPath}/course?method=findAll"  class="collapse" data-toggle="collapse">课程管理<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                    
                </li>
                <li><a href="${pageContext.request.contextPath}/about.jsp"  class="collapse" data-toggle="collapse">关于我们<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                    
                </li>
            </ul>
        </div>
    </nav>
 
    <!-- 主区域 -->
    <div class="page_main" style="background-size:100% 100%;">
       <div class="row" style="margin-top: 50px;">
			<div class="col-sm-6 col-sm-offset-3">
				<h1 class="text-center">
					<small>欢迎来到学生信息管理系统</small>
				</h1>
			</div>
		</div> 
    </div>
    
    
    

</body>
</html>