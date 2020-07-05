<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%-- header base, css, jQuerry--%>
    <%@ include file="/pages/common/head.jsp" %>

    <script type="text/javascript">

        $(function () {
            $("a.deleteClass").click(function () {
                return confirm("Delete [" + $(this).parent().parent().find("td:first").text() + "], are you sure?");
            })
        })

    </script>
</head>
<body>

<%@ include file="/pages/common/manager_menu.jsp" %>


<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal+1}">添加图书</a></td>
        </tr>
    </table>

    <%@include file="/pages/common/page_nav.jsp"%>


</div>


<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>