<%--
  Created by IntelliJ IDEA.
  User: nhok9xyeuem
  Date: 9/27/19
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<h1> Product details</h1>
<p>
    <a href="/products">Back to Product list</a>
</p>
<table>
    <tr>
        <td>ID</td>
        <td>${requestScope["products"].getId()}</td>
    </tr>
    <tr>
        <td>Ten San Pham</td>
        <td>${requestScope["products"].getTensanpham()}</td>
    </tr>
    <tr>
        <td>Gia San Pham </td>
        <td>${requestScope["products"].getGiasanpham()}</td>
    </tr>
    <tr>
        <td>Mo Ta San Pham</td>
        <td>${requestScope["products"].getMotasanpham()}</td>
    </tr>
    <tr>
        <td>Nha San Xuat</td>
        <td>${requestScope["products"].getNhasanxuat()}</td>
    </tr>
</table>
</body>
</html>
