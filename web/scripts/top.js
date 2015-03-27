/**
 * Created by apple on 15/3/27.
 */


$(document).ready(function(){
    /***
     * 导航
     */
    $(".top_item").mouseover(function(){
        $(this).children(".zh").slideDown("fast");
    })

    $(".top_item").mouseout(function(){
        $(this).children(".zh").hide();
    });

});