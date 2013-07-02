<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13-5-23
  Time: 下午7:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<!doctype html>
<meta charset="gb2312">
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html lang="en">
<head>
    <title>upload image</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="style/image_upload.css" rel="stylesheet" media="screen" />
</head>
<body>

    <jsp:include page="/user/user_head.jsp" />

    <form action ="image_upload" id="upload_form" class="form-horizontal" method ="POST" enctype ="multipart/form-data" >

            <div class="control-group">
                <div class="controls">
                    <%--<s:fielderror />--%>
                    <%--<s:file name ="images" label ="Image File" />--%>
                    <input type="file" name="images" id="fileUpload" />
                </div>
            </div>

        <div class="control-group">
            <label class="control-label" for="title">Title</label>
            <div class="controls">
                <input type="text" name="title" id="title" placeholder="Title"/>
                <span id="title_prompt">请输入图片标题</span>
            </div>
        </div>

            <div class="control-group">
                <label class="control-label" for="tag">Tag</label>
                <div class="controls">
                    <input type="text" name="tagStrings" id="tag" placeholder="Tag (divide by space)"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="description">Description</label>
                <div class="controls">
                    <%--<input type="text" name="title" id="description" placeholder="Descript"/>--%>
                    <textarea rows="3" id="description" name="descriptions"></textarea>
                    <span id="description_prompt">请输入图片描述</span>
                </div>
            </div>


            <div class="control-group">
                <div class="controls">
                    <input type="button" class="btn" value="上传" id="buttonSubmit"/>
                    <%--<input type="button" class="btn" value="重置" id="buttonReset"/>--%>
                </div>
            </div>

        <%--<s:textfield name ="titles" label ="title" />--%>
        <%--<s:textarea name = "descriptions" label="description" />--%>

        <%--<s:submit/>--%>
    </form>



    <script src="/js/jquery-2.0.0.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="src/image_upload.js"></script>
</body>
</html>