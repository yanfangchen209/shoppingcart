package shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.dao.InMemoryProductDao;
import shopping.dto.Product;
import shopping.service.ProductService;
import shopping.service.ProductServiceFactory;
import shopping.service.ProductServiceImpl;
import shopping.service.ShoppingCart;

/**
 * Servlet implementation class ShoppingServlet
 */
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productService = ProductServiceFactory.createProductService(); 
		List<Product> productsList = productService.findAll();
		
		//put product list in request attributes so jsp page can access the products data.
		request.setAttribute("products", productsList);
		
		//Get message from session if there're any.
		String message = (String)request.getSession(true).getAttribute("message");
		if(message != null) {
			//Remove the message from session and put into request attributes.
			//So this message will be displayed only once to user.
			request.getSession().removeAttribute("message");
			request.setAttribute("message", message);
		}
		
		//Get the shoppping cart object from session.
		ShoppingCart cart = (ShoppingCart)request.getSession(true).getAttribute("shoppingCart");
		if(cart == null) {
			//If there's no cart in session yet, we create a new one and put it into session.
			cart = new ShoppingCart();
			request.getSession().setAttribute("shoppingCart", cart);
		}
		
		//Dispatch to shop.jsp for view display.
		RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
