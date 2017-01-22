$(document).ready(function(){
	$("#userName").blur(function(){
		var input=$(this).val();
		var position=$(this);
		var offset=position.offset();
		//用户名为空提示
		if(input==''){
			$('#textfield1').text('*请输入用户名');
			$('#textfield1').offset({top:offset.top+10,left:offset.left+300})
			$('#textfield1').show();
		}else{
			$('#textfield1').hide();
			//如果密码不为空,则判断用户名是否存在
			$.ajax({
				url:'/DPMS/sys/login',
				type:'post',
				data:{'operateType':'checkUserName',userName:input},
				dataType:'json',
				success:function(data){
					$('#textfield1').text(data.username);
					$('#textfield1').offset({top:offset.top+10,left:offset.left+300})
					$('#textfield1').show();
				}
			});
		}
		
	});
	$("#passWord").blur(function(){
		var input=$(this).val();
		//密码为空提示
		if(input==''){
			var position=$(this);
			var offset=position.offset();
			$('#textfield2').text('*请输入密码');
			$('#textfield2').offset({top:offset.top+10,left:offset.left+300})
			$('#textfield2').show();
		}else{
			$('#textfield2').hide();
		}
		
	});
	$("#seruityCode").blur(function(){
		var input=$(this).val();
		//验证码为空提示
		if(input==''){
			var position=$(this);
			var offset=position.offset();
			$('#textfield3').text('*请输入验证码');
			$('#textfield3').offset({top:offset.top+10,left:offset.left+300})
			$('#textfield3').show();
		}else{
			$('#textfield2').hide();
		}
		
	});
});