<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<html>
<head>
<title>Product list admin</title>
<link rel = "stylesheet" href = "css/table.css" type = "text/css"></link>

</head>
<body>
<div align="center">
	<div align="center"><button onclick="window.location.href='${pageContext.request.contextPath}/addProduct'">Add Product</button></div>
	<table class = "styled-table">
        <tr>
	  	  <th>Id</th>
          <th>Product Name</th>
          <th>Category</th>
          <th>Price</th>
        </tr>
		<!-- Loop through the products to render table rows. -->
        <c:forEach var = "item" items = "${products}"> 
          <tr>
            <td class = "right"><c:out value="${item.id}" /></td>
            <td class = "center"><c:out value="${item.name}" /></td>
            <td class = "center"><c:out value="${item.category}" /></td>
	    	<td class = "right"><c:out value="\$${item.price}" /></td>
	    	<td><a href = "${pageContext.request.contextPath}/editProduct?id=${item.id}">Edit</a></td>
            <td><a href = "${pageContext.request.contextPath}/deleteProduct?id=${item.id}">Delete</a>
            </td>
            
          </tr>
        </c:forEach>
      </table>
</div>
</body>