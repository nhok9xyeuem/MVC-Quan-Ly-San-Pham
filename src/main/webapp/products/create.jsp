<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nhok9xyeuem
  Date: 9/27/19
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<h1> Create Product</h1>
<c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
</c:if>
<p>
    <a href="/products">Back to Product List</a>
</p>
<form method="post" action="">
    <fieldset>
        <legend>Product List</legend>

        <table>
            <tr>
                <td>ID</td>
                <td><input type="number" name="id" placeholder="id" ></td>
            </tr>
            <tr>
                <td>Ten San Pham</td>
                <td><input type="text" name="tensanpham" placeholder="tensanpham"></td>
            </tr>
            <tr>
                <td>Gia San Pham </td>
                <td><input type="number" name="giasanpham" placeholder="0"></td>
            </tr>
            <tr>
                <td>Mo Ta San Pham</td>
                <td><input type="text" name="motasanpham" placeholder="motasanpham"></td>
            </tr>
            <tr>
                <td>Nha San Xuat</td>
                <td><input type="text" name="nhasanxuat" placeholder="nhasanxuat"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Create Product"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
