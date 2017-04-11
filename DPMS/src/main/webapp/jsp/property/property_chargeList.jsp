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
        <div class="profile-photo-container">
          <img src="images/profile-photo.jpg" alt="Profile Photo" class="img-responsive">  
          <div class="profile-photo-overlay"></div>
        </div>
                <div class="mobile-menu-icon">
            <i class="fa fa-bars"></i>
        </div>
        <nav class="templatemo-left-nav">          
          <ul>
          <% String sess=(String)session.getAttribute("USERNAME");
          	 if(sess=="root"){
          %>
            <li><a href="../sysUser/findAllSysUser" ><i class="fa fa-home fa-fw"></i>系统用户管理</a></li>
          <%} %>
           <li><a href="../realEstate/findAllRealEstate" ><i class="fa fa-bar-chart fa-fw"></i>楼盘信息管理</a></li>
            <li><a href="findAllProperty" class="active"><i class="fa fa-database fa-fw"></i>物业收费管理</a></li>
            <li><a href="../park/findAllPark" ><i class="fa fa-map-marker fa-fw"></i>停车场信息管理</a></li>
            <li><a href="../household/findAllHousehold" ><i class="fa fa-users fa-fw"></i>住户信息管理</a></li>
            <li><a href="../repair/findAllRepair"><i class="fa fa-sliders fa-fw"></i>住户报修管理</a></li>
            <li><a href="../complain/findAllComplain" ><i class="fa fa-question fa-fw"></i>住户投诉管理</a></li>
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
	           		<div style="width: 200px;margin: 0 auto;font-size: 18px;"><p><strong>物业收费信息(收费列表)</strong></p></div>
	            <div class="panel panel-default table-responsive" style="width: 100%;">
	              <table class="table table-bordered templatemo-user-table">
	                <thead>
	                  <tr>
	                    <td class="white-text" style="text-align: center;"><i>需缴费人</i></td>   
	                    <td class="white-text" style="text-align: center;"><i>所属楼栋</i></td>
	                    <td class="white-text" style="text-align: center;"><i>所属单元</i></td>
	                    <td class="white-text" style="text-align: center;"><i>所属楼层</i></td>   
	                    <td class="white-text" style="text-align: center;"><i>门牌号</i></td>   
	                    <td class="white-text" style="text-align: center;"><i>缴费项目</i></td>
	                    <td class="white-text" style="text-align: center;"><i>操作</i></td>              	
	                  </tr>
	                </thead>
	                <tbody>
						<c:forEach items="${dpmsPropertyChargeHiss}" var="dpmsPropertyChargeHis">
							<tr>
								<td style="text-align: center;">${dpmsPropertyChargeHis.dpmsHousehold.holdName }</td>
								<td style="text-align: center;">${dpmsPropertyChargeHis.dpmsHousehold.relateRealEstate }</td>
								<td style="text-align: center;">${dpmsPropertyChargeHis.dpmsHousehold.relateUnit }</td>
								<td style="text-align: center;">${dpmsPropertyChargeHis.dpmsHousehold.relateFloor }</td>
								<td style="text-align: center;">${dpmsPropertyChargeHis.dpmsHousehold.relateNo }</td>
								<td style="text-align: center;">${dpmsPropertyChargeHis.dpmsPropertyCharge.propertyName }</td>
								<td style="text-align: center;"><a href="chargeDetail?dpmsPropertyChargeHis.dpmsHousehold.id=${dpmsPropertyChargeHis.dpmsHousehold.id}&dpmsPropertyChargeHis.dpmsPropertyCharge.propertyName=${dpmsPropertyChargeHis.dpmsPropertyCharge.propertyName }"  class="templatemo-edit-btn" >收费</a></td>
							</tr>
						</c:forEach>                
	                </tbody>
	              </table>    
	            </div>                          
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