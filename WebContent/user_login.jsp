<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="zh-CN">
  <head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>用户登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    
        //切换验证码
        function refreshCode(){
        	//1.获取验证码图片对象
        	var vcode=document.getElementById("vcode");
        	//2.设置其src属性，加时间戳
        	//2.设置其src属性，加时间戳
            vcode.src = "${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
    	
        }
        //单词字符，长度6到20位
		function checkUsername() {
            //1.获取用户名值
			var username = $("#username").val();
			//2.定义正则
			var reg_username = /^\w{6,20}$/;
			
			//3.判断，给出提示信息
		    var flag = reg_username.test(username);
		    if(flag){
		        //用户名合法
                $("#username").css("border","");
			}else{
		        //用户名非法,加一个红色边框
				$("#username").css("border","1px solid red");
			}
		    
            return flag;
        }

        //校验密码
        function checkPassword() {
            //1.获取密码值
            var password = $("#password").val();
            //2.定义正则
            var reg_password = /^\w{6,20}$/;

            //3.判断，给出提示信息
            var flag = reg_password.test(password);
            if(flag){
                //密码合法
                $("#password").css("border","");
            }else{
                //密码非法,加一个红色边框
                $("#password").css("border","1px solid red");
            }

            return flag;
        }
        
        

        $(function () {
            //1.给登录按钮绑定单击事件
			$("#btn_sub").click(function () {
				if(checkUsername() && checkPassword()){
					return true;
				}
				return false;
			});
            
      
			//当某一个组件失去焦点是，调用对应的校验方法
			$("#username").blur(checkUsername);
	        $("#password").blur(checkPassword);
	        
	        
	        
	        
        }); 
        
      
        
        
    </script>
  </head>
  <body style="background-image: url('img/login-bg.jpg');">
  
	<div class="container-fluid">
  		<div class="row" style="margin-top: 50px;">
			<div class="col-sm-6 col-sm-offset-3">
				<h1 class="text-center">
					用户登录<small>V1.0管理系统</small>
				</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
		        <form action="${pageContext.request.contextPath}/user?method=loginUser" method="post">
			      <div class="form-group">
					  <label for="user">用户名：</label> 
					  <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
				  </div>
				  <div class="form-group">
					  <label for="password">密码：</label>
					  <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
				  </div>
			      
			      <div class="form-inline">
			        <label for="vcode">验证码：</label>
			        <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
			        <a href="javascript:refreshCode();">
			        <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/>
			        </a>
			      </div>
			      <hr/>
			      
			      <button type="submit" id="btn_sub" class="btn btn-default" style="float: left; width: 65%; ">登录</button>
				  <button type="reset" class="btn btn-default" style="float: right; width: 30%;">清空</button>
				  <div class="form-group" style="float: left;">
				      <a href="user_register.jsp">还没有账户吗？请先进行注册</a>
			      </div>
				
			  	</form>
				
			</div>
			
			<c:if test="${login_msg!=null}">
				<div class="col-sm-6 col-sm-offset-3">
					<!-- 出错显示的信息框 -->
				  	<div class="alert alert-warning alert-dismissible" role="alert">
					    <button type="button" class="close" data-dismiss="alert" >
					  	<span>&times;</span></button>
					    <strong>${login_msg}</strong>
					</div>	
				</div>	                    
			</c:if>
			
		</div>
		
  	</div>
  </body>
</html>

