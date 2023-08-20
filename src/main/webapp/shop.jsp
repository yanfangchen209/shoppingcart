<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<html>
<head>
<title>Product list admin</title>
<link rel = "stylesheet" href = "css/table.css" type = "text/css"></link>
<link rel = "stylesheet" href = "css/shoppingcartIcon.css" type = "text/css"></link>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"></link>
<script src="js/jquery-3.6.4.min.js"></script>
<script src="js/shopping.js"></script>

</head>
<body>
		
<div align="center">
	<div>${message}</div>
	<div align="right">
		<a href="${pageContext.request.contextPath}/shoppingcart">
			<span class="fa-stack fa-2x has-badge" id="data-count" data-count="${shoppingCart.itemCount}">
  			<i class="fa fa-circle fa-stack-2x fa-inverse"></i>
  			<i style="" class="fa fa-shopping-cart fa-stack-2x red-cart"></i>
		</span>
		</a>
	</div>
	<table class = "styled-table">
        <tr>
	  	  <th>Id</th>
          <th>Product Name</th>
          <th>Category</th>
          <th>Price</th>
        </tr>

        <c:forEach var = "item" items = "${products}"> 
          <tr>
            <td class = "right"><c:out value="${item.id}" /></td>
            <td class = "center"><c:out value="${item.name}" /></td>
            <td class = "center"><c:out value="${item.category}" /></td>
	    	<td class = "right"><c:out value="\$${item.price}" /></td>
	    	<td><input type="hidden" name="productId" value='<c:out value="${item.id}"></c:out>'>
	    	<select name="quantitySelect">
	    	<option value="1">1</option>
	    	<option value="2">2</option>
	    	<option value="3">3</option>
	    	</select><button onclick="addToCart(this)">Add to Cart</button></td>
            
          </tr>
        </c:forEach>
      </table>
</div>
</body>