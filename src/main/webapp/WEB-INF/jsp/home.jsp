<%--
  Created by IntelliJ IDEA.
  User: meitong
  Date: 2019-06-03
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="./userTopNav.jsp" %>
<style>

    .carousel-inner .item img{
        width: 100%;
        height:450px;
    }
</style>

<div class="container-fluid">
    <div class="row">
        <%@include file="./adver.jsp" %>
        <div class="col-md-12">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3>商品分类<a class="btn" href="">查看更多 »</a></h3>
                </div>

                <div class="panel-body" id="category">
                    <c:forEach var="c" items="${categories}" varStatus="vs">
                        <div class="col-xs-6 col-md-3">
                            <div class="thumbnail">
                                <a href="${pageContext.request.contextPath}/goods/getGoodsByCategory.action?cateId=${c.cate_id}">
                                <img src="${pageContext.request.contextPath}${c.cate_pic}" class="img-responsive"/></a>
                                <div class="caption" align="center">
                                    <p>${c.cate_name}</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

            </div>
        </div>

        <div class="col-md-12">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3>新到商品<a class="btn" href="">查看更多</a></h3>
                </div>
                <div class="panel-body">
                    <div id="myCarousel" class="carousel slide">
                        <!-- 轮播（Carousel）指标 -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                        </ol>
                        <!-- 轮播（Carousel）项目 -->
                        <div class="carousel-inner">
                            <c:set var="index" value="0"/>
                            <c:forEach begin="0" end="${fn:length(newGoods)/3-1}">
                                <div clas="row">
                                        <c:forEach begin="0" end="2">
                                            <div class="col-md-4">
                                                <a href="">
                                                    <img src="${pageContext.request.contextPath}${newGoods[index].goods_pic}" alt="image"></a>
                                                <div class="container">
                                                    <div class="carousel-caption">${newGoods[index].goods_name}<br>共售出
                                                        <span class="badge">${newGoods[index].goods_sale}件</span>
                                                    </div>
                                                </div>
                                            </div>
                                    <c:set var="index" value="${index+1}"/>
                                    </c:forEach>
                                </div>
                            </c:forEach>
                        </div>
                        <!-- 轮播（Carousel）导航 -->
                        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
















        <div class ="col-md-12">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3>销售排行榜<a class="btn">查看更多 »</a></h3>
                </div>
                <div class="panel-body">
                    <div id="salesGoodsCarousel" class="carousel slide goods" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#salesGoodsCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#salesGoodsCarousel" data-slide-to="1"></li>
                            <li data-target="#salesGoodsCarousel" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner" id="salesGoods">
                            <c:if test="${!empty salesGoods}">
                                <c:set var="index" value="0"/>
                                <c:forEach begin="0" end="${fn:length(salesGoods)/4-1}" var="i" varStatus="vs">
                                    <div class="item ${vs.first?'active':''} goods">
                                        <div class="row">
                                            <c:forEach begin="0" end="2">
                                                <div class="col-md-4">
                                                    <a href="">
                                                        <img src="${pageContext.request.contextPath}${salesGoods[index].goods_pic}" alt="Image" class="img-responsive"/></a>
                                                    <div class="container">
                                                        <div class="carousel-caption">${salesGoods[index].goods_name}<br>
                                                            共售出<span class="badge">${salesGoods[index].goods_sale}件</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <c:set var="index" value="${index+1}"/>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty salesGoods}">
                                <div class="alert alert-danger" role="alert">对不起，暂无资料</div>
                            </c:if>
                        </div>
                        <a class="left carousel-control" href="#salesGoodsCarousel" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span><span class="sr-only">Previous</span></a>
                        <a class="right carousel-control" href="#salesGoodsCarousel" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><span class="sr-only">Next</span></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="./userFooter.jsp" %>
</body>
</html>
