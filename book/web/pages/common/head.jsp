<%--
  Created by IntelliJ IDEA.
  User: jiang
  Date: 6/27/2020
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<base href = "http://localhost:8080/book/"> --%>
<%
    String basePath = request.getScheme()
                        + "://"
                        + request.getServerName()
                        + ":"
                        + request.getServerPort()
                        + request.getContextPath()
                        + "/";

    pageContext.setAttribute("basePath", basePath);
%>
<base href = "<%=basePath%>">
<%
    System.out.println(basePath);
%>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
