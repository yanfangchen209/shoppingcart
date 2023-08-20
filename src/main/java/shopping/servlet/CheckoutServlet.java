package shopping.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.service.ShoppingCart;

/**
 * Servlet implementation class CheckoutServlet
 */
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart cart = (ShoppingCart)request.getSession(true).getAttribute("shoppingCart");
		
		double shippingCost = 5.0d;
		double total = shippingCost + cart.getSubtotal();
		
		request.setAttribute("shippingCost", shippingCost);
		request.setAttribute("orderTotal", total);
		
		RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
	    rd.forward(request, response);
	}

}
