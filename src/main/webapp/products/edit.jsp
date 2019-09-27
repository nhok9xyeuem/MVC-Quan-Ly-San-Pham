<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Products</title>
</head>
<body>
<h1>Edit Products</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to Products list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Products information</legend>
        <table>
            <tr>
                <td>Ten San Pham</td>
                <td><input type="text" name="tensanpham" value="${requestScope["products"].getTensanpham()}"></td>
            </tr>
            <tr>
                <td>Gia San Pham </td>
                <td><input type="number" name="giasanpham" value="${requestScope["products"].getGiasanpham()}"></td>
            </tr>
            <tr>
                <td>Mo Ta San Pham</td>
                <td><input type="text" name="motasanpham" value="${requestScope["products"].getMotasanpham()}"></td>
            </tr>
            <tr>
                <td>Nha San Xuat</td>
                <td><input type="text" name="nhasanxuat" value="${requestScope["products"].getNhasanxuat()}"></td>
            </tr>
            <tr>
                <td><input type="submit"  value=" Update"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>