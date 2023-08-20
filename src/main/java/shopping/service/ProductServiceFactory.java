package shopping.service;

import shopping.dao.InMemoryProductDao;
import shopping.dao.PostgresProductDao;

public class ProductServiceFactory {

	public static ProductService createProductService() {
		//return new ProductServiceImpl(new PostgresProductDao());
		return new ProductServiceImpl(new InMemoryProductDao());
	}
}
