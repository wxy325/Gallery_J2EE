<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-7-2
  Time: 上午1:15
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=gb2312" language="java" %>--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<meta charset="gb2312">

<html lang="en">
<head>
    <title>Single Image</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="style/single_image.css" rel="stylesheet" media="screen" />
</head>

<body>

    <jsp:include page="/user/user_head.jsp" />


    <%--<p><s:property value="postmodel.id" /></p>--%>

    <div class="container">

    <div class="row">
        <div class="span9">
            <div class="hero-unit">
                <h1>
                    <s:property value="postmodel.title" />
                </h1>
                <div>
                    <img src="/ImageFolder/<s:property value='postmodel.name'/>" class="img-polaroid" alt="" width="800"/>
                </div>
                <p>
                    <br />
                    <s:if test="descriptionids==null">
                        暂无图片描述
                    </s:if>
                    <s:else>
                        <s:property value="descriptionids.description" />
                    </s:else>
                    <br />
                </p>

                <s:if test="descriptionEditable">
                    <p style="text-align: right">
                        <s:url action="SingleEditDescriptionAction" namespace="/single" var="editDescriptionURL">
                            <s:param name="imageId"><s:property value="imageId"></s:property></s:param>
                        </s:url>
                        <s:a href="%{editDescriptionURL}">
                            编辑图片描述
                        </s:a>
                    </p>
                </s:if>
            </div>
        </div>

        <div class="span2">
            <table class="table">

                <tr>
                <td>
                   上传者:<br/>
                   <s:if test="creator==null">
                       匿名用户

                   </s:if>
                   <s:else>
                       <s:property value="creator.name" />
                   </s:else>
                </td>
                </tr>

                <tr>
                <td>
                    艺术家:<br/>
                    <s:if test="artistmodel==null">
                        未知
                    </s:if>
                    <s:else>
                        <s:property value="artistmodel.name" />
                    </s:else>

                </td>
                </tr>

                <tr>
                    <td>
                        上传时间:<br/>
                        <s:property value="postmodel.createdAt" />
                    </td>
                </tr>

                <tr>
                    <td>
                        累计访问:<br/>
                        <s:property value="postmodel.visited" />
                    </td>
                </tr>

                <tr>
                    <td>
                        平均得分:<br/>
                        <s:if test="averageRemark==null">
                            目前尚未有人评分
                        </s:if>
                        <s:else>
                            <s:property value="averageRemark" />
                        </s:else>
                    </td>
                </tr>
            </table>
        </div>
    </div>


        <div class="row">
            <div class="span9">
                <p>
                    评论
                </p>
                <p>
                    <textarea rows="3" id="commentArea" class="span9"></textarea>
                </p>
                <p>
                    <input type="button" onclick='addComment(<s:property value="imageId" />)' value="提交" />
                </p>

                <table class="table">
                <div id="comment_table">
                    <s:if test="commentsList.size == 0">
                        <tr>
                            <td>
                                暂无评论
                            </td>
                        </tr>
                    </s:if>
                    <s:else>
                        <s:iterator value="commentsList" status="status">
                            <tr>
                                <td>
                                    <p>
                                        <s:if test="commentCreatorsList[#status.index]==null">
                                            匿名用户
                                        </s:if>
                                        <s:else>
                                            <s:property value="commentCreatorsList[#status.index].name" />
                                        </s:else>
                                         : <s:property value="comment" />
                                    </p>
                                    <p> <s:property value="date" /> </p>
                                </td>
                            </tr>
                        </s:iterator>
                    </s:else>
                </div>
                </table>
            </div>
        </div>

    </div>


    <script src="/js/jquery-2.0.0.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="src/single_image.js"></script>
    <script type="text/javascript">
        function addComment(postId)
        {
            var commentArea = document.getElementById("commentArea");
            $.post("/ajax/AjaxImageAddCommentAction",{"postId":postId,"commentContent":commentArea.value},
            function(data)
            {
                alert("评论成功");
                location.reload();
            });
        }
    </script>



</body>
</html>