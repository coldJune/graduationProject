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
    <script type="text/javascript" src="../jQuery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="../js/default.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
		var relateFloor='';
		var relateUnit='';	
    	$.ajax({
    		type:'post',
    		url:'../sys/searchRelate',
    		data:{'searchOperate':'searRealEstate'},
    		success:function(data){
    			var option='';
    			var estateNos=data.estateNos;
    			$.each(estateNos,function(index,estateNo){
    				option+="<option id='"+estateNo+"' value='"+estateNo+"'>"+estateNo+"栋</option>";
    			});
    			$('#relateRealEstate').append(option);
    		}
    	});
    	
    	$('#relateRealEstate').change(function(){
    		$.ajax({
    			type:'post',
    			url:'../sys/searchRelate',
    			data:{'searchOperate':'searchUnitAndFloor','relateRealEstate':$('#relateRealEstate').val()},
    			success:function(data){
    				var optionUnit='';
    				var optionFloor=''
    				var unitAndfloor=data.unitAndfloor;
    				relateUnit=unitAndfloor[0][0];
    				relateFloor=unitAndfloor[0][1];
    				for(var i=1;i<=relateUnit;i++){
    					optionUnit+="<option id='"+i+"' value='"+i+"'>"+i+"单元</option>";
    				}
    				$('#relateUnit').append(optionUnit);
    				for(var j=1;j<=relateFloor;j++){
    					optionFloor+="<option id='"+j+"' value='"+j+"'>第"+j+"层</option>"
    				}
    				$('#relateFloor').append(optionFloor);
    			}
    		});
    	});
    	
    	$('#relateFloor').change(function(){
    		var option='';
    		for(var i=1;i<=8;i++){
    			option+="<option id='"+$(this).val()+'0'+i+"' value='"+$(this).val()+'0'+i+"'>"+$(this).val()+'0'+i+"</option>"
    		}
    		$('#relateNo').append(option);
    	});
    	
    	$('#relateNo').change(function(){
    		$.ajax({
    			type:'post',
    			data:{
    				'dpmsHousehold.relateRealEstate':$('#relateRealEstate').val(),
    				'dpmsHousehold.relateUnit':$('#relateUnit').val(),
    				'dpmsHousehold.relateFloor':$('#relateFloor').val(),
    				'dpmsHousehold.relateNo':$('#relateNo').val()
    			},
    			url:'checkRelate',
    			success:function(data){
    				if(data.msg=='false'){
    					alert("请选择正确的房间");
    					$('#relateRealEstate').val('');
    					$('#relateUnit').empty();
    					$('#relateUnit').append('<option value="" selected>---请选择单元---</option>');
    					$('#relateFloor').empty();
    					$('#relateFloor').append('<option value="" selected>---请选择楼层---</option>');
    					$('#relateNo').empty();
    					$('#relateNo').append('<option value="" selected>---门牌号---</option>');
    				}
    			}
    		});
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
            <li><a href="../property/findAllProperty"><i class="fa fa-database fa-fw"></i>物业收费管理</a></li>
            <li><a href="../park/findAllPark"><i class="fa fa-map-marker fa-fw"></i>停车场信息管理</a></li>
            <li><a href="findAllHousehold" class="active"><i class="fa fa-users fa-fw"></i>住户信息管理</a></li>
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
		          <h2 class="margin-bottom-10">住户信息</h2>
            		<p>>>添加</p>
		          
			            <form  action="addHousehold" class="templatemo-login-form" method="post" enctype="multipart/form-data">
			              <div class="row form-group">	               
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="holdName">户主名字</label>
				                    <input type="text" min="0" class="form-control" id="holdName" name="dpmsHousehold.holdName"  required="required">                  
				                </div>
								<div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="holdAge">户主年龄</label>
				                    <input type="number"  class="form-control" id="holdAge" name="dpmsHousehold.holdAge" min="0" required="required">                  
				                </div> 		                 
 						  </div>
			              <div class="row form-group">
			               		<div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="area">面积</label>
				                    <input type="number"  class="form-control" id="area" name="dpmsHousehold.area" min="0"  value="${dpmsHousehold.area}" required="required">                  
				                </div>  
				               <div class="col-lg-6 form-group">                   
				                    <div class="margin-right-15 templatemo-inline-block">
				                      <input type="radio" name="dpmsHousehold.holdGender" id="r4" value="男" checked="checked">
				                      <label for="r4" class="font-weight-400"><span></span>男</label>
				                    </div>
				                    <div class="margin-right-15 templatemo-inline-block">
				                      <input type="radio" name="dpmsHousehold.holdGender" id="r5" value="女">
				                      <label for="r5" class="font-weight-400"><span></span>女</label>
				                    </div>
               					 </div>
					               
			               </div>
							 <div class="row form-group">
			              
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="phone">户主电话</label>
				                    <input type="text" class="form-control" id="phone"  name="dpmsHousehold.holdPhone" required="required">                  
				                </div> 
				            	<div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="plateNumber">车牌号</label>
				                    <input type="text" class="form-control" id="plateNumber"  name="dpmsHousehold.plateNumber" >                  
				                </div> 
				                
			               </div>
			               <div class="row form-group">
			               		<div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="familyNo">家庭人数</label>
				                    <input type="number" min="0" class="form-control" id="familyNo" name="dpmsHousehold.familyNo"  required="required">                  
				                </div>
				               <div class="col-lg-6 col-md-6 form-group">  
				                     <label class="control-label templatemo-block">是否有停车位</label>                 
					                 <select name="dpmsHousehold.hasPackin" class="form-control">
					                    <option value="是" selected>是</option>
					                    <option value="否" >否</option>
					                  </select>                  
				                </div>
				                
				               
			               </div>
			               <div class="row form-group">
				                <div class="col-lg-6 col-md-6 form-group">  
				                     <label class="control-label templatemo-block">所属楼栋</label>                 
					                 <select id="relateRealEstate" name="dpmsHousehold.relateRealEstate" class="form-control" required="required">
					                    <option value="" selected>---请选择楼栋---</option>
					                  </select>                 
				                </div>
				               <div class="col-lg-6 col-md-6 form-group">  
				                     <label class="control-label templatemo-block">所属单元</label>                 
					                 <select id="relateUnit" name="dpmsHousehold.relateUnit" class="form-control" required="required">
					                    <option value="" selected>---请选择单元---</option>
					                  </select>                  
				                </div> 
			              </div>
			               <div class="row form-group">
				                <div class="col-lg-6 col-md-6 form-group">  
				                     <label class="control-label templatemo-block">所属楼层</label>                 
					                 <select id="relateFloor" name="dpmsHousehold.relateFloor" class="form-control" required="required">
					                    <option value="" selected>---请选择楼层---</option>
					                  </select>                  
				                </div>
				                <div class="col-lg-6 col-md-6 form-group">  
				                     <label class="control-label templatemo-block">门牌号</label>                 
					                 <select id="relateNo" name="dpmsHousehold.relateNo" class="form-control" required="required">
					                    <option value="" selected>---门牌号---</option>
					                  </select>                  
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