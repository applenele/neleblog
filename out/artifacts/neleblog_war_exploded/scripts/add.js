$(document).ready(function () {

    $("#btnAddArticle").click(function () {
        var title=$("#title").val();
        var content=$("#content").val();
        var category=$("#category").val();
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

        $.post("/article/add",{"title":title,"content":content,"category":category},function(data){
            if(data=="ok"){
                window.location.href="index.jsp";
            }else{
                alert("添加文章出错！")
            }
        });

    });
});