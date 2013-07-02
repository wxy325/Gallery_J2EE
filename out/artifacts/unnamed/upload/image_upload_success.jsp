<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-5-23
  Time: ÏÂÎç7:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
</head>
<body>
      <p>upload success</p>
      <s:iterator value="imageFileName" status="length">

          <div style="padding: 3px; border: solid 1px #cccccc; text-align: center">
              <img src='/ImageFolder/<s:property value ="top" /> ' />
              <br />
              <s:property value="caption" />
          </div>
      </s:iterator>
</body>
</html>