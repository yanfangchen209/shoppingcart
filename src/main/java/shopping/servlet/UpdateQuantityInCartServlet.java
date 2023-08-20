package shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import shopping.dao.InMemoryProductDao;
import shopping.dto.Product;
import shopping.service.ProductService;
import shopping.service.ProductServiceFactory;
import shopping.service.ProductServiceImpl;
import shopping.service.ShoppingCart;

/**
 * Servlet implementation class UpdateQuantityInCartServlet
 */
public class UpdateQuantityInCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQuantityInCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart cart = (ShoppingCart)request.getSession(true).getAttribute("shoppingCart");
		long productId = Long.parseLong(request.getParameter("id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		ProductService productService = ProductServiceFactory.createProductService();
		Product product = productService.find(productId);
		cart.setItemQuantity(productId, quantity);
		
		request.getSession().setAttribute("shoppingCart", cart);
		
		int totalItemCount = cart.getItemCount();
		double subTotal = cart.getSubtotal();
		Map<String, Object> result = new HashMap<>();
		result.put("count", totalItemCount);
		result.put("subTotal", subTotal);
		Gson gson = new Gson();
		String json = gson.toJson(result);

		PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
	}

}
