<%--
  Created by IntelliJ IDEA.
  User: wxy325
  Date: 13-5-10
  Time: ����6:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=gb2312" language="java" %>

<div id="user_head">
    <%
        if (request.getSession().getAttribute("user_name") == null){
    %>

            <a href="<%=response.encodeURL(request.getContextPath() + "/user/user_login.jsp")%>">��½</a>
            <a href="<%=response.encodeURL(request.getContextPath() + "/user/user_register.jsp")%>">ע��</a>
    <%  }
        else
        {
    %>
            <p> Welcome,<%=request.getSession().getAttribute("user_name") %> <p>
            <a href="<%=response.encodeURL(request.getContextPath() + "/user/user_logout.jsp")%>">�˳���½</a>
    <%
        }
    %>
</div>