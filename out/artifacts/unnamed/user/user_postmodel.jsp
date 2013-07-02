<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-6-17
  Time: 下午10:40
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<meta charset="gb2312">

<html lang="en">
<head>
    <title>user postmodel</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="style/user_postmodel.css" rel="stylesheet" media="screen" />
</head>
<body>
    <jsp:include page="user_head.jsp" />




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
                    <p>A peaceful sunset view...</p>
                    <div class="meta">uplode by
                            <%--<s:if test="">--%>
                    </div>

                </div>

            </s:iterator>


        </div>
    </section>

    <s:url action="user_postmodel" namespace="/user" var="previewURL" >
        <s:param name="currentPage"><s:property value="previewPage" /> </s:param>
    </s:url>
    <s:url action="user_postmodel" namespace="/user" var="nextURL" >
        <s:param name="currentPage"><s:property value="nextPage" /> </s:param>
    </s:url>


    <div class="pagination">
        <ul>
            <li><s:a href="%{previewURL}">Prev</s:a></li>
            <s:iterator value="showPages" status="status">

                <s:url action="user_postmodel" namespace="/user" var="pageURL" >
                    <s:param name="currentPage"><s:property value="%{showPages[#status.index]}"/> </s:param>
                </s:url>

            <s:if test="currentPage==#status.index">
                <li class="disabled"><s:a href="%{pageURL}"><s:property value="%{showPages[#status.index] + 1}"/></s:a></li>
            </s:if>
            <s:else>
                <li><s:a href="%{pageURL}"><s:property value="%{showPages[#status.index] + 1}"/></s:a></li>
            </s:else>


            <%--<li><a href="#">2</a></li>--%>
            <%--<li><a href="#">3</a></li>--%>
            <%--<li><a href="#">4</a></li>--%>
            <%--<li><a href="#">5</a></li>--%>

            </s:iterator>
            <li><s:a href="%{nextURL}">Next</s:a></li>
        </ul>
    </div>





    <script src="/js/jquery-2.0.0.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/stream/image/src/blocksit.min.js"></script>
    <script src="/stream/image/src/image_stream.js"></script>
</body>
</html>