$(document).ready(function () {

    $("#btnAddArticle").click(function () {
        var title=$("#title").val();
        var content = CKEDITOR.instances.content.getData();
        var category=$("#category").val();
        var tags=$("#tags").val();
        if(title==""){
            alert("标题不能为空！");
            return ;
        }
        if(content==""){
            alert("内容不能为空！");
            return ;
        }
        if(category==""){
            alert("分类不能为空！");
            return ;
        }

        $.post("/article/add",{"title":title,"content":content,"category":category,"tags":tags},function(data){
            if(data=="ok"){
                window.location.href="index.jsp";
            }else{
                alert("添加文章出错！")
            }
        });

    });
});