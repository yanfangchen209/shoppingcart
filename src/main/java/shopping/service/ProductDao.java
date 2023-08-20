package shopping.service;

import java.util.List;

import shopping.dto.Product;

/**
 * DAO is short for data access object.
 * You can implement dao by storing data in memory(Data will be lost after server restart).
 * Or you could implement your DAO layer by relation database,
 * Or in some case in NO SQL databases.
 * @param product
 * @return
 */


public interface ProductDao {
	/**
	 * Find all available products.
	 * Return an empty list if no product.
	 * @return
	 */
	List<Product> findAll();
	
	/**
	 * Find a product by id.
	 * If no matched product found, return null.
	 * @param id
	 * @return
	 */
	Product find(long id);
	
	/**
	 * Update the product.
	 * @param product
	 */
	void update(Product product);
	/**
	 * Delete product with given id.
	 * @param id
	 */
	void delete(long id);
	
	/**
	 * Add product.
	 * @param product
	 * @return
	 */
	long add(Product product);
}
