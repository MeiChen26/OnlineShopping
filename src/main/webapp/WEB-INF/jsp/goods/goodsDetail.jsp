
<%--
  Created by IntelliJ IDEA.
  User: meitong
  Date: 2019-06-25
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="../userTopNav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <%@include file="../userLeftNav.jsp" %>
        </div>
       <form class="form-inline" role="form" action="${pageContext.request.contextPath}/order/buyGoods.action" method="post">
           <input type="hidden"  name="goodsId"value="${goodsDetail.goods_id}"/>
           <input type="hidden" name="goodsName" value="${goodsDetail.goods_name}"/>
           <input type="hidden" name="goodsPrice" value="${goodsDetail.goods_price}"/>
           <input type="hidden" name="goodsDiscount" value="${goodsDetail.goods_discount}"/>
           <input type="hidden" name="goodsPostalfee" value="${goodsDetail.goods_postalfee}"/>
           <div class="col-md-6">
            <div class="col-md-12">
                <c:if test="${!empty goodsDetail }">
                <c:forEach items="${goodsDetail.pics}" var="g" varStatus="vs">
                    <div class="col-xs-2 col-sm-2" >
                        <a href="#" class="thumbnail" >
                            <img  src="${pageContext.request.contextPath}${g.pic_url}" alt="暂无图片" id="${vs.first?'first_img':''}">

                            <input type="hidden" name="pic" value="${g.pic_url}"/>
                        </a>
                    </div>
                </c:forEach>
                </c:if>
            </div>
            <div class="col-md-12">
                        <h3>
                            商品详情
                        </h3>
            </div>
                        ${goodsDetail.goods_desc}

            <c:forEach items="${goodsDetail.pics}" var="g" varStatus="vs">
                        <div class="col-md-12">
                            <a href="" class="thumbnail"><img src="${pageContext.request.contextPath}${g.pic_url}" alt="暂无图片">
                            </a>
                        </div>
            </c:forEach>
            <c:if test="${empty goodsDetail}">
                <div class="alert alert-danger col-md-3" role="alert">对不起，暂无此商品信息</div>
            </c:if>
            </div>
      <div class="col-md-4 panel-pills" id="rightPanel" >
          <c:if test="${!empty goodsDetail}">
              <div class="panel panel-info">
                  <div class="panel-heading">
                      <label id="goodsName">${goodsDetial.goods_name}</label>
                  </div>
                  <div class="panel-body">
                      <p>
                          <label>原价：</label><span class="glyphicon glyphicon-yen"></span>
                          <label id="goodsPrice">${goodsDetail.goods_price}</label>
                      </p>
                      <p>
                          <label>现售：</label>
                              <span class="glyphicon glyphicon-yen" aria-hidden="true"></span>
                          <label id="goodsDiscount">${goodsDetail.goods_discount}</label>
                      </p>
                      <p><label>运费：</label><span class="glyphicon glyphicon-yen" aria-hidden="true"></span>
                      <label id="goodsPostalfee">${goodsDetail.goods_postalfee}</label></p>

                      <p>
                          共售出${goodsDetail.goods_sale}件
                      </p>
                      <p>
                          <label>尺寸选择：</label>
                          <div class="btn-group" role="group">
                              <c:forEach items="${goodsSizes.sizes}" var="s" varStatus="vs">
                                  <button type="button" class="btn btn-default ${vs.first?'btn-info':''}" >${s.size_name}</button>
                                  <input type="hidden" name="size" id="size" value="${s.size_name}"/>
                              </c:forEach>
                          </div>
                      </p>

                      <p>
                          <label>颜色选择：</label>
                          <div class="btn-group">
                              <c:forEach items="${goodsColors.colors}" var="c" varStatus="vs">
                                  <button type="button" class="btn btn-default btn-xs ${vs.first?'btn-info':''}" >${c.color_name}</button>
                                  <input type="hidden" id="color" value="${c.color_name}"/>
                              </c:forEach>
                  </div>
                      </p>
                      <p>
                      <div class="form-group">
                          <lable for="num">数量：</lable>
                          <div class="input-group input-group-sm col-xs-3">
                              <input class="form-control" id="num" name="num" type="number" value="1"/>
                          </div>

                  </div>
                      </p>
                      <p>
                          <button class="btn btn-primary btn-sm" type="submit">
                              立即购买
                          </button>
                          <button class="btn btn-primary btn-sm" type="button" onclick="add()">
                              加入购物车
                          </button>
                      </p>
                      <ul class="list-group">
                          <li class="list-group-item">产地：${goodsDetail.goods_origin}</li>
                          <li class="list-group-item">材质：${goodsDetail.goods_material}</li>
                      </ul>
                  </div>

                  </div>
          </c:if>
              </div>
        </form>
      </div>

    </div>
