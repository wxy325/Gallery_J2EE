<%--
  Created by IntelliJ IDEA.
  User: wxy325
  Date: 13-5-10
  Time: ÏÂÎç6:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=gb2312" language="java" %>

<div id="user_head">
    <%
        if (request.getSession().getAttribute("user_name") == null){
    %>

            <a href="<%=response.encodeURL(request.getContextPath() + "/user/user_login.jsp")%>">µÇÂ½</a>
            <a href="<%=response.encodeURL(request.getContextPath() + "/user/user_register.jsp")%>">×¢²á</a>
    <%  }
        else
        {
    %>
            <p> Welcome,<%=request.getSession().getAttribute("user_name") %> <p>
            <a href="<%=response.encodeURL(request.getContextPath() + "/user/user_logout.jsp")%>">ÍË³öµÇÂ½</a>
    <%
        }
    %>
</div>