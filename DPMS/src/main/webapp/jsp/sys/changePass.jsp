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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sys/changePass.js"></script>
</head>
<body>
	<div class="htmleaf-container">
		<div class="wrapper">
				<label style="font-size: 50px;color: white;" ><i><strong>小区物业管理系统</strong></i></label>
			<div class="container">
				<form id="form" class="form" method="post" action="/DPMS/sys/changePass">
					<input type="password" placeholder="原密码" id="syspass" name="syspass"><label id="textfield1"></label>			
					<input type="password" placeholder="新密码" name="passWord" id="newpass"><label id="textfield2"></label>
					<input type="password" placeholder="确认密码" name="passagain" id="passagain"><label id="textfield3"></label><br/>
					<input value="common" name="type" id="type" hidden="true"><br/>
					<button type="button"  id="changePass" >修改密码</button><br/>
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