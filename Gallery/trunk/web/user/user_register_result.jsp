<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-5-11
  Time: ����10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <p>
        <%
           Boolean isSuccess = (Boolean)request.getAttribute("isLoginSuccess");
           if (isSuccess.booleanValue())
           {

        %>
            <%=session.getAttribute("user_name")%>��ע��ɹ���
        <%
            }
            else
            {
        %>
            ע��ʧ�ܡ�
        <%
            }
        %>
    </p>

</body>
</html>