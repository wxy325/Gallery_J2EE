<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-5-11
  Time: ����9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
     <form action="user_register.do" method="POST">
        <p>�û��� ��<input type="text" name="user_name" value="" /></p>
        <p>���룺<input type="password" name= "pass_word" value="" /></p>
        <p>���䣺<input type="text" name="pass_word" value="" /></p>
         <%--ȱ��֤��--%>
        <p>
            <%--submit�Ժ�Ҫɾ��--%>
            <input type="submit" />
            <input type="button" value="�ύ" />
            <input type="button" value="����" />
         </p>

     </form>
</body>
</html>