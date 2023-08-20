package shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import shopping.dao.InMemoryProductDao;
import shopping.dto.LineItem;
import shopping.dto.Product;
import shopping.service.ProductService;
import shopping.service.ProductServiceFactory;
import shopping.service.ProductServiceImpl;
import shopping.service.ShoppingCart;

/**
 * Servlet implementation class AddToCartServlet
 */
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart cart = (ShoppingCart)request.getSession(true).getAttribute("shoppingCart");
		if(cart == null) {
			cart = new ShoppingCart();
		}
		
		long productId = Long.parseLong(request.getParameter("id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		ProductService productService = ProductServiceFactory.createProductService();
		Product product = productService.find(productId);
		
		cart.addToCart(new LineItem(productId, quantity, product.getName(), product.getCategory(), product.getPrice()));
		
		request.getSession().setAttribute("shoppingCart", cart);
		
		
		int totalItemCount = cart.getItemCount();
		
		Gson gson = new Gson();
		String json = gson.toJson(totalItemCount);

		PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
	}

}
