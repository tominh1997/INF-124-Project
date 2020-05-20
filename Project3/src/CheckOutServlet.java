import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

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


    @Resource(name = "jdbc/moviedb")
    private DataSource dataSource;
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name ");
        String phone = request.getParameter("phone");
        String adrress = request.getParameter("adrress");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String zipCode = request.getParameter("zipCode");
        String tax = request.getParameter("tax");
        String shipping = request.getParameter("shipping method");
        String card = request.getParameter("cardnum");
        String cvv = request.getParameter("cvv");

        double item_subtotal =0;
        int order_number = 0;
        double total_before_tax =0;
        double grand_total =0;
        try{
            Connection dbconMovies = dataSource.getConnection();
            HttpSession session = request.getSession();
            HashMap<String, Item> cart = (HashMap<String, Item>)session.getAttribute("cart");
            String query = "INSERT INTO orders VALUES (NULL, ? , ? , ?, ? , ?, ? , ?, ? , ?, ?  );";
            for(Item it : cart.values()){
                PreparedStatement statement = dbconMovies.prepareStatement(query);
                statement.setString(1,name);
                statement.setString(2, phone);
                statement.setInt(3,Integer.valueOf(it.id));
                statement.setString(4, it.name);
                statement.setInt(5,it.quantity);
                statement.setDouble(6, it.quantity * it.price * Double.valueOf(tax) );
                item_subtotal += it.quantity * it.price;

                statement.setString(7,adrress + city + state + country + zipCode);
                statement.setInt(8,Integer.valueOf(shipping));
                statement.setString(9,card);
                statement.setInt(10, Integer.valueOf(cvv));

                System.out.println(statement);

                order_number = statement.executeUpdate();
                statement.close();


            }

            request.setAttribute("name", name);
            request.setAttribute("shipping", shipping);
            request.setAttribute("tax", tax);
            request.setAttribute("item_subtotal", item_subtotal);
            request.setAttribute("order_number", order_number);
            request.setAttribute("shipping", shipping);
            total_before_tax = item_subtotal + Double.valueOf(shipping);
            request.setAttribute("total_before_tax", total_before_tax);
            request.setAttribute("grand_total", grand_total* Double.valueOf(tax));



            request.setAttribute("cart_items", cart.values());
            request.getRequestDispatcher("/confirmation.jsp").forward(request, response);

        } catch(Exception e) {
            // set reponse status to 500 (Internal Server Error)
            System.out.println(e.toString());
            response.setStatus(500);
        }
    }

}
