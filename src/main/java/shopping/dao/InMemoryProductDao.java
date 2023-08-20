package shopping.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import shopping.dto.Product;
import shopping.service.ProductDao;

public class InMemoryProductDao implements ProductDao{
	static List<Product> products = new ArrayList<>();
	static long id = 1;
	static {
		//We store product in a static member,
		//And add some initial products in this static block.
		addInitalData();
	}
	
	@Override
	public List<Product> findAll() {
		// TODO implement it
		return products;
	}
	
	

	@Override
	public Product find(long id) {
		Optional<Product> product = products.stream().filter(p-> p.getId().equals(id)).findFirst();
		return product.orElse(null);
	}     

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long add(Product product) {
		product.setId(id++);
		products.add(product);
		return product.getId();
	}
	
	private static void addInitalData() {
		products.addAll(List.of(new Product(id++, "spining reel", "fishing", 29.9), new Product(id++, "spining rod", "fishing", 39.9)));
	}
	protected static void reset() {
		products.clear();
		addInitalData();
	}

}
