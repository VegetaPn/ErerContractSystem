
window.onload = initPage;
function initPage()
{
	window.onsubmit = validateForm;
}

function validateForm(){
	var user=document.forms[0].form-username.value;
	var pwd1=document.forms[0].form-password.value;
	var pwd2=document.forms[0].form-password2.value;
if(user.length<4||user.length>20){
alert("用户名必须在4-16个字符之内");
return false;
}

if(pwd1.length<6||pwd1.length>12){
alert("密码长度不符合要求");
return false;
}

if(pwd1==pwd2){

}else{alert("两次密码不一致");
return false;}
return true;

}