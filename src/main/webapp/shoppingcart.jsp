<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="UTF-8">
<title>Your shopping cart</title>
<!-- import css stylesheet for the shopping cart -->
<link rel = "stylesheet" href = "css/shoppingcart.css" type = "text/css"></link>
<!-- import the jqeury library so in  shoppingcart.js it can use jquery -->
<script src="js/jquery-3.6.4.min.js"></script>
<!-- Import the shppingcart.js -->
<script src="js/shoppingcart.js"></script>
</head>
<body>

<div class="row">
	<div align="center" class="left column">
		<div align="left"><span class="cart-title">Shopping Cart</span></div>
		<div style="text-align:right" class="price-row"><span class="price-text">Price</span></div>
		<c:forEach var = "item" items = "${shoppingCart.allItems}"> 
			<div align="left" class="item-row">
				<div class="item-title"><span>${item.name}</span></div>
				<div style="float:right;">${item.price}</div>
				<div  class="quantity"><select onchange="onQuantityChange(this, ${item.id})">
					<c:forEach var="i" begin="0" end="10" step="1">
					<option value="${i}" ${i == item.quantity ? 'selected="selected"' : ''}>${i}</option>
					</c:forEach></select>
				</div>
			</div>
		</c:forEach>
			<div align="right" class="items-subtotal">
			<span>Subtotal(<span id="rowItemCount">${shoppingCart.itemCount}</span> items): \$<span id="rowSubTotal">
			<fmt:formatNumber type="number" maxFractionDigits="2" value = "${shoppingCart.subtotal}" />
			</span></span>
			</div>
		</div>
		
	  <div class="right column">
	  	<form action="${pageContext.request.contextPath}/checkout" method="POST">
		  	<div>Subtotal(<span id="itemCount">${shoppingCart.itemCount}</span> items): \$<span id="subTotal">
		  	<fmt:formatNumber type = "number" maxFractionDigits="2" value = "${shoppingCart.subtotal}" /></span></div>
		  	<div><button type="submit">Checkout</button></div>
	  	</form>
	  </div>
</div>



</body>
</html>