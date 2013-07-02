<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-6-8
  Time: 下午4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<meta charset="gb2312">

<html lang="en">
<head>
    <title>我的评论</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="style/user_space_info.css" rel="stylesheet" media="screen" />
</head>
<body>
<div class="row-fluid">
    <jsp:include page="/user/user_head.jsp" />

    <div class="container-fluid">

        <div class="page-header">
            <h1>我的评论</h1>
        </div>

        <jsp:include page="user_space_nav.jsp" />

        <div class="span9">
            <div class="hero-unit">


            </div>
        </div>
    </div>
</div>

<script src="/js/jquery-2.0.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>

<script>
    $(document).ready(
            function()
            {
                $("#userComment").addClass("active");
            }
    );
</script>
</body>
</html>