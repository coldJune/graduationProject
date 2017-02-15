$(document).ready(function(){
	/*鼠标移上去改变颜色*/
	/*$("tr").mouseover(function(){
		if($(this).children().first().children().children().attr("checked")!="checked"){
			$(this).toggleClass("choose");
		}
		
	});*/
	/*鼠标移出来恢复颜色*/
	/*$("tr").mouseout(function(){
		if($(this).find("input[type='checkbox']").attr("checked")!="checked"){
			alert($(this).find("input").attr("checked"));
			$(this).removeClass("choose");
		}
	});*/
	$("input[type='checkbox']").click(function(e){  
	   if($(this).attr('checked')!='checked'){
		   $(this).attr('checked',true);
		   //$(this).closest('tr').css('background-clolor','none');
		   $(this).closest('tr').toggleClass("choose");
		   /*var tr=$(this).closest('tr').attr('id').val();*/
	   }else{
		   $(this).attr('checked',false);
		   $(this).closest('tr').toggleClass("choose");
	   }
	});  
	/*手机菜单*/
	$('.mobile-menu-icon').click(function(){
		$('.templatemo-left-nav').slideToggle();				
	});

	/*  */
	$('.templatemo-content-widget .fa-times').click(function(){
		$(this).parent().slideUp(function(){
			$(this).hide();
		});
	});
});