import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AddCartServlet", urlPatterns = "/api/add-cart")
public class AddCartServlet extends HttpServlet {
    private static final long serialVersionUID = 2L;
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json"); // Response mime type
        JsonObject jsonObject = new JsonObject();
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String quantity = request.getParameter("quantity");
        double price = 0;

        try{
            HttpSession session = request.getSession();
            System.out.println(session.getId());

            ArrayList<Item> cart = (ArrayList<Item>)session.getAttribute("cart");
            if(cart == null) {
                session.setAttribute("cart", new ArrayList<>() );
                cart = (ArrayList<Item>) session.getAttribute("cart");
            }

            cart.add(new Item(name,id, price,quantity));
            System.out.println(cart.toString());
            jsonObject.addProperty("status", 200);
            out.write(jsonObject.toString());
            response.setStatus(200);

        }catch(Exception e){
            // write error message JSON object to output
            jsonObject.addProperty("message", e.getMessage());
            out.write(jsonObject.toString());
            e.printStackTrace();
            // set reponse status to 500 (Internal Server Error)
            response.setStatus(500);
        }
        out.close();
    }
}
