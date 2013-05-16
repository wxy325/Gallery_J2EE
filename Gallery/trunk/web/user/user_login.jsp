<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-5-10
  Time: 下午6:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<!doctype html>
<meta charset="utf-8">

<html>
<head>
    <title>用户登陆</title>
    <script src="src/user_login.js"></script>
</head>
<body>
     <form action= "<%= response.encodeURL("user_login.do")%>" method="POST" >
         <p>用户名:<input type="text" name="user_name" value="" /></p>
         <p>密码：<input type="password" name="password" value="" /></p>
         <%--缺验证码--%>
         <p>
             <input type="submit" />
             <input type="button" name="loginButton" value="登陆" onclick="checkLoginInfo()" />
             <input type="button" name="resetButton" value="重置" onclick="resetLoginInfo()" />
         </p>
     </form>
</body>
</html>