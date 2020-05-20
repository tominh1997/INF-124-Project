
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.RoundingMode;
import java.text.DecimalFormat;
@WebServlet(name="CheckOutServlet", urlPatterns = {"/checkout"})
public class CheckOutServlet extends HttpServlet {
    private static final long serialVersionUID = 2L;
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try{
            HttpSession session = request.getSession();
            HashMap<String, Item> cart = (HashMap<String, Item>)session.getAttribute("cart");
            if(cart == null) {
                cart = new HashMap<String, Item>();
            }
            double total = 0;
            for (Item item: cart.values()){
                total += (item.getPrice() * item.getQuantity());
            }
            session.setAttribute("cart", cart);
            request.setAttribute("total", df2.format(total));
            request.setAttribute("cart_items", cart);
            request.getRequestDispatcher("/checkout.jsp").forward(request, response);
        } catch(Exception e) {
            // set reponse status to 500 (Internal Server Error)
            System.out.println(e.toString());
            response.setStatus(500);
        }
    }

}
