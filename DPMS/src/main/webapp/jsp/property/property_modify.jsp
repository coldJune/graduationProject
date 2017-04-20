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
			if($('#isNecessary').val()=='是'){
				$('#cyclediv').show();
				$('#cycle').attr('required','required');
			}else{
				$('#cyclediv').hide();
				$('#cycle').val('');
				$('#cycle').removeAttr('required')

			}
			
			var standard=$('#standard').val();
			var standardPrice=standard.split('(')[0];
			var standardUnit=standard.split('(')[1].replace(')','');
			$('#standardPrice').val(standardPrice);
			$('#standardUnit').val(standardUnit);
			$('#isNecessary').change(function(){
				if($(this).val()=='是'){
					$('#cyclediv').show();
					$('#cycle').attr('required','required');
				}else{
					$('#cyclediv').hide();
					$('#cycle').val('');
					$('#cycle').removeAttr('required');
				}
			});
			$('#standardPrice').blur(function(){
				$('#standard').val($(this).val()+'('+$('#standardUnit').val()+')');
			});
			$('#standardUnit').blur(function(){
				$('#standard').val($('#standardPrice').val()+'('+$(this).val()+')');
			});
			
			$('#propertyName').blur(function(){
				$.ajax({
					url:'checkPropertyName',
					data:{'dpmsPropertyCharge.propertyName':$(this).val()},
					type:'post',
					dataType:'json',
					success:function(response){
						if(response!=null){
							alert(response.msg);
							$('#propertyName').val('');
						}
					}
				});			
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
		          <h2 class="margin-bottom-10">物业收费信息</h2>
            		<p>>>修改</p>
		          
			            <form  action="updatePropertyCharge" class="templatemo-login-form" method="post" enctype="multipart/form-data">
			              <div class="row form-group">	               
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="propertyName">项目名称</label>
				                    <input type="text" class="form-control" id="propertyName" name="dpmsPropertyCharge.propertyName" value="${dpmsPropertyCharge.propertyName }" readonly="readonly" required="required">                  
				                </div>
				                <div class="col-lg-6 col-md-6 form-group">  
				                     <label class="control-label templatemo-block">是否必须</label>                 
					                 <select name="dpmsPropertyCharge.isNecessary" class="form-control" id="isNecessary" required="required">
					                    <option value="是" <c:if test="${dpmsPropertyCharge.isNecessary=='是' }">selected</c:if> >是</option>
					                    <option value="否" <c:if test="${dpmsPropertyCharge.isNecessary=='否' }">selected</c:if>>否</option>
					                  </select>                  
				                </div> 
				                    
 						  </div>
			              <div class="row form-group">
			              	 
			               		
				               
			               </div>
			               <div class="row form-group">   
					             <input   type="text" id="standard" name="dpmsPropertyCharge.standard" min="0" hidden="true" value="${dpmsPropertyCharge.standard}" required="required">                  
					             <div class="col-lg-6 col-md-6 form-group" id="cyclediv" hidden="true">                  
				                    <label for="cycle">收费周期(天)</label>
				                    <input type="number" min="0" class="form-control"  id="cycle" name="dpmsPropertyCharge.cycle" value="${dpmsPropertyCharge.cycle }" required="required" >                  
				                </div>
					            
						            <div class="col-lg-6 col-md-6 form-group">
						            	 <label for="standarddiv"><strong>收费标准</strong></label>
					           			 <div class="row form-group" id="standarddiv"> 
						            	<div class="col-lg-3 col-md-3 form-group">                  
						                    <label for="standardPrice">收取单价(元)</label>
						                    <input type="number"  class="form-control" id="standardPrice"  required="required">                  
							            </div>
							            <div class="col-lg-3 col-md-3 form-group">                  
							                    <label for="standardUnit">单位</label>
							                    <input type="text"  class="form-control" id="standardUnit"  required="required">                  
							            </div>
						            </div>
					            </div>
				          </div>
				          <div class="row form-group">
			              	 
			               		<div class="col-lg-6 col-md-6 form-group" >                  
				                    <label for="createPerson">创建人</label>
				                    <input type="text" min="0" class="form-control"  id="createPerson" name="dpmsPropertyCharge.createPerson" value="${dpmsPropertyCharge.createPerson }" readonly="readonly" >                  
				                </div>
				               <div class="col-lg-6 col-md-6 form-group" >                  
				                    <label for="createDate">创建时间</label>
				                    <input type="text" min="0" class="form-control"  id="createDate" name="dpmsPropertyCharge.createDate" value="${dpmsPropertyCharge.createDate }" readonly="readonly">                  
				                </div>
			               </div>
			               <div class="row form-group">
			              	 
			               		<div class="col-lg-6 col-md-6 form-group"  >                  
				                    <label for="modifyPerson">上一次修改人</label>
				                    <input type="text" min="0" class="form-control"  id="modifyPerson" name="dpmsPropertyCharge.modifyPerson" value="${dpmsPropertyCharge.modifyPerson }" readonly="readonly">                  
				                </div>
				               <div class="col-lg-6 col-md-6 form-group" >                  
				                    <label for="modifyDate">上一次修改时间</label>
				                    <input type="text" min="0" class="form-control"  id="modifyDate" name="dpmsPropertyCharge.modifyDate" value="${dpmsPropertyCharge.modifyDate }"  readonly="readonly" >                  
				                </div>
			               </div>
							<div class="row form-group">
				                <div class="col-lg-12 form-group">                   
				                    <label class="control-label" for="remark">项目详细描述</label>
				                    <textarea class="form-control" id="remark" name="dpmsPropertyCharge.remark" rows="3"  required="required">${dpmsPropertyCharge.remark}</textarea>
				                </div>
				          </div>
				          
			              <div class="form-group text-right">
			                <button type="submit" class="templatemo-blue-button">修改</button>
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