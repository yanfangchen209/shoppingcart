package shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.dao.InMemoryProductDao;
import shopping.dao.PostgresProductDao;
import shopping.dto.Product;
import shopping.service.ProductService;
import shopping.service.ProductServiceFactory;
import shopping.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductListServlet
 */
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Call product service to find all product.
		ProductService productService = ProductServiceFactory.createProductService();
		List<Product> productsList = productService.findAll();
		
		//set request attributes so jsp page can access the products data.
		request.setAttribute("products", productsList);
		
		//Dispatch to productList.jsp to display the list.
		RequestDispatcher rd = request.getRequestDispatcher("productList.jsp");
	    rd.forward(request, response);
		
	}


}
