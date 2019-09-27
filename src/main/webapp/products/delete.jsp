<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting Product</title>
</head>
<body>
<h1>Delete Product</h1>
<p>
    <a href="/products">Back to Product list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
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
            <tr>
                <td><input type="submit" value="Delete Product"></td>
                <td><a href="/products">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
