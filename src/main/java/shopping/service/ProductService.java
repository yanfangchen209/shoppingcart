package shopping.service;

import java.util.List;

import shopping.dto.Product;

public interface ProductService {
	List<Product> findAll();
	Product find(long id);
	void update(Product product);
	void delete(long id);
	void add(Product product);
}
