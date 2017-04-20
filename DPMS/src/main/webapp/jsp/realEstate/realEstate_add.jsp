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
    <script type="text/javascript">
    $(document).ready(function(){
    	$('#estateNo').blur(function(){
    		$.ajax({
				url:'/DPMS/realEstate/checkByEstateNo',
				type:'post',
				data:{estateNo:$(this).val()},
				dataType:'json',
				success:function(data){
					if(data.msg=='false'){
						alert('楼栋已存在');
						$('#estateNo').val('');
						return false;
					}
				}
    		});
    	});
    	$('#roomInNo').blur(function(){
			var roomNo=$('#roomNo').val();
			var roomInNo=$(this).val();
			if(roomInNo>roomNo){
				alert("已售套数应小于总套数");
				$(this).val('');
			}			
		});
    });
    	
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
          <img src="/DPMS/sysUser/showHead"  alt="头像" class="img-responsive"> 
         <div class="profile-photo-overlay" ></div>
        </a> 
        </div>
                <div class="mobile-menu-icon">
            	<i class="fa fa-bars"></i>
        </div>
        <nav class="templatemo-left-nav">          
          <ul>
            
           <li><a href="findAllRealEstate" class="active"><i class="fa fa-bar-chart fa-fw"></i>楼盘信息管理</a></li>
            <li><a href="../property/findAllProperty" ><i class="fa fa-database fa-fw"></i>物业收费管理</a></li>
            <li><a href="../park/findAllPark" ><i class="fa fa-map-marker fa-fw"></i>停车场信息管理</a></li>
            <li><a href="../household/findAllHousehold" ><i class="fa fa-users fa-fw"></i>住户信息管理</a></li>
            <li><a href="../repair/findAllRepair"><i class="fa fa-sliders fa-fw"></i>住户报修管理</a></li>
            <li><a href="../complain/findAllComplain" ><i class="fa fa-question fa-fw"></i>住户投诉管理</a></li>
            <% 
          	 if(sess.equalsIgnoreCase("ROOT")){
          %>
            <li><a href="。。/sysUser/findAllSysUser"><i class="fa fa-home fa-fw"></i>系统用户管理</a></li>
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
		          <h2 class="margin-bottom-10">楼盘信息</h2>
            		<p>>>添加</p>
		          
			            <form  action="addRealEstate" class="templatemo-login-form" method="post" enctype="multipart/form-data">
			              <div class="row form-group">	               
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="estateNo">楼栋编号</label>
				                    <input type="number" min="0" class="form-control" id="estateNo" name="estateNo" value="${dpmsRealEstate.estateNo}" required="required">                  
				                </div>
				                 <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="floorNo">层数</label>
				                    <input type="number"  class="form-control" id="floorNo" name="floorNo" min="0"  value="${dpmsRealEstate.floorNo}" required="required">                  
				                </div>   
 						  </div>
			              <div class="row form-group">
			               		<div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="roomNo">套数</label>
				                    <input type="number" min="0" class="form-control" id="roomNo" name="roomNo" value="${dpmsRealEstate.roomNo}" required="required">                  
				                </div>
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="roomInNo">已售套数</label>
				                    <input type="number" min="0" class="form-control" id="roomInNo" name="roomInNo" value="${dpmsRealEstate.roomInNo}" required="required">                 
				                </div>
				               
			               </div>

			               <div class="row form-group">
			               		<div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="elevatorNo">电梯台数</label>
				                    <input type="number" min="0" class="form-control" id="elevatorNo" name="elevatorNo" value="${dpmsRealEstate.elevatorNo}" required="required">                  
				                </div>
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="unitNo">单元数</label>
				                    <input type="number"min="0" class="form-control" id="unitNo"  name="unitNo"  value="${dpmsRealEstate.unitNo}" required="required">                  
				                </div>  
				                
				               
			               </div>
			               <div class="row form-group">
				                <div class="col-lg-6 col-md-6 form-group">  
				                     <label class="control-label templatemo-block">是否有门禁</label>                 
					                 <select name="hasDoor" class="form-control">
					                    <option value="是" selected>是</option>
					                    <option value="否" >否</option>
					                  </select>                  
				                </div>
				               <div class="col-lg-6 col-md-6 form-group">  
				                     <label class="control-label templatemo-block">是否通燃气</label>                 
					                 <select name="hasGas" class="form-control">
					                    <option value="是" selected>是</option>
					                    <option value="否" >否</option>
					                  </select>                  
				                </div>   
			              </div>
			               <div class="row form-group">
			                	<div class="col-lg-6 col-md-6 form-group">  
				                     <label class="control-label templatemo-block">是否有宽带</label>                 
					                 <select name="hasBordhand" class="form-control">
					                    <option value="是" selected>是</option>
					                    <option value="否" >否</option>
					                  </select>                  
				                </div> 
				                
			               </div>
			                <div class="row form-group">
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="relatePerson">负责人</label>
				                    <input type="text" class="form-control" id="relatePerson"  name="relatePerson" value="${dpmsRealEstate.relatePerson}" required="required">                  
				                </div>
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="phone">负责人电话</label>
				                    <input type="text" class="form-control" id="phone"  name="phone" value="${dpmsRealEstate.phone}" required="required">                  
				                </div>  
				                
			               </div>

			              <div class="form-group text-right">
			                <button type="submit" class="templatemo-blue-button">添加</button>
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