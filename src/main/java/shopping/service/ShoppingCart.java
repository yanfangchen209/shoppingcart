package shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import shopping.dto.LineItem;

public class ShoppingCart {
	private List<LineItem> items = new ArrayList<>();
	
	//If item not exist, put it in list, if already exist. update existing quantity.
	public void addToCart(LineItem newItem) {
		Optional<LineItem> item = items.stream().filter(i-> i.getId().equals(newItem.getId()) ).findFirst();
		item.ifPresentOrElse(i -> i.setQuantity(i.getQuantity() + newItem.getQuantity()),
				()-> items.add(newItem));
	}
	
	
	public void setItemQuantity(long id, int quantity) {
		Optional<LineItem> item = items.stream().filter(i-> i.getId().equals(id) ).findFirst();
		LineItem targetItem = item.orElseThrow();
		targetItem.setQuantity(quantity);
	}
	
	public int getItemCount() {
		return items.stream().map(item-> item.getQuantity()).reduce(0, (a, b)-> a + b); 
	}
	
	public double getSubtotal() {
		return items.stream().map(item-> item.getQuantity() * item.getPrice()).reduce(0.0, (a, b)-> a + b); 
	}
	
	public List<LineItem> getAllItems(){
		return items;
	}

}
