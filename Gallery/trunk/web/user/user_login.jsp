<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-5-10
  Time: ����6:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<!doctype html>
<meta charset="utf-8">

<html>
<head>
    <title>�û���½</title>
    <script src="src/user_login.js"></script>
</head>
<body>
     <form action= "<%= response.encodeURL("user_login.do")%>" method="POST" >
         <p>�û���:<input type="text" name="user_name" value="" /></p>
         <p>���룺<input type="password" name="password" value="" /></p>
         <%--ȱ��֤��--%>
         <p>
             <input type="submit" />
             <input type="button" name="loginButton" value="��½" onclick="checkLoginInfo()" />
             <input type="button" name="resetButton" value="����" onclick="resetLoginInfo()" />
         </p>
     </form>
</body>
</html>