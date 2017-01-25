$(document).ready(function(){
	$('#changePass').addClass('login-button');
	//验证系统生成密码是否正确
	var flag1=0;
	$('#syspass').blur(function(){
		var syspass=$(this).val();
		var offset=$(this).offset();
		$('#textfield1').empty();
		if(syspass==''||syspass==null){
			$('#textfield1').text('*请输入原密码');
			$('#textfield1').offset({top:offset.top+10,left:offset.left+300})
			$('#textfield1').show();
		}else{
			$.ajax({
				url:'../sys/check',
				dataType:'json',
				data:{'syspass':syspass,'operateType':'checkSysPass'},
				type:'post',
				success:function(data){
					if(data.sp!=undefined){
						$('#textfield1').text('*'+data.sp);
						$('#textfield1').offset({top:offset.top+10,left:offset.left+300})
						$('#textfield1').show();
						flag1=0;
					}else{
						flag1=1;
					}
				}
			});
		}
	});
	//验证密码格式
	var flag2=0;
	$('#newpass').blur(function(){
		$('#textfield2').empty();
		var newPass=$(this).val();
		var offset=$(this).offset();
		reg=/^[a-zA-Z]\w{5,17}$/;
		if(!reg.test(newPass)){
			$('#textfield2').append('*密码应为以字母开头并且只包含'+'<br/>'+'数字、字符、和_的6到18位字符串');
			$('#textfield2').offset({top:offset.top+10,left:offset.left+300})
			$('#textfield2').show();
			flag2=0
		}else{
			flag2=1;
		}
	});
	//验证前后密码输入是否一致
	var flag3=0;
	$('#passagain').blur(function(){
		var passagain=$(this).val();
		var newpass=$('#newpass').val();
		var offset=$(this).offset();
		$('#textfield3').empty();
		if(passagain==newpass){
			flag3=1;
		}else{
			flag3=0;
			$('#textfield3').text('*密码不一致');
			$('#textfield3').offset({top:offset.top+10,left:offset.left+300})
			$('#textfield3').show();
		}
	});
	
	
	
	$('#changePass').click(function(){
		alert(flag1+":"+flag2+":"+flag3);
		if(flag1==1&&flag2==1&&flag3==1){
			$('form').submit();
		}else{
			alert('输入密码不符合要求，请重新输入');
			$('input').val('');
		}
	});
});