/**
 * Created by apple on 15/3/22.
 */

var page =0;
var lock=false;

var time="";
var category="";


function LoadArticles(){
    if(lock){
        return ;
    }else{
        lock=true;
        $.ajax({
            url: "/article/getArticles",
            method: "post",
            dataType: "json",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data: { "page": page ,"time":time,"category":category},
            success: function (data) {
                console.log(data);
                var str="";
                for(var i=0;i<data.length;i++){
                    var tags=data[i].tags;
                    var stag="";
                    for (var j =0 ;j<tags.length;j++){
                        stag=stag+"<span class='article_tag'>"+tags[j].content+"</span>   ";
                    }
                    str=str+"<div class='article'><h3>"+data[i].title+"</h3><div class='article_content'>"+data[i].content+"</div>" +
                    "<div class='article_footer'><div class='artcile_more'><a href='/article/show?id="+data[i].id+"' >Read More</a></div> <div class='ptime'>Publish On "+(moment(data[i].ptime).format("YYYY-MM-DD HH:mm:ss"))+"</div>" +
                    " <div class='article_tags'>"+stag+"</div></div></div></div>";
                }
                $(".main").append(str);
                page++;
                if(data.length==6){
                    lock=false;
                }
            },
            error: function (data) {
                alert("error！");
            }
        });

    }
}
function Load(){
    LoadArticles();
}

function LoadByCategory(data){
    page=0;
    category=data;
    time="";
    lock=false;
    $(".main").html("");
    Load();
}

function LoadByTime(data){
    page=0;
    time=data;
    category="";
    lock=false;
    $(".main").html("");
    Load();
}




$(document).ready(function(){


    page=0;
    time="";
    category="";
    Load();

    $(window).scroll(
        function() {
            totalheight = parseFloat($(window).height())
            + parseFloat($(window).scrollTop());
            if ($(document).height() <= totalheight) {
                Load();
            }
        });


});