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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sys/findPass.js"></script>
</head>
<body>
	<div class="htmleaf-container">
					<label style="font-size: 50px;color: #39ADB4;" ><i><strong>小区物业管理系统</strong></i></label>
	
		<div class="wrapper">
			<div class="container">
				<form class="form" method="post" id="form" action="/DPMS/sys/setSysPass">
					<input type="email" placeholder="邮箱" id="email" name="email"><label id="textfield1"></label><br>		
					<button type="button"  id="sendMail" >发送邮件</button><br/>
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