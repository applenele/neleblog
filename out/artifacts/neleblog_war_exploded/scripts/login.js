$(document).ready(function(){

     $("#btnLogin").click(function(){
         var username=$("#username").val();
         var password=$("#password").val();
         if(username==""){
             alert("用户名不能为空！")
             return;
         }
         if(password==""){
             alert("密码不能为空！")
             return;
         }
         $.post("/user/login",{"username":username,"password":password},function(data){
            if(data=="ok"){
                 window.location.href="index.jsp";
            }else{
                alert("用户名或密码不正确！")
            }
         });
     })
});