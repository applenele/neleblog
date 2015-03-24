/**
 * Created by apple on 15/3/22.
 */
$(document).ready(function(){

    /***
     * 导航
     */
    $(".nav .nav_list li a").mouseover(function(){
        $(this).children(".zh").slideDown("fast");
    })

    $(".nav .nav_list li a").mouseout(function(){
        $(this).children(".zh").hide();
    })


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
                var tags=data[i].tags;
                var stag="";
                for (var j =0 ;j<tags.length;j++){
                  stag=stag+"<span class='article_tag'>"+tags[j].content+"</span>   ";
                }
                str=str+"<div class='article'><h3>"+data[i].title+"</h3><div class='article_content'>"+data[i].content+"</div>" +
                "<div class='article_footer'><div class='artcile_more'><a href='' >Read More</a></div> <div class='ptime'>Publish On "+(moment(data[i].ptime).format("YYYY-MM-DD HH:mm:ss"))+"</div>" +
                " <div class='article_tags'>"+stag+"</div></div></div>";
            }
            $(".main").append(str);
        },
        error: function (data) {
            alert("error！");
        }
    });



});