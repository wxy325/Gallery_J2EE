<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-6-8
  Time: ����4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=gb2312" language="java" %>

<s:url action="user_space" namespace="/user/space" var="userInfoURL">
    <s:param name="type">info</s:param>
</s:url>
<s:url action="user_space" namespace="/user/space" var="userCommentURL">
    <s:param name="type">comment</s:param>
</s:url>
<s:url action="user_space" namespace="/user/space" var="userRemarkURL">
    <s:param name="type">remark</s:param>
</s:url>
<s:url action="user_space" namespace="/user/space" var="userEditURL">
    <s:param name="type">edit</s:param>
</s:url>


<div class="span2">
    <ul class="nav nav-tabs nav-stacked">

        <li id="userInfo"><s:a href="%{userInfoURL}">������Ϣ</s:a></li>
        <li id="userComment"><s:a href="%{userCommentURL}">�ҵ�����</s:a></li>
        <li id="userRemark"><s:a href="%{userRemarkURL}">�ҵ�����</s:a></li>
        <li id="userEdit"><s:a href="%{userEditURL}">�޸�����</s:a></li>
    </ul>
</div>