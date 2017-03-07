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
	
	
	
	//验证身份证
	$('#cardId').blur(function(){
		var city = { 11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江 ", 31: "上海", 
                32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北 ", 43: "湖南", 
                44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏 ", 61: "陕西", 
                62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外 " };
		 var cardId = $(this).val();
         var d = new Date();
         var sex;
         var birYear;
         var birMon;
         var birDay;
         var birth;
         var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
         var address = city[cardId.substr(0, 2)]; 
         if (cardId=="" || cardId == undefined){
             alert("请填写身份证号");
             $('#age').val('');
             $('#birthDay').val('');
             $('#gender').val('');
             $('#cardId').val('');
             return false;
         }
         else if (reg.test(cardId) === false){
             alert("身份证号码为15位或18位，请检查！");
             $('#age').val('');
             $('#birthDay').val('');
             $('#gender').val('');
             $('#cardId').val('');
             return false;
         }
         else if (!city[cardId.substr(0, 2)]) {
             alert("地址编码错误");
             $('#age').val('');
             $('#birthDay').val('');
             $('#gender').val('');
             $('#cardId').val('');
             return false;
         }
         //处理18位的身份证号码
         else if (cardId.length == 18){
             sex = sexCheck(cardId.substr(14, 3));
       
             if (!(dateCheck(parseInt(cardId.substr(6, 4)), parseInt(cardId.substr(10, 2)), parseInt(cardId.substr(12, 2))))) {
            	 $('#cardId').val('');
                 return false;
             }
             birYear=cardId.substr(6, 4).toString();
             birMon=cardId.substr(10, 2).toString();
             birDay=cardId.substr(12, 2).toString();
             birth=birYear+"-"+birMon+'-'+birDay;
             //18位身份证需要验证最后一位校验位
             if (cardId.length == 18){
            	 cardId = cardId.split('');
                 //∑(ai×Wi)(mod 11)
                 //加权因子
                 var factor = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
                 //校验位
                 var parity = [1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2];
                 var sum = 0;
                 var ai = 0;
                 var wi = 0;
                 for (var i = 0; i < 17; i++){
                     ai = cardId[i];
                     wi = factor[i];
                     sum += ai * wi;
                 }
                 var last = parity[sum % 11];
                 if (parity[sum % 11] != cardId[17]){
                     alert("校验位错误");
                     $('#age').val('');
                     $('#birthDay').val('');
                     $('#gender').val('');
                     $('#cardId').val('');
                     return false;
                 }
             }
                
         }//处理15位的身份号码
         else if (cardId.length == 15){
             birth = "19" + cardId.substr(6, 2) + "-" + cardId.substr(8, 2) + "-" + cardId.substr(10, 2);
             sex = sexCheck(cardId.substr(12, 3));
             if (!(dateCheck(parseInt(cardId.substr(6, 2)), parseInt(cardId.substr(8, 2)), parseInt(cardId.substr(10, 2))))){
            	 $('#cardId').val('');
                 return false;
             }
             year = parseInt(cardId.substr(6, 2));
         }

         //年龄
         age = (parseInt(d.getFullYear()) - birYear);
         $('#age').val(age);
         $('#birthDay').val(birth);
         $('#gender').val(sex);
         return true;
	});
	
	$('#phone').blur(function(){
		var phone=$(this).val();
		if(!(/^1[34578]\d{9}$/.test(phone))){
			$(this).val('');
			alert('请输入正确的手机号');
		}
	});
	

});

function sexCheck(sex)
{
    if (parseInt(sex) % 2 == 0) {
        return "女";
    }
    else
    {
        return "男";
    }
}

//年月日验证
function dateCheck(year, month, day)
{
    var d = new Date();
    if (month > 12 || month <= 0)
    {
        alert("月应在1-12之间");
        $('#age').val('');
        $('#birthDay').val('');
        $('#gender').val('');
        return false;
    }
    if (day > 31 || day <= 0)
    {
        alert("日应在1-31之间");
        $('#age').val('');
        $('#birthDay').val('');
        $('#gender').val('');
        return false;
    }
    var nowYear = d.getFullYear();
    if (year > nowYear)
    {
        alert("年不能超过今年");
        $('#age').val('');
        $('#birthDay').val('');
        $('#gender').val('');
        return false;
    }
    return true;
}