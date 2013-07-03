<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-7-1
  Time: 下午10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<meta charset="gb2312">

<html lang="en">
<head>
    <title><s:property value="poolmodel.name" /> </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="/stream/image/style/random_image_stream.css" rel="stylesheet" media="screen" />


</head>
<body>
<jsp:include page="/user/user_head.jsp" />


<%--<ul class="thumbnails">--%>

<%--<s:iterator value="imagesList" status="status">--%>
<%--<li class="span4">--%>
<%--<div class="thumbnail">--%>

<%--<img src="/ImageFolder/<s:property value='name'/>" alt="">--%>
<%--<h3>Thumbnail label</h3>--%>
<%--<p>Thumbnail caption...</p>--%>

<%--</div>--%>
<%--</li>--%>
<%--</s:iterator>--%>

<%--</ul>--%>


<section id="wrapper">
    <div id="container">

        <s:iterator value="imagesList" status="status">
            <s:url action="SingleImageAction" namespace="/single" var="singleURL">
                <s:param name="imageId">
                    <s:property value="id" />
                </s:param>
            </s:url>

            <div class="grid">

                <div class="imgholder">

                    <s:a href="%{singleURL}">
                        <img src="/ImageFolder/<s:property value='name'/>" alt="">
                    </s:a>
                </div>
                <strong><s:property value="title" /></strong>
                <%--<p>A peaceful sunset view...</p>--%>
                <%--<div class="meta">uplode by--%>
                        <%--&lt;%&ndash;<s:if test="">&ndash;%&gt;--%>
                <%--</div>--%>

            </div>

        </s:iterator>


    </div>
</section>






<script src="/js/jquery-2.0.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="src/blocksit.min.js"></script>
<script src="src/image_stream.js"></script>
</body>
</html>