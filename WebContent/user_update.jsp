<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>完善个人信息</title>

        <link href="css/bootstrnoap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
        <script type="text/javascript">
         
	      
	        //校验邮箱
			function checkEmail(){
			    //1.获取邮箱
				var email = $("#email").val();
				//2.定义正则		itcast@163.com
				var reg_email = /^\w+@\w+\.\w+$/;
	
				//3.判断
				var flag = reg_email.test(email);
				if(flag){
	                $("#email").css("border","");
				}else{
	                $("#email").css("border","1px solid red");
				}
	
				return flag;
			}
	        
	        $(function () {
	            //1.给登录按钮绑定单击事件
				$("#btn_sub").click(function () {
					if( checkEmail()){
						return true;
					}
					return false;
				});
	            
				//当某一个组件失去焦点是，调用对应的校验方法
		        $("#email").blur(checkEmail);    
	        });
	        
	      	
        
        </script>
    </head>
    <body style="background-image: url('img/login-bg.jpg');">
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">完善个人信息</h3>
        <form action="${pageContext.request.contextPath}/user?method=updateUser" method="post">
            <!--  隐藏域 提交id-->
          <input type="hidden" name="id" value="${user.id}">

          <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  value="${user.name}"  placeholder="请输入姓名" />
          </div>

          <div class="form-group">
            <label>性别：</label>
              <c:if test="${user.gender == '男'}">
                  <input type="radio" name="gender" value="男" checked />男
                  <input type="radio" name="gender" value="女"  />女
              </c:if>

              <c:if test="${user.gender == '女'}">
                  <input type="radio" name="gender" value="男"  />男
                  <input type="radio" name="gender" value="女" checked  />女
              </c:if>

			  <c:if test="${user.gender == null}">
                  <input type="radio" name="gender" value="男" checked />男
                  <input type="radio" name="gender" value="女"  />女
              </c:if>
          </div>

          <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" value="${user.age}" id="age"  name="age" placeholder="请输入年龄" />
          </div>

          <div class="form-group">
            <label for="address">籍贯：</label>
            <input type="text" id="address" class="form-control" value="${user.address}" name="address" placeholder="请输入籍贯"/>
          </div>

          <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" value="${user.email}" name="email" placeholder="请输入邮箱地址"/>
          </div>

             <div class="form-group" style="text-align: center">
                <input id="btn_sub" class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
             </div>
        </form>
        </div>
    </body>
</html>