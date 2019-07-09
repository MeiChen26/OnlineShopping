<%--
  Created by IntelliJ IDEA.
  User: meitong
  Date: 2019-06-24
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../userTopNav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <%@include file="../userLeftNav.jsp" %>
        </div>

        <div class="col-md-10">
            <div class ="row">
                <c:if test="${!empty goods}">
                    <c:forEach items="${goods}" var="g">
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <a href="${pageContext.request.contextPath}/goods/getGoodsDetailById.action?goodsId=${g.goods_id}">
                                    <img src="${pageContext.request.contextPath}${g.goods_pic}" /></a>
                            <div class="caption text-center">
                                <label>
                                    ${g.goods_name}
                                </label>
                                <p>
                                    <span class="glyphicon">原价</span>${g.goods_price}
                                </p>
                                <p>
                                    现售<span class="label label-pill label-info">${g.goods_discount}</span>
                                </p>
                                <p>
                                    共售出${g.goods_sale}件
                                </p>
                                <p>
                                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/goods/getGoodsDetailById.action?goodsId=${g.goods_id}">查看详情</a>
                                </p>
                            </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
    </div>
</div>


</body>
</html>
