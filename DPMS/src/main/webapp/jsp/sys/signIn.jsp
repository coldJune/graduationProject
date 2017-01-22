<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小区物业管理系统</title>
<link rel="stylesheet" type="text/css" href="../../css/default.css">
<link rel="stylesheet" type="text/css" href="../../css/style.css">
<script type="text/javascript" src="../../jQuery/jquery-3.1.1.js"></script>
<script type="text/javascript" src="../../js/login.js"></script>
</head>
<body>
	<div class="htmleaf-container">
		<div class="wrapper">
			<div class="container">
				<form class="form">
					<input type="text" placeholder="用户名" id="userName" name="userName"><label id="textfield1"></label>			
					<input type="password" placeholder="密码" name="passWord" id="passWord"><label id="textfield2"></label>
					<input type="text" name="seruityCode" placeholder="验证码" id="seruityCode"><label id="textfield3"></label>
					<img src="" style="width:250px;height:40px; "><label style=""></label><br/>
					<button type="submit"  id="login-button" >登录</button>
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>