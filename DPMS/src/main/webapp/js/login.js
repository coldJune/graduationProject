$(document).ready(function(){
	//验证用户名
	$("#userName").blur(function(){
		var input=$(this).val();
		var position=$(this);
		var offset=position.offset();
		$('#textfield1').empty();
		//用户名为空提示
		if(input==''){
			$('#textfield1').text('*请输入用户名');
			$('#textfield1').offset({top:offset.top+10,left:offset.left+300})
			$('#textfield1').show();
		}else{
			//如果密码不为空,则判断用户名是否存在
			$.ajax({
				url:'/DPMS/sys/check',
				type:'post',
				data:{'operateType':'checkUserName',userName:input},
				dataType:'json',
				success:function(data){
					if(data.msg!='true'){
						$('#textfield1').text("*"+data.msg);
						$('#textfield1').offset({top:offset.top+10,left:offset.left+300})
						$('#textfield1').show();
					}
				},
				error:function(){
					alert('系统异常');
				}
			});
		}
		
	});
	//验证密码是否为空
	$("#passWord").blur(function(){
		var input=$(this).val();
		$('#textfield2').empty();
		//密码为空提示
		if(input==''){
			var position=$(this);
			var offset=position.offset();
			$('#textfield2').text('*请输入密码');
			$('#textfield2').offset({top:offset.top+10,left:offset.left+300})
			$('#textfield2').show();
		}
		
	});
	//判断验证码是否为空
	$("#securityCodeInput").blur(function(){
		var input=$(this).val();
		$('#textfield3').empty();
		//验证码为空提示
		if(input==''){
			var position=$(this);
			var offset=position.offset();
			$('#textfield3').text('*请输入验证码');
			$('#textfield3').offset({top:offset.top+10,left:offset.left+300})
			$('#textfield3').show();
		}
		
	});
	//登录验证
	$('#login-button').click(function(){
		var userName=$('#userName').val();
		var passWord=$('#passWord').val();
		var securityCode=$('#securityCodeInput').val();
		$.post('/DPMS/sys/check',
				{'userName':userName,
				 'passWord':passWord,
				 'securityCodeInput':securityCode,
				 'operateType':'checkUser'},
				
			function(data){
				if(data.up=='false'){
					alert('用户名或密码错误');
					$('input').val('');
				}else if(data.sc=='false'){
					alert('验证码输入错误');
					$('#securityimg').attr('src','/DPMS/sys/securityCodeImage?time='+new Date().getTime());
					$('#securityCodeInput').val('');
				}else{
					$('#form').submit();
				}
			});
		});
	//获取验证码
	$('#securityimg').click(function(){
		$(this).attr('src','/DPMS/sys/securityCodeImage?time='+new Date().getTime());		
	});
	
});
//刷新页面时清空所有值
window.onload=function(){
	$('input').val('');
	$(this).attr('src','/DPMS/sys/securityCodeImage');
}
