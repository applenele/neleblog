/**
 * Created by apple on 15/3/27.
 */

$(document).ready(function(){

    $("#btnAddMessage").click(function(){
        var content=CKEDITOR.instances.content.getData();
        var nickname=$("#nickname").val();

        $.post("/message/add",{"nickname":nickname,"content":content},function(data){
            window.location.reload();
        })
    });
});