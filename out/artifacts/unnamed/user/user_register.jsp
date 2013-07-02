<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-5-11
  Time: 上午9:46
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=gb2312" language="java" %>--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<meta charset="gb2312">

<html lang="en">
<head>
    <title>注册</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="style/user_register.css" rel="stylesheet" media="screen" />
</head>
<body>
    <jsp:include page="user_head.jsp" />

    <form action="user_register" id="register_form" class="form-horizontal" method="post">

        <div class="control-group">
            <label class="control-label" for="username">用户名</label>
            <div class="controls">
                <input type="text" name="user.name" label="用户名" id="username" />
                <span id="name_prompt">请输入用户名</span>
                <span id="rename_prompt">此用户名已存在，请重新输入</span>
            </div>
        </div>

        <div class="control-group">
           <label class="control-label" for="password">密码</label>
            <div class="controls">
                <input type="password" name="user.password" id="password" />
                <span id="password_prompt">请输入密码</span>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="testPassword">确认密码</label>
            <div class="controls">
                <input type="password" name="testPassword" id="testPassword"/>
                <span id="testPassword_prompt">请再次输入密码</span>
                <span id="rePassword_prompt">两次输入的密码不同，请重新输入</span>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="email">邮箱</label>
            <div class="controls">
                <input type="text" name="user.email" id="email" />
                <span id="email_prompt">请输入邮箱</span>
                <span id="email_format_prompt">您输入的邮箱格式不正确，请重新输入</span>
            </div>
        </div>
        <%--缺验证码--%>

        <div class="control-group">
            <div class="controls">
                <input type="button" class="btn btn-primary" value="注册" id="buttonSubmit"/>
                <input type="button" class="btn" value="重置" id="buttonReset"/>
            </div>
        </div>

    </form>



    <script src="/js/jquery-2.0.0.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="src/user_check.js"></script>
    <script src="src/user_register.js"></script>
</body>
</html>