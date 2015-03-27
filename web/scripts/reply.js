/**
 * Created by apple on 15/3/27.
 */
$(document).ready(function(){

    $("#btnReply").click(function(){
        var content=CKEDITOR.instances.content.getData();
        var nickname=$("#nickname").val();
        var article_id=$("#article_id").val();
        $.post("/reply/add",{"nickname":nickname,"content":content,"articleId":article_id},function(data){
            alert(data);
        });
    })
});