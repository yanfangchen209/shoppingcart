package shopping.service;

import java.util.List;

import shopping.dto.Product;

public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao;
	
	public ProductServiceImpl(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Product find(long id) {
		return productDao.find(id);
	}

	@Override
	public void update(Product product) {
		 productDao.update(product);

	}

	@Override
	public void delete(long id) {
		productDao.delete(id);

	}

	@Override
	public void add(Product product) {
		productDao.add(product);
	}

}
