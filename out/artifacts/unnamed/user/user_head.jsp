<%--
  Created by IntelliJ IDEA.
  User: wxy325
  Date: 13-5-10
  Time: ����6:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=gb2312" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%--<link rel="stylesheet" type="text/css" href="/user/style/user_head.css" />--%>

<s:set name="userModel" value="#session['UserModel']" />


<div class="navbar navbar-fixed-top navbar-inverse">
    <div class="navbar-inner">
        <%--<div class="container">--%>
        <div class="container-fluid">

            <s:url value="/index.jsp" var="indexURL" />
            <s:url value="/upload/image_upload.jsp" var="uploadURL" />
            <s:url action="RandomImageStreamAction" namespace="/stream/image" var="randomURL" />


            <s:url action="ImageRankStreamAction" namespace="/stream/image" var="newURL" >
                <s:param name="currentPage">0</s:param>
                <s:param name="streamType">New</s:param>
            </s:url>
            <s:url action="ImageRankStreamAction" namespace="/stream/image" var="topHitURL" >
                <s:param name="currentPage">0</s:param>
                <s:param name="streamType">TopHit</s:param>
            </s:url>
            <s:url action="ImageRankStreamAction" namespace="/stream/image" var="topRateURL" >
                <s:param name="currentPage">0</s:param>
                <s:param name="streamType">TopRate</s:param>
            </s:url>



            <a class="brand" href="/">Gallery</a>
            <ul class="nav pull-left">

                <li id="head_index"><s:a href="%{#indexURL}">��ҳ</s:a></li>
                <li id="head_random"><s:a href="%{#randomURL}">��㿴��</s:a></li>
                <li id="head_new"><s:a href="%{#newURL}">�����ϴ�</s:a></li>

                <li id="head_top" class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        Top
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><s:a href="%{#topHitURL}">Top Hit</s:a></li>
                        <li><s:a href="%{#topRateURL}">Top Rate</s:a></li>
                        <li><a href="#">Top Tag</a></li>
                    </ul>
                </li>

                <li id="head_search"><a href="#">����</a></li>
                <li id="head_upload"><s:a href="%{#uploadURL}">�ϴ�</s:a></li>
            </ul>




            <ul class="nav pull-right">
                <li>
                    <form class="navbar-search pull-right">
                        <input type="text" class="search-query" placeholder="Search">
                    </form>
                </li>
                <s:if test="#userModel == null">
                    <s:url value="/user/user_login.jsp" var="loginURL" />
                    <s:url value="/user/user_register.jsp" var="registerURL" />

                    <li id="head_login">
                        <s:a href="%{#loginURL}">��½</s:a>
                    </li>
                    <li id="head_register">
                        <s:a href="%{#registerURL}">ע��</s:a>
                    </li>
                </s:if>
                <s:else>
                    <s:url action="user_logout" namespace="/user" var="logoutURL" />
                    <s:url action="user_space" namespace="/user/space" var="spaceURL">
                        <s:param name="type">info</s:param>
                    </s:url>
                    <s:url action="user_postmodel" namespace="/user" var="userPostmodelURL" >
                        <s:param name="currentPage">0</s:param>
                    </s:url>
                    <s:url action="user_poolmodel" namespace="/user" var="userPoolmodelURL" />


                    <li id="head_user" class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <s:property value="#userModel.name" />
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><s:a href="%{userPostmodelURL}">ͼƬ��</s:a></li>
                            <li><s:a href="%{userPoolmodelURL}">��Ƭ��</s:a></li>

                            <li><s:a href="%{spaceURL}">��������</s:a></li>
                            <li><s:a href="%{#logoutURL}">�˳���½</s:a></li>
                        </ul>
                    </li>

                </s:else>
            </ul>

        </div>
        <%--</div>--%>
    </div>
</div>

