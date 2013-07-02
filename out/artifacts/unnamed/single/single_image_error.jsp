<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-7-2
  Time: 上午11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<meta charset="gb2312">

<html lang="en">
<head>
    <title>请求的图片不存在</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="style/single_image_error.css" rel="stylesheet" media="screen" />
</head>
<body>
<jsp:include page="/user/user_head.jsp" />

<h1>请求的图片不存在</h1>
<p>3秒后自动返回首页</p>


<script src="/js/jquery-2.0.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="src/single_image_error.js"></script>

</body>
</html>