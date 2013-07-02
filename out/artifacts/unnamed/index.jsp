<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<meta charset="gb2312">

<html lang="en">
    <head>
       <title>Home Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

          <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen" />
          <style rel="stylesheet">
              body
              {
                  padding-top: 80px;
              }
          </style>
       </head>
    <body>
        <jsp:include page="/user/user_head.jsp" />

        <p>Hahaha</p>

        <script src="/js/jquery-2.0.0.min.js"></script>
        <script src="/js/bootstrap.min.js"></script>

        <script>
            $(document).ready(function()
            {
                $("#head_index").addClass("active");
            });
        </script>

    </body>
</html>