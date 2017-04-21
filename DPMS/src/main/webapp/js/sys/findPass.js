$(document).ready(function(){
	$('#sendMail').addClass('login-button');
	$('#userNameOk').addClass('login-button');

	$("#userNameOk").click(function(){
		var input=$("#userName").val();
		var position=$("#userName");
		var offset=position.offset();
		$('#textfield1').empty();
		//用户名为空提示
		if(input==''){
			$('#textfield1').text('*请输入用户名');
			$('#textfield1').offset({top:offset.top+10,left:offset.left+300})
			$('#textfield1').show();
			$('#email').hide();
			$('#sendMail').hide();
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
						$('#emaildiv').hide();
						$('#sendMail').hide();
					}else{
						$('#userName').hide();
						$('#emaildiv').show();
						$('#sendMail').show();
						$('#userNameOk').hide();
					}
				},
				error:function(){
					alert('系统异常');
				}
			});
		}
	});
	$('#sendMail').click(function(){
		$.post('../../sys/check',{userName:$("#userName").val(),'email':$('#email').val(),'operateType':'checkEmail'},function(data){
			if(data!=''&&data!=undefined){
				var position=$('#email');
				var offset=position.offset();
				$('#textfield2').text("*"+data.mail);
				$('#textfield2').offset({top:offset.top+10,left:offset.left+300})
				$('#textfield2').show();
				$('#refresh').show();
				$('#sendMail').hide();
				$('input').val('');
			}else{
				$('form').submit();
			}
		});
	});
	$('#refresh').click(function(){
		window.location.reload();
	});
});