
<html>
<head>
<title>Product list admin</title>
<link rel = "stylesheet" href = "css/table.css" type = "text/css"></link>

</head>
<body>
<form action="${pageContext.request.contextPath}/addProduct" method="POST">
  <div>
    <label for="productNameInput">Name</label>
    <input name="productName" id="productNameInput" value="" />
  </div>
  <div>
    <label for="categoryInput">Category</label>
    <input name="category" id="categoryInput" value="" />
  </div>
   <div>
   <label for="priceInput">Price</label>
    <input name="price" id="priceInput" value="" />
  </div>
  <div>
    <button type="submit">Add Product</button>
  </div>
</form>
</body>