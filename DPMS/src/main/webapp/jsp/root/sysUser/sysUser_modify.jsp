<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>小区物业管理系统</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
    
    <link href="../../../css/font-awesome.min.css" rel="stylesheet">
    <link href="../../../css/templatemo-style.css" rel="stylesheet">
    <link href="../../../css/table.css" rel="stylesheet">
    <script type="text/javascript" src="../../../jQuery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="../../../js/default.js"></script>

  </head>
  <body>
  	<div class="templatemo-flex-row">
      <div class="templatemo-sidebar">
        <header class="templatemo-site-header">
          <div class="square"></div>
          <h1>Root</h1>
        </header>
        <div class="profile-photo-container">
          <img src="images/profile-photo.jpg" alt="Profile Photo" class="img-responsive">  
          <div class="profile-photo-overlay"></div>
        </div>
                <div class="mobile-menu-icon">
            <i class="fa fa-bars"></i>
        </div>
        <nav class="templatemo-left-nav">          
          <ul>
            <li><a href="findAll" class="active"><i class="fa fa-home fa-fw"></i>系统用户管理</a></li>
            <li><a href="#"><i class="fa fa-bar-chart fa-fw"></i>楼盘信息管理</a></li>
            <li><a href="#"><i class="fa fa-database fa-fw"></i>物业收费管理</a></li>
            <li><a href="#"><i class="fa fa-map-marker fa-fw"></i>停车场信息管理</a></li>
            <li><a href="#"><i class="fa fa-users fa-fw"></i>住户信息管理</a></li>
            <li><a href="#"><i class="fa fa-sliders fa-fw"></i>住户保修管理</a></li>
            <li><a href="#"><i class="fa fa-question fa-fw"></i>住户投诉管理</a></li>
            <li><a href="#"><i class="fa fa-eject fa-fw"></i>注销登录</a></li>
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
	    		
	          <div class="templatemo-content-widget white-bg">
		          <h2 class="margin-bottom-10">Preferences</h2>
            		<p>Here goes another form and form controls.</p>
		          </div>
			           <form action="#" class="templatemo-login-form" method="post" enctype="multipart/form-data">
			              <div class="row form-group">
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="userId">用户ID</label>
				                    <input type="text" class="form-control" id="userId" name="userId" placeholder="${dpmsSysUser.userId}" readonly="readonly">                  
				                </div>		               
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="userName">用户名</label>
				                    <input type="text" class="form-control" id="userName" name="userName" placeholder="${dpmsSysUser.userName}" readonly="readonly">                  
				                </div> 
 						  </div>
			              <div class="row form-group">
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="gender">性别</label>
				                    <input type="text" class="form-control" id="gender" name="gender" placeholder="${dpmsSysUser.gender}">                  
				                </div> 
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="age">年龄</label>
				                    <input type="text" class="form-control" id="age" name="age" placeholder="${dpmsSysUser.age}" >                  
				                </div> 
			               </div>
			               <div class="row form-group">
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="address">地址</label>
				                    <input type="text" class="form-control" id="address" name="address" placeholder="${dpmsSysUser.address}">                  
				                </div> 
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="cardId">身份证号</label>
				                    <input type="text" class="form-control" id="cardId" name="cardId" placeholder="${dpmsSysUser.cardId}">                  
				                </div> 
			               </div>
			               <div class="row form-group">
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for=phone>电话号码</label>
				                    <input type="text" class="form-control" id="phone" name="phone" placeholder="${dpmsSysUser.phone}" >                  
				                </div> 
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="createDate">创建日期</label>
				                    <input type="date" class="form-control" id="createDate" name="createDate" placeholder="${dpmsSysUser.createDate}" readonly="readonly">                  
				                </div>
			               </div>
			               <div class="row form-group">
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="lastLogin">最后一次登录时间</label>
				                    <input type="datetime" class="form-control" id="lastLogin"  name="lastLogin" placeholder="${dpmsSysUser.lastLogin}" readonly="readonly">                  
				                </div>  
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="birthDay">出生年月</label>
				                    <input type="date" class="form-control" id="birthDay"  name="birthDay" placeholder="${dpmsSysUser.birthDay}" readonly="readonly">                  
				                </div> 
			               </div>
			               <div class="row form-group">
				                <div class="col-lg-6 col-md-6 form-group">  
				                                
				                    <label for="email">邮箱</label>
				                    <input type="email" class="form-control" id="email"  name="email" placeholder="${dpmsSysUser.birthDay}">                  
				                </div>  
			              </div>
			              <div class="form-group text-right">
			                <button type="submit" class="templatemo-blue-button">Update</button>
			                <button type="reset" class="templatemo-white-button">Reset</button>
			              </div>                           
		           	  </form>                        
	          </div>  
	      </div>
	       
	    </div >  
	        
  	 <div class="templatemo-footer col-1 light-gray-bg">
  		<footer class="text-center">
            <p>Copyright &copy; 2017 Company Name 
            | coldJune 2013211526</p>
          </footer>  
  	</div>	
  </body>
</html>