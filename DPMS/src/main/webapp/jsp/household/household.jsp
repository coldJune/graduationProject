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
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/templatemo-style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/jQuery/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/default.js"></script>
    <script type="text/javascript">
    	$(document).ready(function(){
    		$('#del').click(function(){
    			var ids=[];
    			$('input:checkbox[name=check]:checked').each(function(){
    				ids.push($(this).val());
    			});
    			if(ids==null){
    				alert('请选择删除的内容');
    			}else{
        			$.ajax({
        				type:'post',
        				url:'delHousehold',
        				data:{'ids':ids},
        				traditional:true,
        				async: false,
        				success:function(){
        					alert('删除成功');
        					window.location.reload();
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
            <li><a href="../property/findAllProperty"><i class="fa fa-database fa-fw"></i>物业收费管理</a></li>
            <li><a href="../park/findAllPark"><i class="fa fa-map-marker fa-fw"></i>停车场信息管理</a></li>
            <li><a href="findAllHousehold" class="active"><i class="fa fa-users fa-fw"></i>住户信息管理</a></li>
            <li><a href="../repair/findAllRepair"><i class="fa fa-sliders fa-fw"></i>住户报修管理</a></li>
            <li><a href="../complain/findAllComplain" ><i class="fa fa-question fa-fw"></i>住户投诉管理</a></li>
            <% 
          	 if(sess.equalsIgnoreCase("ROOT")){
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
	           		<div style="width: 150px;margin: 0 auto;font-size: 18px;"><p><strong>住户信息</strong></p></div>
	          		<div style="margin: 0 auto;">
			             <div class="form-group text-left" style="width:60%;float: left;height:40px">
					          <form class="templatemo-search-form" role="search" style="width: 50%" method="post" action="searchHousehold">
				          		<div class="input-group" >
				              		<button type="submit" class="fa fa-search"></button>
				              		<input type="text" class="form-control" placeholder="请输入户主名" name="dpmsHousehold.holdName" id="srch-term">
				         		 </div>
				        	  </form>
			        	 </div>
			        	<div class="form-group text-right" style="width: 40%;float: right;">
				                <a href="addBHousehold"><button type="button" class="templatemo-blue-button" >添加</button></a>
				                <button id="del" type="button" class="templatemo-white-button">删除</button>
				       	</div>
	          		</div>
	            <div class="panel panel-default table-responsive" style="width: 100%;">
	              <table class="table table-bordered templatemo-user-table">
	                <thead>
	                  <tr>
	                    <td class="white-text"><i>删除数据</i></td>
	                    <td class="white-text">ID</td>
	                    <td class="white-text">户主名称</td>
	                    <td class="white-text">户主性别</td>
	                    <td class="white-text">户主年龄</td>
	                    <td class="white-text">家庭人数</td>
	                    <td class="white-text">面积(平方米)</td>
	                    <td class="white-text">是否有购买车位</td>
	                     <td class="white-text">车牌号</td>
	                    <td class="white-text">所属楼栋</td>
	                    <td class="white-text">所属层数</td>
	                    <td class="white-text">所属单元</td>
	                    <td class="white-text">门牌号</td>
	                    <td class="white-text">户主电话</td>
	                    <td class="white-text">入住时间</td>	                  	
	                  </tr>
	                </thead>
	                <tbody>
						<c:forEach items="${dpmsHouseholds}" var="dpmsHousehold">
							<tr>
								<td>
									<div style="z-index: 2px;">
										<div class="margin-right-15 templatemo-inline-block" style="z-index: 1px;">
	                      					<input type="checkbox" name="check" id="${dpmsHousehold.id}" value="${dpmsHousehold.id}">
	                     					 <label for="${dpmsHousehold.id}" class="font-weight-400"><span></span></label>                      
	                    				</div>
                    				</div>
                    			</td>
								<td style="text-align: center;"><a href="showDetailHousehold?dpmsHousehold.id=${dpmsHousehold.id}" style="color:blue;text-decoration: underline;" class="templatemo-sort-by"><i>${dpmsHousehold.id}</i></a></td>
								<td style="text-align: center;">${dpmsHousehold.holdName}</td>
								<td style="text-align: center;">${dpmsHousehold.holdGender}</td>
								<td style="text-align: center;">${dpmsHousehold.holdAge}</td>
								<td style="text-align: center;">${dpmsHousehold.familyNo}</td>
								<td style="text-align: center;">${dpmsHousehold.area}</td>
								<td style="text-align: center;">${dpmsHousehold.hasPackin}</td>
								<td style="text-align: center;">${dpmsHousehold.plateNumber}</td>
								<td style="text-align: center;">${dpmsHousehold.relateRealEstate}</td>
								<td style="text-align: center;">${dpmsHousehold.relateUnit}</td>
								<td style="text-align: center;">${dpmsHousehold.relateFloor}</td>
								<td style="text-align: center;">${dpmsHousehold.relateNo}</td>
								<td style="text-align: center;">${dpmsHousehold.holdPhone}</td>
								<td style="text-align: center;">${dpmsHousehold.checkInDate}</td>
							</tr>
						</c:forEach>                
	                </tbody>
	              </table>    
	            </div>                          
	          </div>  
	          <jsp:include page="household_footer.jsp"></jsp:include>
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