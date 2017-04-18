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
           
               <li><a href="../realEstate/findAllRealEstate"><i class="fa fa-bar-chart fa-fw"></i>楼盘信息管理</a></li>
            <li><a href="../property/findAllProperty" ><i class="fa fa-database fa-fw"></i>物业收费管理</a></li>
            <li><a href="../park/findAllPark" ><i class="fa fa-map-marker fa-fw"></i>停车场信息管理</a></li>
            <li><a href="../household/findAllHousehold" ><i class="fa fa-users fa-fw"></i>住户信息管理</a></li>
            <li><a href="findAllRepair"  class="active"><i class="fa fa-sliders fa-fw"></i>住户报修管理</a></li>
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
		          <h2 class="margin-bottom-10">住户报修信息</h2>
            		<p>>>修改</p>
		          
			           <form  action="updateRepair" class="templatemo-login-form" method="post" enctype="multipart/form-data">
			              <div class="row form-group">
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="id">ID</label>
				                    <input type="text" class="form-control" id="id" name="dpmsRepair.id"  value="${dpmsRepair.id}" readonly="readonly">                  
				                </div>		               
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="holdName">户主姓名</label>
				                    <input type="text"  class="form-control" id="holdName" name="dpmsRepair。dpmsHousehold.holdName" value="${dpmsRepair.dpmsHousehold.holdName}" readonly="readonly">                  
				                </div> 
 						  </div>
			               <div class="row form-group">
			               		 <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="relateRealEstate">所属楼栋</label>
				                    <input type="number" min="0" class="form-control" id="relateRealEstate" name="dpmsRepair。dpmsHousehold.relateRealEstate" value="${dpmsRepair.dpmsHousehold.relateRealEstate}" readonly="readonly" >                 
				                </div> 
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="relateUnit">所属单元</label>
				                    <input type="number" class="form-control" min="0" id="relateUnit" name="dpmsRepair.dpmsHousehold。relateUnit" value="${dpmsRepair.dpmsHousehold.relateUnit}" readonly="readonly">                  
				                </div>      
			               </div>
			               <div class="row form-group">
			               		<div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="relateFloor">所属层数</label>
				                    <input type="number" min="0" class="form-control" id="relateFloor" name="dpmsRepair.dpmsHousehold。relateFloor" value="${dpmsRepair.dpmsHousehold.relateFloor}" readonly="readonly">                 
				                </div>
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="relateNo">门牌号</label>
				                    <input type="number"min="0" class="form-control" id="relateNo"  name="dpmsRepair.dpmsHousehold。relateNo"  value="${dpmsRepair.dpmsHousehold.relateNo}" readonly="readonly">                  
				                </div>  
			               </div>		            
			                <div class="row form-group">
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="holdPhone">户主电话</label>
				                    <input type="text" class="form-control" id="holdPhone"  name="dpmsRepair.dpmsHousehold.holdPhone" value="${dpmsRepair.dpmsHousehold.holdPhone}" readonly="readonly">                  
				                </div>
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="repariDate">报修时间</label>
				                    <input type="text" class="form-control" id="repariDate"  name="dpmsRepair.repairDate" value="${dpmsRepair.repairDate}" readonly="readonly">                  
				                </div>       
			               </div>
							<div class="row form-group">
								<div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="sparePhone">备用电话</label>
				                    <input type="text" class="form-control" id="phone"  name="dpmsRepair.sparePhone" value="${dpmsRepair.sparePhone}">                  
				                </div>  
				                <div class="col-lg-6 col-md-6 form-group">  
								 <label class="control-label templatemo-block">是否处理</label>                 
					                 <select name="dpmsRepair.isDeal" class="form-control">
					                    <option value="是" <c:if test='${dpmsRepair.isDeal=="是"}'>selected</c:if> >是</option>
					                    <option value="否" <c:if test='${dpmsRepair.isDeal=="否"}'>selected</c:if> >否</option>
					                  </select> 
					            </div>
							</div>
						  <div class="row form-group">
				                <div class="col-lg-12 form-group">                   
				                    <label class="control-label" for="details">报修详情</label>
				                    <textarea class="form-control" id="details" name="dpmsRepair.details" rows="3"  required="required">${dpmsRepair.details}</textarea>
				                </div>
				          </div>
			              <div class="form-group text-right">
			                <button type="submit" class="templatemo-blue-button">更改</button>
			                <button type="reset" class="templatemo-white-button">重置</button>
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