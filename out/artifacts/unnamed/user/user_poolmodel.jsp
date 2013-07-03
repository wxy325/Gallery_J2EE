<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-6-17
  Time: 下午10:44
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>

<!doctype html>
<meta charset="gb2312">

<html lang="en">
<head>
    <title>user postmodel</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="style/user_poolmodel.css" rel="stylesheet" media="screen" />

</head>
<body>
    <jsp:include page="user_head.jsp" />

    <div class="container">
    <p>
        创建新相片集
    </p>
    <p>
        <input type="text" id="newPoolName" />
        <input type="button" value="创建" onclick="addNewPool()"/>
    </p>

    <table class="table span5" >
        <s:iterator value="poolList" status="status">
            <tr>
                <td>
                    <s:url action="OnePoolAction" namespace="/stream/pool" var="poolURL">
                        <s:param name="poolId"><s:property value="id" /></s:param>
                    </s:url>
                    <s:a href="%{#poolURL}" >
                        <s:property value="name" />
                    </s:a>
                </td>
            </tr>
        </s:iterator>
    </table>
    </div>

    <script src="/js/jquery-2.0.0.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function addNewPool()
        {
            var inp = document.getElementById("newPoolName");
            var poolName = inp.value;
            if(poolName.length != 0)
            {
                $.post("/ajax/AjaxUserAddPoolAction.action",{"poolName":poolName},
                function(data)
                {
                    if(data.success)
                    {
                        alert("创建成功");
                        inp.value = "";

                        location.reload();
                    }
                    else
                    {
                        alert("创建失败");
                    }
                });
            }
        }
    </script>
</body>
</html>