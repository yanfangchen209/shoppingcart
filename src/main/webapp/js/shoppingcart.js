function onQuantityChange(select, productId){
	//link is an plain javascript element, $(select) turn it into an jquery object.
	var selectComp = $(select);
	
	//Get the value of current select widget.
	var quantity = selectComp.val();
	
	if(quantity == 0){
		//If user set quantity to 0, we need delete this item from shopping cart.
		var row = selectComp.parents('.item-row').first();
		row.remove();
	}
	
	//Send an ajax call using jquery to update item quantity in cart.
	$.post( "updateItemQuantityInCart", { id: productId, quantity: quantity } )
	.done(function( data ) {
	    console.log( "Data Loaded: " + data );
	    //The returned data have information about the latest item cound and subTotal.
	    //Update it on UI.
	    $("#rowItemCount").text(data.count);
	    $("#itemCount").text(data.count);
	    $("#rowSubTotal").text(data.subTotal);
	    $("#subTotal").text(data.subTotal);
	  });
}