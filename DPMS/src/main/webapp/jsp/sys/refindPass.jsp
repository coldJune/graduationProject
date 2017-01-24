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
<script type="text/javascript" src="../../js/sys/findPass.js"></script>
</head>
<body>
	<div class="htmleaf-container">
		<div class="wrapper">
			<div class="container">
				<form class="form" method="post" id="form" action="/DPMS/sys/setSysPass">
					<input type="email" placeholder="邮箱" id="email" name="email"><label id="textfield1"></label><br>		
					<button type="button"  id="sendMail" >发送邮件</button><br/>
				</form>
			</div>
		</div>
	</div>
</body>
</html>