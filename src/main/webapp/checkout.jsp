<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/placeorder" method="POST">
  <h2>Shipping Address</h2>
  <div>
    <label for="shippingName">Name</label>
    <input name="shippingName" id="shippingName" value="" />
  </div>
  <div>
    <label for="shippingAddress">Address</label>
    <input name="shippingAddress" id="shippingAddress" value="" />
  </div>
   <div>
   <label for="shippingZipcode">Zip Code</label>
    <input name="shippingZipcode" id="shippingZipcode" value="" />
  </div>
  
  <h2>Order Summary</h2>
  <div>
  <div>Items:<span id="itemCount">(${shoppingCart.itemCount}):</span> <span id="subTotal">
  	<fmt:formatNumber type = "number" maxFractionDigits="2" value = "${shoppingCart.subtotal}" />
  </span></div>
  <div>Shipping &amp; handling: <span id="shippingCost">${shippingCost}</span></div>
  <div>Order Total: <span id="orderTotal"><fmt:formatNumber type = "number" maxFractionDigits="2" value = "${orderTotal}" /></span></div>
  </div>
  <button type="submit">Place Order</button>
</form>
</body>
</html>