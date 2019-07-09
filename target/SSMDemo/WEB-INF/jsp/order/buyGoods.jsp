
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
    <title>Title</title>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <form>
            <div class="col-md-12">
                <c:if test="${!empty address}">
                    <h3>确认收货地址</h3>
                    <table class="table table-hover">
                        <tbody>
                            <c:forEach items="${address}" var="a" varStatus="vs">
                                <tr>
                                    <td>
                                       ${a.addrProvince} ${a.addrCity} ${a.addrArea}
                                    </td>
                                    <td>
                                        ${a.addrContent}
                                    </td>
                                    <td>>
                                            ${a.addrReceiver}收  ${a.addrTel}
                                    </td>
                                    <td>
                                        <a href="" onclick="">修改</a>
                                        <a href="" onclick="">删除</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        <tbody>
                    </table>
                    <button class="btn btn-primary" type="button" onclick="">添加收货地址</button>
                </c:if>
                    <c:if test="${empty address}">

                        <h3>您目前没有收货地址</h3><button class="btn btn-primary" type="button" onclick="">添加收货地址</button></h3>
                    </c:if>
            </div>
        </form>
    </div>
</div>
</body>
</html>
