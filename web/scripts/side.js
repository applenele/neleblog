/**
 * Created by apple on 15/3/24.
 */


$(document).ready(function () {

    //获取归档时间
    $.ajax({
        url: "/article/getPTime",
        method: "post",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function (data) {
            $(".calendar_list").html(data);
        },
        error: function (data) {
            alert("获取归档时间出错！");
        }
    });

    //获取分类
    $.ajax({
        url: "/article/getPCategory",
        method: "post",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function (data) {
            $(".catalogs_list").html(data);
        },
        error: function (data) {
            alert("获取分类出错！");
        }
    });
});