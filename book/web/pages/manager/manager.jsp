<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <%-- header base, css, jQuerry--%>
    <%@ include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<%@ include file="/pages/common/manager_menu.jsp"%>


<div id="main">
    <h1>欢迎管理员进入后台管理系统</h1>
</div>

<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>