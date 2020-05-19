
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name="ProductsServlet", urlPatterns = {"/products"})
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		try {
			// Get a connection from dataSource
			Connection dbcon = DBConnection.initializeDatabase();

			// Construct a query with parameter represented by "?"
			String query = "SELECT * from chocoholic_db.products where type = ?";

			// Declare our statement
			PreparedStatement statement = dbcon.prepareStatement(query);
			// Set the parameter represented by "?" in the query to the id we get from url,
			// num 1 indicates the first "?" in the query
			statement.setString(1, type.toLowerCase());
			// Perform the query
			ResultSet rs = statement.executeQuery();
			ArrayList<Item> genericProducts = new ArrayList<Item>();
			// Iterate through each row of rs
			while (rs.next()) {
				Item product = new Item();
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setType(type);
				product.setPrice(rs.getDouble("price"));
				product.setImage1(product.convertToBase64(rs.getBlob("image1")));
				product.setImage2(product.convertToBase64(rs.getBlob("image2")));
				product.setImage3(product.convertToBase64(rs.getBlob("image3")));
				genericProducts.add(product);
			}
			//Set attribute to use variable in jsp
			rs.close();
			statement.close();
			dbcon.close();
			request.setAttribute("type", type);
			if(type.equals("White")) {
				request.setAttribute("whiteProducts", genericProducts);
			} else if(type.equals("Dark")){
				request.setAttribute("darkProducts", genericProducts);
			} else{
				request.setAttribute("milkProducts", genericProducts);
			}
			request.setAttribute("products", genericProducts);
			if(request.getParameter("forward").equals("true")){
				request.getRequestDispatcher("/products.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// set reponse status to 500 (Internal Server Error)
			System.out.println(e.toString());
			response.setStatus(500);
		}
	}

}
