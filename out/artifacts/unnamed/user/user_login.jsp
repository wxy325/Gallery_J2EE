<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-5-10
  Time: 下午6:34
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=gb2312" language="java" %>--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<meta charset="gb2312">

<html lang="en">
<head>
    <title>登陆</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="style/user_login.css" rel="stylesheet" media="screen" />
    <%--<link href="/css/bootstrap-responsive.min.css" rel="stylesheet"  media="screen" />--%>
    <%--<script src="/js/jquery-ui-1.10.3.custom.min.js"></script>--%>

</head>

<body data-spy="scroll" data-target=".bs-docs-sidebar">
    <jsp:include page="user_head.jsp" />

    <form action="user_login" id="login_form" class="form-horizontal" method="post">

        <div class="control-group">
            <label class="control-label" for="name">用户名</label>
            <div class="controls">
                <input type="text" name="user.name" id="name" placeholder="用户名" />
                <span id="name_prompt">请输入用户名</span>
            </div>

        </div>


        <div class="control-group">
            <label class="control-label" for="password">密码</label>
            <div class="controls">
                <input type="password" name="user.password" id="password" placeholder="密码"/>
                <span id="password_prompt">请输入密码</span>
            </div>
        </div>

        <%--缺验证码--%>
        <div class="control-group">
            <div class="controls">
                <input type="button" class="btn" value="提交" id="buttonSubmit"/>
                <input type="button" class="btn" value="重置" id="buttonReset"/>
            </div>
        </div>

    </form>



    <script src="/js/jquery-2.0.0.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="src/user_check.js"></script>
    <script src="src/user_login.js"></script>

</body>

</html>