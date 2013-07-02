<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-6-17
  Time: ����8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<meta charset="gb2312">

<html lang="en">
<head>
    <title>�޸�����</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="style/user_space_info.css" rel="stylesheet" media="screen" />
</head>
<body>
<div class="row-fluid">
    <jsp:include page="/user/user_head.jsp" />

    <div class="container-fluid">

        <div class="page-header">
            <h1>�޸�����</h1>
        </div>

        <jsp:include page="user_space_nav.jsp" />

        <div class="span9">
            <div class="hero-unit">



                <form action="user_edit.action" id="edit_form" class="form-horizontal" method="post">

                    <div class="control-group">
                        <label class="control-label" for="oldPassword">ԭʼ����</label>
                        <div class="controls">
                            <input type="password" name="user.password" id="oldPassword" placeholder="ԭʼ����" />
                            <span id="oldPassword_prompt">������ԭʼ����</span>
                        </div>

                    </div>


                    <div class="control-group">
                        <label class="control-label" for="newPassword">������</label>
                        <div class="controls">
                            <input type="password" name="newPassword" id="newPassword" placeholder="������"/>
                            <span id="newPassword_prompt">����������</span>
                        </div>
                    </div>


                    <div class="control-group">
                        <label class="control-label" for="rePassword">�ٴ�����</label>
                        <div class="controls">
                            <input type="password" name="rePassword" id="rePassword" placeholder="������"/>
                            <span id="rePassword_prompt">�ٴ�����</span>
                        </div>
                    </div>


                    <div class="control-group">
                        <div class="controls">
                            <input type="button" class="btn" value="�ύ" id="buttonSubmit"/>
                            <input type="button" class="btn" value="����" id="buttonReset"/>
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