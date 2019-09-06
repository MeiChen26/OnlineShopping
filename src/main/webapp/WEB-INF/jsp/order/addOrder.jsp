<%--
  Created by IntelliJ IDEA.
  User: meitong
  Date: 2019-07-26
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@include file="../userTopNav.jsp" %>
<script type="text/javascript">
function payForOrder(orderId){
    console.log(orderId)
// window.open(getContextPath()+"/order/pay?orderId="+orderId);
// clearCart();
$("#confirmTitle").html("请确认");
$("#confirmBody").html("请选择您属于下列哪种情况：");
$("#confirmOk").html("付款成功");
$("#confirmNo").html("付款遇到问题，未完成支付");
$("#confirmModal").modal();

$("#confirmOk").click(function(){
    console.log(1111111)
    console.log(document.location.href)
location.href=getContextPath()+"/order/payForOrder.action?orderId="+orderId;

}
);
}

function getContextPath(){
    var  webroot=document.location.href;
    webroot=webroot.substring(webroot.indexOf('//')+2,webroot.length);
    webroot=webroot.substring(webroot.indexOf('/')+1,webroot.length);
    webroot=webroot.substring(0,webroot.indexOf('/'));
    var contextPath="/"+webroot;
    return contextPath;
    //alert(contextPath);
}
</script>
<div class="container-fluid">
    <div class="row">
        请选择付款方式：
        <form  method="post">
            <div class="col-md-10 col-md-offset-1">
                <button class="btn btn-primary" type="button" onclick="payForOrder(${orderId})">去网银付款</button>
                <%--<button class="btn btn-primary" type="button" onclick="location.href='${pageContext.request.contextPath}/order/getMyOrders'">返回订单列表页面</button>--%>
            </div>
        </form>
    </div>
</div>
<%@include file="../userFooter.jsp" %>
<%@include file="../confirmModal.jsp" %>

</body>
</html>
