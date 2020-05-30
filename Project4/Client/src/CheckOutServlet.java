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
import java.util.HashMap;
import java.text.DecimalFormat;
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

        float item_subtotal =0;
        int order_number = 0;
        float total_before_tax =0;
        float grand_total =0;
        try{
            Connection dbcon = DBConnection.initializeDatabase();
            HttpSession session = request.getSession();
            HashMap<String, Item> cart = (HashMap<String, Item>)session.getAttribute("cart");
            String query = "SELECT * FROM chocoholic_db.tax_rates WHERE ZipCode=?";
            PreparedStatement statement1 = dbcon.prepareStatement(query);
            statement1.setInt(1, Integer.parseInt(zipCode));
            ResultSet rs = statement1.executeQuery();
            rs.next();
            double tax = rs.getDouble("CombinedRate");
            String query1 = "INSERT INTO orders VALUES (NULL, ? , ? , ?, ? , ?, ? , ?, ? , ?, ? )";
            for(Item it : cart.values()){
                PreparedStatement statement = dbcon.prepareStatement(query1);
                statement.setString(1,name);
                statement.setString(2, phone);
                statement.setInt(3,Integer.valueOf(it.id));
                statement.setString(4, it.name);
                statement.setInt(5,it.quantity);
                statement.setDouble(6, it.quantity * it.price * Double.valueOf(tax) );
                item_subtotal += (it.quantity * it.price);

                statement.setString(7,address + " " + city + " " + state + " " + country + " " + zipCode);
                statement.setInt(8,Integer.valueOf(shipping));
                statement.setString(9,card);
                statement.setInt(10, Integer.valueOf(cvv));

                order_number = statement.executeUpdate();
                statement.close();

            }
            statement1.close();
            rs.close();
            dbcon.close();
            request.setAttribute("name", name);
            request.setAttribute("shipping", shipping);
            request.setAttribute("tax", tax);
            request.setAttribute("item_subtotal", df2.format(item_subtotal));
            request.setAttribute("order_number", order_number);
            request.setAttribute("shipping", shipping);
            total_before_tax = (float) (item_subtotal + Float.valueOf(shipping));
            grand_total = (float) (total_before_tax * tax/100.0 + total_before_tax);
            request.setAttribute("total_before_tax", df2.format(total_before_tax));
            request.setAttribute("grand_total", df2.format(grand_total));



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
