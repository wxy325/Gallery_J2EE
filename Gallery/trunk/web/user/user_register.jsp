<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-5-11
  Time: 上午9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
     <form action="user_register.do" method="POST">
        <p>用户名 ：<input type="text" name="user_name" value="" /></p>
        <p>密码：<input type="password" name= "pass_word" value="" /></p>
        <p>邮箱：<input type="text" name="pass_word" value="" /></p>
         <%--缺验证码--%>
        <p>
            <%--submit以后要删除--%>
            <input type="submit" />
            <input type="button" value="提交" />
            <input type="button" value="重置" />
         </p>

     </form>
</body>
</html>