/**
 * Created by apple on 15/3/24.
 */


$(document).ready(function () {

    //获取归档时间
    $.ajax({
        url: "/article/getPTime",
        method: "post",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function (data) {
           var str="";
           for(var key in data){
               str=str+"<p>"+key+"("+data[key]+")</p>"
           }
            $(".calendar_list").html(str);
        },
        error: function (data) {
            alert("获取归档时间出错！");
        }
    });

    //获取分类
    $.ajax({
        url: "/article/getPCategory",
        method: "post",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function (data) {
            var str="";
            for(var key in data){
                str=str+"<p><a href='/article/getByPTime?'>"+key+"("+data[key]+")</a></p>"
            }
            $(".catalogs_list").html(str);
        },
        error: function (data) {
            alert("获取分类出错！");
        }
    });
});