package shopping.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import shopping.dto.Product;

public class InMemoryProductDaoTest {
	
	@Before
	public void init() {
		//Clear in memory data.
		InMemoryProductDao.reset();
	}
	
	@Test
	public void testAddOne() {
		InMemoryProductDao dao = new InMemoryProductDao();
		long id = dao.add(new Product("test", "home", 25.0));
		
		Product product = dao.find(id);
		assertEquals(id, product.getId().longValue());
		assertEquals("home", product.getCategory());
		
	}
	
	@Test
	public void testDelete() {
		//delete product whose id is 1 and verify it does not exist anymore.
		
	}
	
}
