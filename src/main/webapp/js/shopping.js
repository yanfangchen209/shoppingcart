function addToCart(link){
	
  //link is an plain javascript element, $(link) turn it into an jquery object.
  var parent = $(link).parent();
  //Find the input whose name is productId under parent element.
  var productId = parent.children('input[name="productId"]').val();

  var quantity = parent.children('select[name="quantitySelect"]').val();
  
  console.log("quantity"+ quantity);
  
  //Send an ajax call to addToCart url to update the quantity of given productId
  $.post( "addToCart", { id: productId, quantity: quantity } )
  .done(function( data ) {
    console.log( "Data Loaded: " + data );
    //In the response, the data is the latest product item count, show it in shopping cart icon.
    $("#data-count").attr("data-count", data);
    
  });
}