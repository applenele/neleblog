/**
 * Created by apple on 15/3/22.
 */

$(document).ready(function(){
    page = 0;
    $.ajax({
        url: "/article/getArticles",
        method: "post",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data: { "page": page },
        success: function (data) {
            var str="";
            for(var i=0;i<data.length;i++){
                str=str+"<div class='article'><h3>"+data[i].title+"</h3><div>"+data[i].content+"</div> </div>";
            }
            console.log(str);
            console.log($("#main"));
           // $("#main").empty();
            $(".main").append(str);
        },
        error: function (data) {
            alert("error！");
        }
    });

});