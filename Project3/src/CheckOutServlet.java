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

@WebServlet(name="CheckOutServlet", urlPatterns = {"/checkout"})
public class CheckOutServlet extends HttpServlet {
    private static final long serialVersionUID = 2L;

    @Resource(name = "jdbc/moviedb")
    private DataSource dataSource;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name ");
        String phone = request.getParameter("phone");
        String product_id = request.getParameter("product_id");
        String product_name = request.getParameter("product_name");
        String quantity = request.getParameter("quantity");
        String total_amount = request.getParameter("total_amount");
        String adrress = request.getParameter("adrress");
        String shipping_method = request.getParameter("shipping_method");
        String credit_card_number = request.getParameter("credit_card_number");
        String CVV = request.getParameter("CVV");


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

            }


        } catch(Exception e) {
            // set reponse status to 500 (Internal Server Error)
            System.out.println(e.toString());
            response.setStatus(500);
        }
    }

}
