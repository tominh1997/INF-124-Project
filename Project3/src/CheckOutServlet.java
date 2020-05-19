
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

@WebServlet(name="CheckOutServlet", urlPatterns = {"/check-out"})
public class CheckOutServlet extends HttpServlet {
    private static final long serialVersionUID = 2L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try{
            HttpSession session = request.getSession();
            System.out.println(session.getId());

            ArrayList<Item> cart = (ArrayList<Item>)session.getAttribute("cart");
            if(cart == null) {
                session.setAttribute("cart", new ArrayList<>() );
                cart = (ArrayList<Item>) session.getAttribute("cart");
            }

            request.setAttribute("cart_items", cart);
            request.getRequestDispatcher("/checkout.jsp").forward(request, response);

        } catch(Exception e) {
            // set reponse status to 500 (Internal Server Error)
            System.out.println(e.toString());
            response.setStatus(500);
        }
    }

}
