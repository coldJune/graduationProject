$(document).ready(function(){
	$('#sendMail').addClass('login-button');
	$('#sendMail').click(function(){
		$.post('../../sys/check',{'email':$('#email').val(),'operateType':'checkEmail'},function(data){
			if(data!=''&&data!=undefined){
				var position=$('#email');
				var offset=position.offset();
				$('#textfield1').text("*"+data.mail);
				$('#textfield1').offset({top:offset.top+10,left:offset.left+300})
				$('#textfield1').show();
				$('input').val('');
			}else{
				$('form').submit();
			}
		});
	});
});