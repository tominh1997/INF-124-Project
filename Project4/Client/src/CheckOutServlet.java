import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.text.DecimalFormat;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

@WebServlet(name="CheckOutServlet", urlPatterns = {"/checkout"})
public class CheckOutServlet extends HttpServlet {
    private static final long serialVersionUID = 2L;


    private static DecimalFormat df2 = new DecimalFormat("#.##");
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String zipCode = request.getParameter("zipCode");
        String shipping = request.getParameter("shipping method");
        String card = request.getParameter("cardnum");
        String cvv = request.getParameter("cvv");


        try{
            HttpSession session = request.getSession();
            HashMap<String, Item> cart = (HashMap<String, Item>)session.getAttribute("cart");

            ClientConfig config = new ClientConfig();

            Client client = ClientBuilder.newClient(config);

            WebTarget target = client.target(BaseURI.getBaseURI());

            FormDataMultiPart part = new FormDataMultiPart();
            //part.field;


            String jsonResponse =
                    target.path("v1").path("api").path("chocoholic").
                            request(). //send a request
                            accept(MediaType.APPLICATION_JSON). //specify the media type of the response
                            post(String.class); // use the get method and return the response as a string

            System.out.println(jsonResponse);

            ObjectMapper objectMapper = new ObjectMapper(); // This object is from the jackson library


            HashMap<String, String> responseValue = objectMapper.readValue(jsonResponse, new TypeReference< HashMap<String, String> >(){});


            request.setAttribute("name", name);
            request.setAttribute("shipping", shipping);
            request.setAttribute("tax", responseValue.get("tax"));
            request.setAttribute("item_subtotal", responseValue.get("item_subtotal"));
            request.setAttribute("order_number", responseValue.get("order_number"));
            request.setAttribute("total_before_tax", responseValue.get("total_before_tax"));
            request.setAttribute("grand_total", responseValue.get("grand_total"));
            request.setAttribute("cart_items", cart);


            request.getRequestDispatcher("/confirmation.jsp").forward(request, response);

        } catch(Exception e) {
            // set reponse status to 500 (Internal Server Error)
            System.out.println(e.toString());
            response.setStatus(500);
        }
    }

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
