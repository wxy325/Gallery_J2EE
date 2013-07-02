<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-6-17
  Time: 下午8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<meta charset="gb2312">

<html lang="en">
<head>
    <title>修改密码</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="style/user_space_info.css" rel="stylesheet" media="screen" />
</head>
<body>
<div class="row-fluid">
    <jsp:include page="/user/user_head.jsp" />

    <div class="container-fluid">

        <div class="page-header">
            <h1>修改密码</h1>
        </div>

        <jsp:include page="user_space_nav.jsp" />

        <div class="span9">
            <div class="hero-unit">



                <form action="user_edit.action" id="edit_form" class="form-horizontal" method="post">

                    <div class="control-group">
                        <label class="control-label" for="oldPassword">原始密码</label>
                        <div class="controls">
                            <input type="password" name="user.password" id="oldPassword" placeholder="原始密码" />
                            <span id="oldPassword_prompt">请输入原始密码</span>
                        </div>

                    </div>


                    <div class="control-group">
                        <label class="control-label" for="newPassword">新密码</label>
                        <div class="controls">
                            <input type="password" name="newPassword" id="newPassword" placeholder="新密码"/>
                            <span id="newPassword_prompt">请输入密码</span>
                        </div>
                    </div>


                    <div class="control-group">
                        <label class="control-label" for="rePassword">再次输入</label>
                        <div class="controls">
                            <input type="password" name="rePassword" id="rePassword" placeholder="新密码"/>
                            <span id="rePassword_prompt">再次输入</span>
                        </div>
                    </div>


                    <div class="control-group">
                        <div class="controls">
                            <input type="button" class="btn" value="提交" id="buttonSubmit"/>
                            <input type="button" class="btn" value="重置" id="buttonReset"/>
                        </div>
                    </div>

                </form>






            </div>
        </div>
    </div>
</div>

<script src="/js/jquery-2.0.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>

<script src="/user/src/user_check.js"></script>
<script src="src/user_space_edit.js"></script>
</body>
</html>