
<%--
  Created by IntelliJ IDEA.
  User: meitong
  Date: 2019-09-05
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../userTopNav.jsp" %>
<div class="container-fluid">
<div class="row">
    <div class="col-md-10"></div>
    <c:if test="${!empty orders}">

        <div class="col-md-10 ">
            <c:forEach items="${orders}" var="o" varStatus="vs">
                <div class="panel panel-info">
                    <div class="panel-heading ">
                        下单日期：<fmt:formatDate value="${o.order_date}" pattern="yyyy-MM-dd"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        订单号：<a href="${pageContext.request.contextPath}/order/getOrderDetailById?orderId=${o.order_id}">${o.order_code}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        订单状态：    <span id="orderStatus">
							<c:if test="${o.order_status==0}">
                                等待付款
                                <div class="text-right">
									<a href="#" onclick="">取消订单</a> |
									<a href="">去付款</a>
								</div>
                            </c:if>
							<c:if test="${o.order_status==1}">
                                未发货
                                <div class="text-right"><a href="#" onclick="">申请退款</a></div>
                            </c:if>
							<c:if test="${o.order_status==2}">
                                已提交退款申请，请等待商家处理
                            </c:if>
							<c:if test="${o.order_status==3}">
                                退款成功
                            </c:if>
							<c:if test="${o.order_status==4}">
                                已发货
                                <div class="text-right">
									<a href="#" onclick="">确认收货</a> |
									<a href="#" onclick="">申请退货</a>
								</div>
                            </c:if>
							<c:if test="${o.order_status==5}">
                                交易成功
                                <div class="text-right">
									<a href="" onclick="">删除订单</a>
								</div>
                            </c:if>
							<c:if test="${o.order_status==6}">
                                已提交退货申请，请等待商家处理
                            </c:if>
							<c:if test="${o.order_status==7}">退货中</c:if>
							<c:if test="${o.order_status==8}">退货成功</c:if>
							<c:if test="${o.order_status==9}">
                                交易关闭
                                <div class="text-right">
									<a href="${pageContext.request.contextPath}/order/delOrder?orderId=${o.order_id}" onclick="">删除订单</a>
								</div>
                            </c:if>
							</span>
                    </div>
                    <div class="panel-body">
                        <table class="table table-hover table-condensed table-bordered">
                            <tbody>
                            <c:set var="orderDetails" value="${o.details }"/>
                            <c:set var="totalAmount" value="0"/>
                            <c:forEach items="${orderDetails}" var="od" varStatus="odvs">
                                <tr>
                                    <td>
                                        <img src="${pageContext.request.contextPath}${od.detail_pic}" width="30" height="30">
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/goods/getGoodsDetailById?goodsId=${od.goods_id}">${od.detail_name}</a>&nbsp;&nbsp;
                                            ${od.detail_size}&nbsp;&nbsp;${od.detail_color}
                                    </td>
                                    <td>
                                        <span class="glyphicon glyphicon-yen" aria-hidden="true"></span>${od.detail_price}
                                    </td>
                                    <td>
                                            ${od.detail_num}
                                    </td>
                                    <td>
                                        <span class="glyphicon glyphicon-yen" aria-hidden="true"></span>${od.detail_price*od.detail_num }
                                        <c:set var="totalAmount" value="${od.detail_price*od.detail_num}"/>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                        <table class="table table-condensed">
                            <tr>
                                <td>
                                    <button class="btn btn-info" id="back" type="button" onclick="">查看订单详情</button>
                                </td>
                                <td class="text-right">总金额（含运费${o.order_postalfee}元）：<span class="glyphicon glyphicon-yen" aria-hidden="true"></span>${od.detail_price*od.detail_num+o.order_postalfee }</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </c:forEach>

        </div>
    </c:if>
    <c:if test="${empty orders}">
        <div class="alert alert-danger col-md-2 col-md-offset-1" role="alert">对不起，暂无此类订单信息</div>
    </c:if>
</div>
</div>
</body>
</html>
