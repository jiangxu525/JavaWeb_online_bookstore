<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%-- header base, css, jQuerry--%>
    <%@ include file="/pages/common/head.jsp" %>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">网上书城</span>
    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;

        </c:if>

        <c:if test="${not empty sessionScope.user}">
            <%@include file="/pages/common/login_sucess_menu.jsp" %>
        </c:if>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>


<p>抱歉，您访问的后台程序出现错误，程序员小哥正在努力维修。</p><br>
<a href="index.jsp">返回首页</a>

<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>