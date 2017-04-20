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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/default.js"></script>

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
            <li><a href="findAllProperty" class="active"><i class="fa fa-database fa-fw"></i>物业收费管理</a></li>
            <li><a href="../park/findAllPark" ><i class="fa fa-map-marker fa-fw"></i>停车场信息管理</a></li>
            <li><a href="../household/findAllHousehold" ><i class="fa fa-users fa-fw"></i>住户信息管理</a></li>
            <li><a href="../repair/findAllRepair"><i class="fa fa-sliders fa-fw"></i>住户报修管理</a></li>
            <li><a href="../complain/findAllComplain" ><i class="fa fa-question fa-fw"></i>住户投诉管理</a></li>
             <% 
          	 if(sess.equalsIgnoreCase("ROOT")){
          %>
            <li><a href="。。/sysUser/findAllSysUser"><i class="fa fa-home fa-fw"></i>系统用户管理</a></li>
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
	    		
	          <div class="templatemo-content-widget white-bg">
		          <h2 class="margin-bottom-10">物业收费信息</h2>
            		<p>>>缴费详情</p>
		          
			            <form  action="addChargeHis" class="templatemo-login-form" method="post" enctype="multipart/form-data">
			              <div class="row form-group">	     
					            <input   type="number"  name="dpmsPropertyChargeHis.dpmsPropertyCharge.id" min="0" hidden="true" value="${dpmsPropertyChargeHis.dpmsPropertyCharge.id}" required="required">
					            <input   type="text"  name="dpmsPropertyChargeHis.dpmsPropertyCharge.isNecessary" min="0" hidden="true" value="${dpmsPropertyChargeHis.dpmsPropertyCharge.isNecessary}" required="required">
			                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="propertyName">项目名称</label>
				                    <input type="text" class="form-control" id="propertyName" name="dpmsPropertyChargeHis.dpmsPropertyCharge.propertyName" value="${dpmsPropertyChargeHis.dpmsPropertyCharge.propertyName }" readonly="readonly" required="required">                  
				                </div>
 						  </div>
			               <div class="row form-group">   
					             <input   type="text" id="standard" name="dpmsPropertyChargeHis.dpmsPropertyCharge.standard" min="0" hidden="true" value="${dpmsPropertyChargeHis.dpmsPropertyCharge.standard}"  readonly="readonly" required="required">
					            
						            <div class="col-lg-6 col-md-6 form-group">
						            	 <label for="standarddiv"><strong>收费标准</strong></label>
					           			 <div class="row form-group" id="standarddiv"> 
						            	<div class="col-lg-3 col-md-3 form-group">                  
						                    <label for="standardPrice">收取单价(元)</label>
						                    <input type="text"  class="form-control" id="standardPrice" readonly="readonly" required="required">                  
							            </div>
							            <div class="col-lg-3 col-md-3 form-group">                  
							                    <label for="standardUnit">单位</label>
							                    <input type="text"  class="form-control" id="standardUnit" readonly="readonly" required="required">                  
							            </div>
						            </div>
					            </div>
				          </div>
				      	 <div class="row form-group">
				      	 <input   type="number" name="dpmsPropertyChargeHis.dpmsHousehold.id" min="0" hidden="true" value="${dpmsPropertyChargeHis.dpmsHousehold.id}" readonly="readonly"  required="required">
				      		  <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="holdName">户主姓名</label>
				                    <input type="text"  class="form-control" id="holdName" name="dpmsPropertyChargeHis.dpmsHousehold.holdName" value="${dpmsPropertyChargeHis.dpmsHousehold.holdName}" readonly="readonly">                  
				                </div>
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="holdPhone">户主电话</label>
				                    <input type="text" class="form-control" id="phone"  name="dpmsPropertyChargeHis.dpmsHousehold.holdPhone" value="${dpmsPropertyChargeHis.dpmsHousehold.holdPhone}" readonly="readonly"  required="required">                  
				                </div>
				                
				            </div>			               
				          			               
				          <div class="row form-group">
			               		 <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="relateRealEstate">所属楼栋</label>
				                    <input type="text" min="0" class="form-control" id="relateRealEstate" name="dpmsPropertyChargeHis.dpmsHousehold.relateRealEstate" value="${dpmsPropertyChargeHis.dpmsHousehold.relateRealEstate}" readonly="readonly" >                 
				                </div> 
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="relateUnit">所属单元</label>
				                    <input type="text" class="form-control" min="0" id="relateUnit" name="dpmsPropertyChargeHis.dpmsHousehold.relateUnit" value="${dpmsPropertyChargeHis.dpmsHousehold.relateUnit}" readonly="readonly">                  
				                </div>      
			               </div>
			               <div class="row form-group">
			               		<div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="relateFloor">所属层数</label>
				                    <input type="text" min="0" class="form-control" id="relateFloor" name="dpmsPropertyChargeHis.dpmsHousehold.relateFloor" value="${dpmsPropertyChargeHis.dpmsHousehold.relateFloor}" readonly="readonly">                 
				                </div>
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="relateNo">门牌号</label>
				                    <input type="text"min="0" class="form-control" id="relateNo"  name="dpmsPropertyChargeHis.dpmsHousehold.relateNo"  value="${dpmsPropertyChargeHis.dpmsHousehold.relateNo}" readonly="readonly" >                  
				                </div>     
			               </div>
			                <div class="row form-group">
			                	<div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="area">面积</label>
				                    <input type="text"min="0" class="form-control" id="area"  name="dpmsPropertyChargeHis.dpmsHousehold.area"  value="${dpmsPropertyChargeHis.dpmsHousehold.area}" readonly="readonly" >                  
				                </div>
				                 <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="price">共缴费用(元)</label>
				                    <input type="text" class="form-control" id="price" name="dpmsPropertyChargeHis.price" value="${dpmsPropertyChargeHis.price}"  readonly="readonly" >                 
				                </div> 
				            </div>  
			               <div class="row form-group">
			               		 <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="opPerson">操作人</label>
				                    <input type="text" class="form-control" id="opPerson" name="dpmsPropertyChargeHis.opPerson" value="${dpmsPropertyChargeHis.opPerson}"  readonly="readonly" >                 
				                </div> 
				                 <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="opPhone">操作人联系方式</label>
				                    <input type="text" class="form-control" id="price" name="dpmsPropertyChargeHis.opPhone" value="${dpmsPropertyChargeHis.opPhone}" readonly="readonly"  >                 
				                </div> 
			               </div>
			              
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