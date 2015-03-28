/**
 * Created by apple on 15/3/27.
 */


var page = 0;
var lock = false;


function LoadMessages() {
    if (lock) {
        return;
    }
    lock = true;
    $.ajax({
        url: "/message/getMessages",
        method: "post",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data: {"page": page},
        success: function (data) {
            console.log(data);
            var str = "";
            for (var i = 0; i < data.length; i++) {
                str=str+"<div class='message'><div class='message_user'>"+data[i].nickname+"</div>" +
                "<div class='message_content'>"+data[i].content+"</div>" +
                "<div class='message_mtime'>Publish On  "+(moment(data[i].mtime).format("YYYY-DD-MM HH:mm:ss"))+"</div></div>";
            }
            $(".message_list").append(str);
            page++;
            if (data.length == 6) {
                lock = false;
            }
        },
        error: function (data) {
            alert("error！");
        }
    });

}


function Load(){
    LoadMessages();
}


$(document).ready(function () {

    Load();
    $(window).scroll(
        function() {
            totalheight = parseFloat($(window).height())
            + parseFloat($(window).scrollTop());
            if ($(document).height() <= totalheight) {
                Load();
            }
        });
    /**
     * add message
     */
    $("#btnAddMessage").click(function () {
        var content = CKEDITOR.instances.content.getData();
        var nickname = $("#nickname").val();
        $.post("/message/add", {"nickname": nickname, "content": content}, function (data) {
            window.location.reload();
        })
    });
});