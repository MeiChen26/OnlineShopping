<%--
  Created by IntelliJ IDEA.
  User: meitong
  Date: 2019-06-06
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.11.3.js"></script>
<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
            $.get(document.location.href+"category/getAllCategory.action", null,
                function(result){
                    var categories = result.categories;
                    if(categories && categories.length > 0){
                        for(var i = 0; i < categories.length; i++){
                            // console.log(categories[i].cate_name)

                            var s = "<li><a href=''>"+categories[i].cate_name+"</a></li>";
                            $("#dropdown_cate").append(s);
                        }
                    }
                    else{
                        $("#dropdown_cate").html("暂无相关信息");
                    }
                    console.log($("#dropdown_cate"))
                },"json");
        }
    )

    function login(){

        var user_name=$("#user_name").val();
        var user_password=$("#user_password").val();

        $.post(document.location.href+"user/login.action",{"user_name":user_name,"user_password":user_password},
            function(result){
                $("#loginFormModal").modal('hide');
                if(result.login=="yes"){
                    var s="<li><a href=''>"+user_name+"您好，欢迎来到爱丽小铺！</a>"
                        +"<li><a href='#' onclick=''>购物车<span class='badge'></span></a><li>"
                        +"<li><a href=''>我的订单</a></li>"
                        +"<li><a href=''>个人中心</a></li>"
                        +"<li><a href='#' onclick=''>退出登录</a></li>";
                    $("#info").html(s);
                }else{
                    $("#msg-title").html("登录失败");
                    $("#msg-body").html("用户名或密码错误");
                    $("#msgModal").modal();
                }
            },"json");
    }
</script>

<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-default navbar-static-top" role="navigation">
            <div class="navbar-header navbar-right">
                <ul class="nav navbar-nav" id="info">
                    <c:if test="${sessionScope['_LOGIN_USER_']==null}">
                        <span><strong class ="navbar-brand">游客您好，欢迎来到爱丽小铺 </strong></span>
                        <li>
                            <a href="#loginFormModal" data-toggle="modal">[登录]</a>
                        </li>
                        <li>
                            <a href="" data-toggle="modal">[新用户注册]</a>
                        </li>
                        <li><a href="#" onclick="">购物车 <span class="badge"></span></a>
                        </li>
                    </c:if>

                    <c:if test="${sessionScope['_LOGIN_USER_']!=null}">
                        <li id="li1"><span>${sessionScope['_LOGIN_USER_'].user_name}您好，欢迎来到良品专卖店！</span>
                        <li><a href="#" onclick="">购物车 <span class="badge" id="cartBadge"></span></a></li>
                        <li><a href="">我的订单</a></li>
                        <li><a href="">个人中心</a></li>
                        <li><a href="#" onclick="">退出登录</a></li>
                    </c:if>
                </ul>
            </div>
        </nav>

        <nav class="navbar navbar-default navbar-static-top" role="navigation">
            <div class="navbar-header">
                <a class="navbar-brand" href="">爱丽小铺</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="">网站首页</a>
                    </li>
                    <li>
                        <a href="">新到商品</a>
                    </li>
                    <li>
                        <a href="">热销商品</a>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="true">商品分类<strong class="caret"></strong></a>
                        <ul class="dropdown-menu" id="dropdown_cate">
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-left form-inline" method="post"action="">
                    <div class="form-group">
                        <input class="form-control" type="text" name="keyword"/>  <span type="submit">店内搜索</span>
                    </div>
                </form>

                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown" >
                        <a class="dropdown-toggle" href="#" data-toggle="dropdown">排序<strong class="caret"></strong></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">按价格从低到高</a>
                            </li>

                            <li class="divider">
                            </li>

                            <li>
                                <a href="#">按销量从低到高</a>
                            </li>
                        </ul>
                    </li>

                </ul>
            </div>
        </nav>

    </div>
</div>
<%@include file="loginFormModal.jsp" %>
<%@include file="msgModal.jsp" %>