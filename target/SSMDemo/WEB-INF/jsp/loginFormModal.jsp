<%--
  Created by IntelliJ IDEA.
  User: meitong
  Date: 2019-06-28
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<div class="modal" id="loginFormModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">&times</button>
                <h4 class="modal-title" id="myModalLabel">用户登录</h4>
            </div>
            <div class="modal-body">
                <form  id="loginForm" method="post">
                    <label for="user_name">用户名: </label>
                    <input type="email"  name="user_name"  id="user_name" class="form-control" placeholder="Email address" required autofocus>
                    <label for="user_password">密码: </label>
                    <input type="password" name="user_password" id="user_password" class="form-control" placeholder="Password" required>
                    <div class="checkbox">
                        <label><input type="checkbox" >
                            记住我</label>

                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" type="button" onclick="login()">登录</button>
                <button class="btn btn-primary" type="button" data-dismiss="modal">关闭窗口</button>
            </div>
        </div>
    </div>
</div>
