package shopping.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlaceOrderServlet
 */
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//We won't really create an order, simply skip that and tell user order has been created.
		request.getSession().setAttribute("message", "Your order has been created!");
		
		//After place the order, clear the shopping cart as we already put the items into an order.
		request.getSession().removeAttribute("shoppingCart");
		
		System.out.println(request.getContextPath());
		
		//This is a redirect, so browser will get an 302 code response and request the shop url.
		response.sendRedirect(request.getContextPath()+"/shop");
		
		
	}

}
