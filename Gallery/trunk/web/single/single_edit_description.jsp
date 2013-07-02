<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-7-2
  Time: 上午11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<meta charset="gb2312">

<html lang="en">
<head>
    <title>Single edit Description</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="style/single_edit_description.css" rel="stylesheet" media="screen" />
</head>
<body>
    <jsp:include page="/user/user_head.jsp" />

    <div class="container">
    <p>
        新描述
    </p>
    <form action="/single/SingleEditDescriptionFinishAction" method="POST">
        <input type="text" name="imageId" value="<s:property value="imageId" />" style="display: none"/>
        <textarea rows="3" class="span9" id="descriptionArea" name="descriptionStr"><s:property value="descriptionList[0].description" /></textarea>

        <input type="submit" onclick='addDes(<s:property value="imageId" />)' value="提交" />
    </form>



    <s:if test="descriptionList.size == 0" >
        <p>暂无历史描述</p>
    </s:if>
    <s:else>
        <p>历史描述</p>


        <table class="table">
            <%!
                int i = 0;
            %>
            <s:iterator value="descriptionList" status="status">

                <tr>
                    <td>
                        <input type="button" value="apply" onclick="replace('history<%=i%>')"/>
                    </td>
                    <td id="history<%=i%>"><s:property value="description" /></td>
                    <td>
                        <s:property value="date" />
                    </td>
                </tr>
                <%
                    i++;
                %>
            </s:iterator>
        </table>
    </s:else>

    </div>
    <script src="/js/jquery-2.0.0.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="src/single_edit_description.js"></script>
    <script type="text/javascript">
        function replace(str)
        {
            var textArea = document.getElementById("descriptionArea");
            var text = document.getElementById(str);
            textArea.value = text.innerHTML;
        }
    </script>
</body>
</html>