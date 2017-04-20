<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>小区物业管理系统</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/templatemo-style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/jQuery/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/jQuery/jquery.form.js"></script>
            <script type="text/javascript" src="${pageContext.request.contextPath}/jQuery/ajaxfileupload.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/default.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$('#imgUpload').click(function(){
			$('#imgHead').click();	
		});
		$('#submitPersonalForm').click(function(){
				$.ajax({
					url:'../sysUser/updateSysUser?type=personal',
					data: $("#form1").serialize(),
					type:'POST',
					dataType:'json',
					success:function(data){
						alert(data.msg);
						window.location.reload();
					},
					failure:function(){
						alert('修改失败');
					}
				});
		});
		
		//验证系统生成密码是否正确
		var flag1=0;
		$('#syspass').blur(function(){
			$('#textfield1').empty();
			var syspass=$(this).val();
			$('#textfield1').empty();
			if(syspass==''||syspass==null){
			}else{
				$.ajax({
					url:'../sys/check',
					dataType:'json',
					data:{'syspass':syspass,'operateType':'checkSysPass'},
					type:'post',
					success:function(data){
						if(data.sp!=undefined){
							$('#textfield1').append('<p style="color:red">*'+data.sp+"</p>");
							$('#syspassdiv').addClass('has-error');
							$('#textfield1').show();
							flag1=0;
						}else{
							$('#syspassdiv').removeClass('has-error');
							flag1=1;
						}
					}
				});
			}
		});
		//验证密码格式
		var flag2=0;
		$('#newpass').blur(function(){
			$('#textfield2').empty();
			var newPass=$(this).val();
			reg=/^[a-zA-Z]\w{5,17}$/;
			if(!reg.test(newPass)){
				$('#newpassdiv').addClass('has-error');
				$('#textfield2').append('<p style="color:red">*密码应为以字母开头并且只包含'+'<br/>'+'数字、字符、和_的6到18位字符串</p>');
				$('#textfield2').show();
				flag2=0;
			}else{
				flag2=1;
				$('#newpassdiv').removeClass('has-error');
			}
		});
		//验证前后密码输入是否一致
		var flag3=0;
		$('#passagain').blur(function(){
			$('#textfield3').empty();
			var passagain=$(this).val();
			var newpass=$('#newpass').val();
			if(passagain==newpass){
				flag3=1;
			}else{
				flag3=0;
				$('#passagaindiv').addClass('has-error');
				$('#textfield3').append('<p style="color:red">*密码不一致</p>');
				$('#textfield3').show();
			}
		});
		
		
		
		$('#changePass').click(function(){
			alert(flag1+":"+flag2+":"+flag3);
			if(flag1==1&&flag2==1&&flag3==1){
				$.ajax({
					url:'../sys/changePass?type=personal',
					data: $("#passForm").serialize(),
					type:'POST',
					dataType:'json',
					success:function(data){
						alert(data.msg);
						window.location.reload();
					},
					failure:function(){
						alert('修改失败');
					}
				});
			}else{
				alert('输入密码不符合要求，请重新输入');
				$('#syspass').val('');
				$('#newpass').val('');
				$('#passagain').val('');
			}
		});
	});
		
	function uploadImg(){
		var img=$('#imgHead').val();
		var extention=img.substring(img.lastIndexOf('.')+1);
		if(img==''){
			alert('请选择修改的头像');
		}
		//判断后缀名		
		else if(extention!='jpg'&&extention!='png'&&extention!='bmp'&&extention!='gif'){
			alert('请选择图片格式的文件');
			$('#imgHead').empty();
		}
		$.ajaxFileUpload({
			url:'./sysUser/uploadImg',
			secureuri:false,
			fileElementId:'imgHead',
			dataType:'JSON',
			success:function(data){
				window.location.reload();
			}
		})
	}
	</script>
  </head>
  <body>
  	  <% String sess=(String)session.getAttribute("USERNAME");%>
  
  	<div class="templatemo-flex-row">
      <div class="templatemo-sidebar">
        <header class="templatemo-site-header">
          <div class="square"></div>
          <h1><%=sess %></h1>
        </header>
		<div class="profile-photo-container" style="text-align: center;vertical-align: middle;">
       	<a href="../sysUser/showPersonal?dpmsSysUser.userName=root"> 
          <img  src="/DPMS/sysUser/showHead"  alt="头像" class="img-responsive"> 
         <div class="profile-photo-overlay" ></div>
        </a> 
        </div>       
                <div class="mobile-menu-icon">
            	<i class="fa fa-bars"></i>
        </div>
        <nav class="templatemo-left-nav">          
          <ul>
           
           <li><a href="../realEstate/findAllRealEstate" ><i class="fa fa-bar-chart fa-fw"></i>楼盘信息管理</a></li>
            <li><a href="../property/findAllProperty" ><i class="fa fa-database fa-fw"></i>物业收费管理</a></li>
            <li><a href="../park/findAllPark" ><i class="fa fa-map-marker fa-fw"></i>停车场信息管理</a></li>
            <li><a href="../household/findAllHousehold" ><i class="fa fa-users fa-fw"></i>住户信息管理</a></li>
            <li><a href="../repair/findAllRepair"><i class="fa fa-sliders fa-fw"></i>住户报修管理</a></li>
            <li><a href="../complain/findAllComplain" ><i class="fa fa-question fa-fw"></i>住户投诉管理</a></li>
             <% 
          	 if(sess.equalsIgnoreCase("ROOT")){
          %>
            <li><a href="../sys/findAllSysUser" class="active"><i class="fa fa-home fa-fw"></i>系统用户管理</a></li>
          <%} %>
            <li><a href="../sys/exit"><i class="fa fa-eject fa-fw"></i>注销登录</a></li>
          </ul>  
        </nav>
      </div>
      <div class="templatemo-content col-1 light-gray-bg">
	   		<div class="templatemo-top-nav-container">
		        <div class="row">
		         	<nav class="templatemo-top-nav col-lg-12 col-md-12">
		           	<h1 style="font-size: 26;color: white;text-align: center;"><i><strong>小区物业管理系统</strong></i></h1>  
	            </nav> 
	        </div>
	  </div>
	      
	    	<div class="templatemo-content-container">
		          		<div class="templatemo-flex-row flex-content-row">
		          		
           				 <div class="templatemo-content-widget white-bg col-2 text-center" >
           				 <i class="fa fa-times"></i>
              			<h2 class="text-uppercase"><%=sess %></h2>
             			 <h3 class="text-uppercase margin-bottom-10">个人信息</h3>
              			<a href='javascript:void(0)' id="imgUpload"><img src="/DPMS/sysUser/showHead" alt="Bicycle" class="img-circle img-thumbnail" style="width: 100px;height: 100px"></a>
              			<input type="file" name='imgHead' hidden="true" id="imgHead" style="display: none" onchange="uploadImg()">
			           	<form  action="" id="personalForm" class="templatemo-login-form" method="post" enctype="multipart/form-data">
			              <div class="row form-group">
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="userId">用户ID</label>
				                    <input type="text" class="form-control" id="userId" name="userId"  value="${dpmsSysUser.userId}" readonly="readonly">                  
				                </div>		               
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="userName">用户名</label>
				                    <input type="text" class="form-control" id="userName" name="userName" value="${dpmsSysUser.userName}" readonly="readonly">                  
				                </div> 
 						  </div>
			              <div class="row form-group">
			               		<div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="name">姓名</label>
				                    <input type="text" class="form-control" id="name" name="name" value="${dpmsSysUser.name}" required="required">                  
				                </div>
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="cardId">身份证号</label>
				                    <input type="text" class="form-control" id="cardId" name="cardId" maxlength="18" min="15"  value="${dpmsSysUser.cardId}" required="required">                  
				                </div>  
				               
			               </div>
			               <div class="row form-group">
			               		 <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="gender">性别</label>
				                    <input type="text" class="form-control" id="gender" name="gender" value="${dpmsSysUser.gender}" readonly="readonly">                  
				                </div> 
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="age">年龄</label>
				                    <input type="text" class="form-control" id="age" name="age" value="${dpmsSysUser.age}" readonly="readonly">                  
				                </div> 
				                
				                
			               </div>
			               <div class="row form-group">
			               		<div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="address">地址</label>
				                    <input type="text" class="form-control" id="address" name="address" value="${dpmsSysUser.address}" required="required">                  
				                </div>
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="birthDay">出生年月</label>
				                    <input type="text" class="form-control" id="birthDay"  name="birthDay"  value="${dpmsSysUser.birthDay}" readonly="readonly">                  
				                </div>  
				                
				               
			               </div>
			               <div class="row form-group">
				                <div class="col-lg-6 col-md-6 form-group">  
				                                
				                    <label for="email">邮箱</label>
				                    <input type="email" class="form-control" id="email"  name="email" value="${dpmsSysUser.email}" required="required">                  
				                </div>
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for=phone>电话号码</label>
				                    <input type="text" class="form-control" id="phone" name="phone" value="${dpmsSysUser.phone}" required="required">                  
				                </div>   
			              </div>
			               <div class="row form-group">
			                	<div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="createDate">创建日期</label>
				                    <input type="text" class="form-control" id="createDate" name="createDate" value="${dpmsSysUser.createDate}" readonly="readonly" >                  
				                </div>
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="lastLogin">最后一次登录时间</label>
				                    <input type="text" class="form-control" id="lastLogin"  name="lastLogin" value="${dpmsSysUser.lastLogin}" readonly="readonly">                  
				                </div>  			                
			               </div>
							<input type="text" name="type" value="personal" hidden="true">
			              <div class="form-group text-right">
			                <button type="button" id="changePass" class="templatemo-blue-button">修改</button>
			                <button type="reset" class="templatemo-white-button">重置</button>
			              </div>                           
		           	  </form>  
		           	  </div>
		           	  <div class="templatemo-content-widget white-bg col-1 text-center">
			              <i class="fa fa-times"></i>
			              <h2 class="text-uppercase"><%=sess %></h2>
			              <h3 class="text-uppercase margin-bottom-10">修改密码</h3>
			              <form  id="passForm" class="templatemo-login-form" method="post" enctype="multipart/form-data">
						              <div class="row form-group">
							                <div class="col-lg-12 col-md-12 form-group" id="syspassdiv">                  
							                    <label for="syspass">原密码</label>
							                    <input type="password" class="form-control" id="syspass" name="syspass" required="required"><label id="textfield1"></label>                  
							                </div>		               
							                <div class="col-lg-12 col-md-12 form-group" id="newpassdiv">                  
							                    <label for="newpass">新密码</label>
							                    <input type="password" class="form-control" id="newpass" name="newpass" required="required"><label id="textfield2"></label>                  
							                </div> 
							                <div class="col-lg-12 col-md-12 form-group" id="passagaindiv">                  
							                    <label for="passagain">确认密码</label>
							                    <input type="password" class="form-control" id="passagain" name="passagain" required="required"><label id="textfield3"></label>                  
							                </div>
							                <button type="button" id="submitPassForm" class="templatemo-blue-button">修改</button>
			                				<button type="reset" class="templatemo-white-button">重置</button> 
			 						  </div>
						   </form>
           			 </div>                      
	          </div>  
	      </div>
	       </div>
	        </div>
  	 <div class="templatemo-footer col-1 light-gray-bg">
  		<footer class="text-center">
            <p>Copyright &copy; 2017 Company Name 
            | coldJune 2013211526</p>
          </footer>  
  	</div>	
  </body>
</html>