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
 * Servlet implementation class AddProductServlet
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("addProduct.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get parameters
		String produceName = request.getParameter("productName");
		String category = request.getParameter("category");
		String priceStr = request.getParameter("price");
		
		double price = Double.parseDouble(priceStr);
		
		//Add the new product
		ProductService productService = ProductServiceFactory.createProductService();
		productService.add(new Product(produceName, category, price));
		
		
		//Retrieve all products
		List<Product> productsList = productService.findAll();
		//set request attributes so jsp page can access the products data.
		request.setAttribute("products", productsList);
		
		
		//forward to jsp to display the products list.
		RequestDispatcher rd = request.getRequestDispatcher("productList.jsp");
	    rd.forward(request, response);
		
		
	}

}
