$(document).ready(function(){
	$('#sendMail').addClass('login-button');
	$('#sendMail').click(function(){
		$.post('../../sys/checkEmail',{'email':$('#email').val()},function(data){
			if(data.mail!=''&&data.mail!=undefined){
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