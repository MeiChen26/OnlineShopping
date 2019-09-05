
<%--
  Created by IntelliJ IDEA.
  User: meitong
  Date: 2019-07-07
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="../userTopNav.jsp" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <form role="form" action="${pageContext.request.contextPath}/order/addOrder.action" method="post">
            <div class="col-md-12">
                <c:if test="${!empty address}">
                    <h3>确认收货地址</h3>
                    <table class="table table-hover">
                        <tbody>
                            <c:forEach items="${address}" var="a" varStatus="vs">
                            <tr>
                                <td>
                                    <div class="radio">
                                        <label>
                                            <input type="hidden" name="address" value="${a.addr_province}${a.addr_city}${a.addr_area}${a.addr_content}"/>

                                        </label>
                                    </div>
                                </td>
                                <td>${a.addr_province} ${a.addr_city} ${a.addr_area}</td>
                                <td>${a.addr_content}</td>
                                <td>(${a.addr_receiver}收) ${a.addr_tel} </td>
                                <td class="isDefault">${a.addr_isdefault==1?'默认地址':'' }</td>
                                <td>
                                    <a href="#" onclick="">修改</a> |
                                    <a href="#" onclick="">删除</a>	|
                                    <a href="#" onclick="">设为默认地址</a>
                                </td>
                            </c:forEach>
                        <tbody>
                    </table>
                    <button class="btn btn-primary" type="button" onclick="">添加收货地址</button>
                </c:if>
                    <c:if test="${empty address}">

                        <h3>您目前没有收货地址</h3><button class="btn btn-primary" type="button" onclick="">添加收货地址</button></h3>
                    </c:if>
            </div>

            <div class="col-md-10 col-md-offset-1">
                <h3>确认订单信息</h3>

                <table class="table table-hover table-condensed">
                    <thead>
                    <tr>
                        <th>#</th><th>商品图片</th><th>商品名称</th><th>商品单价</th><th>数量</th><th>小计</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="totalAmount" value="0"/>
                    <c:set var="postalfee" value="${paramValues.goodsPostalfee[0]}"/>
                    <c:forEach items="${paramValues.goodsId}" var="g" varStatus="vs">

                        <tr>
                            <td>
                                    ${vs.count}
                            </td>
                            <td>
                                <img src="${pageContext.request.contextPath}${paramValues.pic[vs.index]}" width="30" height="30">
                            </td>
                            <td>
                                    ${paramValues.goodsName[vs.index]}&nbsp;&nbsp;
                                    ${paramValues.size[vs.index]}&nbsp;&nbsp;${paramValues.color[vs.index]}
                            </td>
                            <td>
                                原价<span class="glyphicon glyphicon-yen" aria-hidden="true"></span>${paramValues.goodsPrice[vs.index]}&nbsp;&nbsp;
                                现售<span class="glyphicon glyphicon-yen" aria-hidden="true"></span>${paramValues.goodsDiscount[vs.index]}
                            </td>
                            <td>
                                    ${paramValues.num[vs.index]}
                            </td>
                            <td>
                                <span class="glyphicon glyphicon-yen" aria-hidden="true"></span>
                                    ${paramValues.num[vs.index]*paramValues.goodsDiscount[vs.index]}
                            </td>
                            <c:set var="totalAmount" value="${totalAmount+paramValues.num[vs.index]*paramValues.goodsDiscount[vs.index]}"/>
                            <c:set var="postalfee" value="${postalfee>paramValues.goodsPostalfee[vs.index]?paramValues.goodsPostalfee[vs.index]:postalfee}"/>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <table class="table table-condensed">
                    <tr><td class="text-right">运费：<span class="glyphicon glyphicon-yen" aria-hidden="true"></span>${postalfee}</td></tr>
                    <tr><td class="text-right">合计（含运费）：<span class="glyphicon glyphicon-yen" aria-hidden="true"></span>${totalAmount+postalfee}</td></tr>
                </table>

                <div class="col-md-12 text-right">
                    <input type="hidden" name="orderPostalfee" value="${postalfee}"/>
                    <button id="submitOrder" class="btn btn-primary" type="submit">提交订单</button></div>
            </div>

        </form>
    </div>

</div>
</body>
</html>
