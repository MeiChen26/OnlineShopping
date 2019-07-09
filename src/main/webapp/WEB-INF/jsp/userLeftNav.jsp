<%--
  Created by IntelliJ IDEA.
  User: meitong
  Date: 2019-06-24
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(document).ready(function(){

        $.get(document.location.href+"category/getAllCategory.action", null,
            function(result){
            console.log(1)
                var categories = result.categories;
                if(categories && categories.length > 0){
                    for(var i = 0; i < categories.length; i++){
                         console.log(categories[i].cate_name)

                        var s = "<li><a href=''>"+categories[i].cate_name+"</a></li>";
                        $("#left_cate").append(s);
                    }
                }
                else{
                    $("#left_cate").html("暂无相关信息");
                }

            },"json");


                /* var wd = $(".nav-pills").width();
                jQuery(window).scroll(function() {
                    $("#left_cate").css("width", wd);
                }); */

                $("#left_cate").affix({
                    offset: {
                        top: 125,
                        bottom: function () {
                            return (this.bottom = $('.bottom').outerHeight(true));
                        }

                    }
                });



    }
    )
</script>

<div class="list-group">
    <ul class="nav nav-pills nav-stacked" id="left_cate">
        <li class="active"><a href="">女装</a></li>
        <li><a href="">男装</a></li>
        <li><a href="">珠宝</a></li>
        <li><a href="">箱包</a></li>
        <li><a href="">女鞋</a></li>
        <li><a href="">男鞋</a></li>
        <li><a href="">孕妇装</a></li>
        <li><a href="">儿童装</a></li>
    </ul>
</div>
