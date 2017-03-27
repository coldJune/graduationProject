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
    <link href="../css/templatemo-style-show.css" rel="stylesheet">
    <link href="../css/table.css" rel="stylesheet">
    <script type="text/javascript" src="../jQuery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="../js/default.js"></script>
    <script type="text/javascript">
    	$(document).ready(function(){
    		$('#del').click(function(){
    			var estateNos=[];
    			$('input:checkbox[name=check]:checked').each(function(){
    				estateNos.push($(this).val());
    			});
    			if(estateNos==null){
    				alert('请选择删除的内容');
    			}else{
        			$.ajax({
        				type:'post',
        				url:'delRealEstate',
        				data:{'estateNos':estateNos},
        				traditional:true,
        				async: false,
        				success:function(){
        					alert('删除成功');
        					window.location.href='findAllRealEstate';
        				},
        				failure:function(){
        					alert('删除失败');
        				}
        			});
    			}

    		});
    	});
    </script>
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
            <li><a href="#"><i class="fa fa-database fa-fw"></i>物业收费管理</a></li>
            <li><a href="findAllPark" class="active"><i class="fa fa-map-marker fa-fw" ></i>停车场信息管理</a></li>
            <li><a href="../household/findAllHousehold" ><i class="fa fa-users fa-fw"></i>住户信息管理</a></li>
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
	           		<h2 class="margin-bottom-10"><strong>停车场信息</strong></h2>
            			<p><i>>>查询结果</i></p>
	          		<div style="margin: 0 auto;">
			             <div class="form-group text-left" style="width:60%;float: left;height:40px">
					          <form class="templatemo-search-form" role="search" style="width: 50%" method="post" action="searchPark">
				          		<div class="input-group" >
				              		<button type="submit" class="fa fa-search"></button>
				              		<input type="text" class="form-control" placeholder="请输入车牌号" name="dpmsPark.plateNumber" id="srch-term">
				         		 </div>
				        	  </form>
			        	 </div>
			        	<div class="form-group text-right" style="width: 40%;float: right;">
				                <button id="del" type="button" class="templatemo-blue-button">删除</button>
				       	</div>
	          		</div>
	            <div class="panel panel-default table-responsive" style="width: 100%;">
	              <table class="table table-bordered templatemo-user-table">
	                <thead>
	                  <tr>
	                     <td class="white-text"><i>删除数据</i></td>
	                    <td class="white-text">ID</td>
	                    <td class="white-text">车牌号</td>
	                    <td class="white-text">停车费用</td>
	                    <td class="white-text">入库时间</td>
	                    <td class="white-text">离开时间</td>
	                   	<td class="white-text">收费</td>

	                  	
	                  </tr>
	                </thead>
	                <tbody>
						<c:forEach items="${dpmsParks}" var="dpmsPark">
							<tr>
								<td style="text-align: center;" >
									<div style="z-index: 2px;">
										<div class="margin-right-15 templatemo-inline-block" style="z-index: 1px;">
	                      					<input type="checkbox" name="check" id="${dpmsPark.id}" value="${dpmsPark.id}">
	                     					 <label  for="${dpmsPark.id}" class="font-weight-400"><span></span></label>                      
	                    				</div>
                    				</div>
                    			</td>
                  				<td style="text-align: center;">${dpmsPark.id}</td>
								<td style="text-align: center;"><a href="showDetailPark?plateNumber=${dpmsPark.plateNumber}" style="color:blue;text-decoration: underline;" class="templatemo-sort-by"><i>${dpmsPark.plateNumber}</i></a></td>
								<td style="text-align: center;">${dpmsPark.price}</td>
								<td style="text-align: center;">${dpmsPark.startTime}</td>
								<td style="text-align: center;">${dpmsPark.endTime}</td>
								<c:choose>
									<c:when test="${dpmsPark.isCharge=='是'}">
										<td style="text-align: center;"><a href="" class="templatemo-edit-btn">已收费</a></td>
									</c:when>
									<c:when test="${dpmsPark.dpmsHousehold.hasPackin=='是'&&dpmsPark.dpmsHousehold.plateNumber==dpmsPark.plateNumber}">
										<td style="text-align: center;"><a href="" class="templatemo-edit-btn">离场</a></td>
									</c:when>
									<c:otherwise>
										<td style="text-align: center;"><a href="" class="templatemo-edit-btn">收费</a></td>
									</c:otherwise>
								</c:choose>
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