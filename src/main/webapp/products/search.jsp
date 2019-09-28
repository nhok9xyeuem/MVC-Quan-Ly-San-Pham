<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title> Product List</title>
<h1>Search List</h1>
<p>
    <a href="/products">Back to Products list</a>
</p>
<p>
<form method="post">
    <input type="text" name="search" value="Search" >
</form>
</p>

<table border="1">
    <tr>
        <td>Id</td>
        <td>Ten San Pham</td>
        <td>Gia San Pham</td>
        <td>Mo Ta San Pham</td>
        <td>Hang San Xuat</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td><a href="products?action=view&id=${product.id}"> ${product.id} </a></td>
            <td>${product.tensanpham}</td>
            <td>${product.giasanpham}</td>
            <td>${product.motasanpham}</td>
            <td>${product.nhasanxuat}</td>
            <td><a href="products?action=edit&id=${product.id}">Edit</a></td>
            <td><a href="products?action=delete&id=${product.id}">Delete</a></td>

        </tr>
    </c:forEach>
</table>