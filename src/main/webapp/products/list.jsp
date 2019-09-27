<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title> Product List</title>
<h1>Product List</h1>
<p>
    <a href="products?action=create">Create new Product</a>

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
    <c:forEach items="${requestScope['products']}" var="product">
        <tr>
            <td><a href="products?action=view$id=${product.getId()}">${product.getTensanpham()}</a></td>
            <td>${product.getGiasanpham()}</td>
            <td>${product.getMotasanpham()}</td>
            <td>${product.getHangsanxuat()}</td>
            <td><a href="products?action=edit$id=${product.getId()}">Edit</a></td>
            <td><a href="products?action=delete$id=${product.getId()}">Delete</a></td>

        </tr>
    </c:forEach>
</table>