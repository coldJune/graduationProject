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
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/font-awesome.min.css" rel="stylesheet">
    <link href="../css/templatemo-style.css" rel="stylesheet">
    <link href="../css/table.css" rel="stylesheet">
    <script type="text/javascript" src="../jQuery/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="../js/default.js"></script>
  </head>
  <body>
  	<div class="templatemo-flex-row">
      <div class="templatemo-sidebar">
        <header class="templatemo-site-header">
          <div class="square"></div>
          <h1>Root</h1>
        </header>
       <div class="profile-photo-container" style="text-align: center;vertical-align: middle;">
       	<a href="../sysUser/showPersonal?dpmsSysUser.userName=root"> 
          <img src="/DPMS/sysUser/showHead"  alt="头像" class="img-responsive"> 
         <div class="profile-photo-overlay" ></div>
        </a> 
        </div>
                <div class="mobile-menu-icon">
            	<i class="fa fa-bars"></i>
        </div>
        <nav class="templatemo-left-nav">          
          <ul>
           
           <li><a href="../realEstate/findAllRealEstate" ><i class="fa fa-bar-chart fa-fw"></i>楼盘信息管理</a></li>
            <li><a href="../property/findAllProperty"><i class="fa fa-database fa-fw"></i>物业收费管理</a></li>
            <li><a href="findAllPark" class="active"><i class="fa fa-map-marker fa-fw"></i>停车场信息管理</a></li>
            <li><a href="../household/findAllHousehold" ><i class="fa fa-users fa-fw"></i>住户信息管理</a></li>
            <li><a href="../repair/findAllRepair"><i class="fa fa-sliders fa-fw"></i>住户报修管理</a></li>
            <li><a href="../complain/findAllComplain" ><i class="fa fa-question fa-fw"></i>住户投诉管理</a></li>
             <% String sess=(String)session.getAttribute("USERNAME");
          	 if(sess=="root"){
          %>
            <li><a href="../sysUser/findAllSysUser" ><i class="fa fa-home fa-fw"></i>系统用户管理</a></li>
          <%} %>
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
		          <h2 class="margin-bottom-10">停车信息</h2>
            		<p>>>详情</p>
		          
			           <form  action="updateHousehold" class="templatemo-login-form" method="post" enctype="multipart/form-data">
			              <div class="row form-group">
				              <div class="col-lg-6 col-md-6 form-group">                  
					                    <label for="plateNumber">车牌号</label>
					                    <input type="text" class="form-control" id="plateNumber" name="dpmsPark.plateNumber" value="${dpmsPark.plateNumber}" readonly="readonly">                  
					          </div>
					          <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="price">收取费用</label>
				                    <input type="number" class="form-control" id="price" name="dpmsPark.price" value="${dpmsPark.price}" readonly="readonly">                 
				               </div>  
 						  </div>
			              <div class="row form-group">
			               		<div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="startTime">入库时间</label>
				                    <input type="text"  class="form-control" id="startTime" name="dpmsPark.startTime" value="${dpmsPark.startTime}" readonly="readonly">                  
				                </div>
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="endTime">离场时间</label>
				                    <input type="text"  class="form-control" id="endTime" name="dpmsPark.endTime"   value="${dpmsPark.endTime}" readonly="readonly">                  
				                </div>  
				               
			               </div>
			               
			              <c:if test="${dpmsPark.dpmsHousehold!=null}">
			              <div class="row form-group">               
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="holdName">户主姓名</label>
				                    <input type="text"  class="form-control" id="holdName" name="dpmsPark.dpmsHousehold.holdName" value="${dpmsPark.dpmsHousehold.holdName}" readonly="readonly">                  
				                </div>
				                 <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="holdPhone">户主电话</label>
				                    <input type="text" class="form-control" id="phone"  name="dpmsPark.dpmsHousehold.holdPhone" value="${dpmsPark.dpmsHousehold.holdPhone}"  readonly="readonly">                  
				                </div> 
 						  </div>
			               <div class="row form-group">
			               		 <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="relateRealEstate">所属楼栋</label>
				                    <input type="number" min="0" class="form-control" id="relateRealEstate" name="dpmsPark.dpmsHousehold.relateRealEstate" value="${dpmsPark.dpmsHousehold.relateRealEstate}" readonly="readonly" >                 
				                </div> 
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="relateUnit">所属单元</label>
				                    <input type="number" class="form-control" min="0" id="relateUnit" name="dpmsPark.dpmsHousehold.relateUnit" value="${dpmsPark.dpmsHousehold.relateUnit}" readonly="readonly">                  
				                </div>      
			               </div>
			               <div class="row form-group">
			               		<div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="relateFloor">所属层数</label>
				                    <input type="number" min="0" class="form-control" id="relateFloor" name="dpmsPark.dpmsHousehold.relateFloor" value="${dpmsPark.dpmsHousehold.relateFloor}" readonly="readonly">                 
				                </div>
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="relateNo">门牌号</label>
				                    <input type="number"min="0" class="form-control" id="relateNo"  name="dpmsPark.dpmsHousehold.relateNo"  value="${dpmsPark.dpmsHousehold.relateNo}" readonly="readonly">                  
				                </div>  
				                
				               
			               </div>
			               </c:if>			               
			              <div class="form-group text-right">
			                <button type="button" class="templatemo-white-button" onclick="javascript:history.back(-1);">返回</button>
			              </div>                           
		           	  </form>                        
	          </div>  
	      </div>
	       
	    </div >  
	        </div>
  	 <div class="templatemo-footer col-1 light-gray-bg">
  		<footer class="text-center">
            <p>Copyright &copy; 2017 Company Name 
            | coldJune 2013211526</p>
          </footer>  
  	</div>	
  </body>
</html>