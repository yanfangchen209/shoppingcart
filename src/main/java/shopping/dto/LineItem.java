package shopping.dto;

/**
 * This stand for product user selected in their cart.
 *
 */
public class LineItem {
	
	private Long id;
	private int quantity;
	private String name;
	private String category;
	private double price;
	
	public LineItem(Long id, int quantity, String name, String category, double price) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	

}
