<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小区物业管理系统</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
</head>
<body>
	<div class="htmleaf-container">
		<label style="font-size: 50px;color: #39ADB4;" ><i><strong>小区物业管理系统</strong></i></label>
		<div class="wrapper">
		
			<div class="container">

				<form id="form" class="form" method="post" action="/DPMS/sys/logIn">
					<input type="text" placeholder="用户名" id="userName" name="userName"><label id="textfield1"></label>			
					<input type="password" placeholder="密码" name="passWord" id="passWord"><label id="textfield2"></label>
					<input type="text" name="securityCodeInput" placeholder="验证码" id="securityCodeInput"><label id="textfield3"></label>
					<img src="/DPMS/sys/securityCodeImage" style="width:250px;height:40px;cursor: pointer;" id="securityimg"/><br/>
					<button type="button"  id="login-button" >登录</button><br/>
					<a id="forgetPass" style="position: relative;cursor: pointer;color: white;" href="/DPMS/jsp/sys/refindPass.jsp">忘记密码？</a>
				</form>
			</div>
		</div>
		<footer class="text-center" style="color: #39ADB4;">
            <p>Copyright &copy; 2017 Company Name 
            | coldJune 2013211526</p>
          </footer>
	</div>
	
</body>
</html>