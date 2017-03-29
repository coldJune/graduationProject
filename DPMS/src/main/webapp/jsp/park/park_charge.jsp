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
    		/**
    		白天收费标准（8:00—19:00）：起价2元/小时（不足1小时按1小时计费），第一小时后每小时1元（不足半小时按半小时计费）
    		夜间收费（19:00-次日8:00），统一为每4个小时2元钱（不足4小时按4小时计算）
    		*/
    		//计算应收费用
    		var startTime= new Date(('2017-03-28 16:00:00').replace(/-/g,"/"));
    		//var startTime=new Date($('#startTime').val().replace(/-/g,"/"));
    		var endTime=new Date();
    		var days=Math.abs(endTime.getTime()-startTime.getTime())/(1000*60*60*24.0);
    		var hours=Math.abs(endTime.getTime()-startTime.getTime())/(1000*60*60.0);
    		var price='';
    		//停车天数小于等于1天
    		if(days<=1){
    			var startH=startTime.getHours();
    			var endH=endTime.getHours();
    			//在白天停车
    			if(startH>8&&startH<19&&endH>startH&&endH<19){
    				//如果停车小时数为整数
    				if(hours>1){
    					if(Math.floor(hours)==hours){
        					price=2+(endH-startH-1);
        				}else{
        					price=2+(endH-startH-1);
        					//超出时间不足半小时
        					if(hours-Math.floor(hours)<=0.5){
        						price+=0.5;
        					}else{
        						price+=1
        					}
        				}
    				}else{
    					price=2;
    				}
    				
    			//从白天停到晚上
    			}else if(startH>8&&startH<19&&(endH>19||endH<8)){
    				var startM=startTime.getMinutes();
    				if(startM<30){
    					price=2+(19-startH-1);
    				}else{
    					price=2+(19-startH-2)+0.5;
    				}
    				var night=new Date(startTime.getFullYear(),startTime.getMonth(),startTime.getDate(),19,0,0);
    				var h=Math.abs(night.getTime()-endTime.getTime)/(1000*60*60.0);
    				price+=(h/4)*2+(h%4>0?2:0);
    			//白天停到隔天白天
    			}else if(startH>8&&startH<19&&endH>8&&endH<startH){
    				var startM=startTime.getMinutes();
    				if(startM<30){
    					price=2+(19-startH-1);
    				}else{
    					price=2+(19-startH-2)+0.5;
    				}
    				price+=5;
    				price+=(endH-8);
    				var endM=endTime.getMinutes();
    				if(endM<30){
    					price+=0.5;
    				}else{
    					price+=1;
    				}
    			//晚上停车
    			}else if(startH>19){
					if(endH>startH||endH<8){
						price=hours/4*2+(hours%4>0?2:0);
					}else if(endH>8&&endH<19){
						var night_hours=hours-(endH-8);
						price=night_hours/4*2+(night_hours%4>0?2:0);
						price+=endH-8;
						var endM=endTime.getMinutes();
	    				if(endM<30){
	    					price+=0.5;
	    				}else{
	    					price+=1;
	    				}
					}else if(endH>19&&endH<startH){
						//晚间
						var night_hours=hours-11;
						price=night_hours/4*2+(night_hours%4>0?2:0);
						price+=endH-8;
						//白天
						price+=11;
					}
    			}else if(startH<8){
    				if(endH>startH&&endH<8){
    					price=hours/4*2+(hours%4>0?2:0);
    				}else if(endH<19&&endH>8){
    					var night_hours=hours-(endH-8);
						price=night_hours/4*2+(night_hours%4>0?2:0);
						price+=endH-8;
						var endM=endTime.getMinutes();
	    				if(endM<30){
	    					price+=0.5;
	    				}else{
	    					price+=1;
	    				}
    				}else{
    					//晚间
						var night_hours=hours-11;
						price=night_hours/4*2+(night_hours%4>0?2:0);
						price+=endH-8;
						//白天
						price+=11;
    				}
    			}
    		}else{
    			
    			hours-=24;
    			var startH=startTime.getHours();
    			var endH=endTime.getHours();
    			//在白天停车
    			if(startH>8&&startH<19&&endH>8&&endH<19){
    				if(hours>1){
    					if(Math.floor(hours)==hours){
        					price=2+(endH-startH-1);
        				}else{
        					price=2+(endH-startH-1);
        					//超出时间不足半小时
        					if(hours-Math.floor(hours)<=0.5){
        						price+=0.5;
        					}else{
        						price+=1
        					}
        				}
    				}else{
    					price=2;
    				}
    			//从白天停到晚上
    			}else if(startH>8&&startH<19&&(endH>19||endH<8)){
    				var startM=startTime.getMinutes();
    				if(startM<30){
    					price=2+(19-startH-1);
    				}else{
    					price=2+(19-startH-2)+0.5;
    				}
    					
    				var night=new Date(startTime.getFullYear(),startTime.getMonth(),startTie.getDate(),19,0,0);
    				h=Math.abs(night.getTime()-endTime.getTime)/(1000*60*60.0);
    				price+=(h/4)*2+(h%4>0?2:0);
    			//白天停到隔天白天
    			}else if(startH>8&&startH<19&&endH>8){
    				var startM=startTime.getMinutes();
    				if(startM<30){
    					price=2+(19-startH-1);
    				}else{
    					price=2+(19-startH-2)+0.5;
    				}
    				price+=5;
    				price+=(endH-8);
    				var endM=endTime.getMinutes();
    				if(endM<30){
    					price+=0.5;
    				}else{
    					price+=1;
    				}
    			//晚上停车
    			}else if(startH>19){
					if(endH>startH||endH<8){
						price=hours/4*2+(hours%4>0?2:0);
					}else if(endH>8&&endH<19){
						var night_hours=hours-(endH-8);
						price=night_hours/4*2+(night_hours%4>0?2:0);
						price+=endH-8;
						var endM=endTime.getMinutes();
	    				if(endM<30){
	    					price+=0.5;
	    				}else{
	    					price+=1;
	    				}
					}else if(endH>19&&endH<startH){
						//晚间
						var night_hours=hours-11;
						price=night_hours/4*2+(night_hours%4>0?2:0);
						price+=endH-8;
						//白天
						price+=11;
					}
    			}else if(startH<8){
    				if(endH>startH&&endH<8){
    					price=hours/4*2+(hours%4>0?2:0);
    				}else if(endH<19&&endH>8){
    					var night_hours=hours-(endH-8);
						price=night_hours/4*2+(night_hours%4>0?2:0);
						price+=endH-8;
						var endM=endTime.getMinutes();
	    				if(endM<30){
	    					price+=0.5;
	    				}else{
	    					price+=1;
	    				}
    				}else{
    					//晚间
						var night_hours=hours-11;
						price=night_hours/4*2+(night_hours%4>0?2:0);
						price+=endH-8;
						//白天
						price+=11;
    				}
    			}
    			price+=Math.floor(days)*20;
    		}
    		$('#price').val(price);
    		$('#endTime').val(endTime.getFullYear()+'-'+endTime.getMonth()+'-'+endTime.getDate()+' '+endTime.getHours()+':'+endTime.getMinutes()+':'+endTime.getSeconds())
    		
    		$('#realPrice').blur(function(){
    			var price=$('#price').val();
    			var realPrice=$(this).val();
    			if(realPrice<price){
    				alert('收取金额应大于等于应收金额');
    				$(this).val('');
    				$('#oddCharge').val('');
    			}else{
    				$('#oddCharge').val(realPrice-price);
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
            <li><a href="findAllRealEstate" class="active"><i class="fa fa-bar-chart fa-fw"></i>楼盘信息管理</a></li>
            <li><a href="#"><i class="fa fa-database fa-fw"></i>物业收费管理</a></li>
            <li><a href="findAllPark"><i class="fa fa-map-marker fa-fw"></i>停车场信息管理</a></li>
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
		          <h2 class="margin-bottom-10">停车场信息</h2>
            		<p>>>收费</p>
		          
			           <form  action="chargePark" class="templatemo-login-form" method="post" enctype="multipart/form-data">
			              <div class="row form-group">
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="id">ID</label>
				                    <input type="text" class="form-control" id="id" name="dpmsPark.id"  value="${dpmsPark.id}" readonly="readonly">                  
				                </div>		               
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="plateNumber">车牌号</label>
				                    <input type="text" class="form-control" id="plateNumber" name="dpmsPark.plateNumber" value="${dpmsPark.plateNumber}" readonly="readonly">                  
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
			               <div class="row form-group">
			               		 <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="price">应收费用(元)</label>
				                    <input type="number" class="form-control" id="price" name="dpmsPark.price" value="${dpmsPark.price}" readonly="readonly">                 
				                </div> 
			               </div>
			               <div class="row form-group">
			               		<div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="realPrice">实收费用(元)</label>
				                    <input type="number" min="0" class="form-control" id="realPrice" name="realPrice"  required="required">                  
				                </div>
				                <div class="col-lg-6 col-md-6 form-group">                  
				                    <label for="oddCharge">找零(元)</label>
				                    <input type="number"min="0" class="form-control" id="oddCharge"  name="oddCharge"   required="required" readonly="readonly">                 
				                </div>  
				                
				               
			               </div>
			              

			              <div class="form-group text-right">
			                <button type="submit" class="templatemo-blue-button">收费</button>
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