package WebContent;

import WebContent.DBConnection;
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

@WebServlet("")
public class WhiteProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = "white";
		try {
			// Get a connection from dataSource
			Connection dbcon = DBConnection.initializeDatabase();

			// Construct a query with parameter represented by "?"
			String query = "SELECT * from chocoholic_db.products where type = ?";

			// Declare our statement
			PreparedStatement statement = dbcon.prepareStatement(query);
			// Set the parameter represented by "?" in the query to the id we get from url,
			// num 1 indicates the first "?" in the query
			statement.setString(1, type);
			request.setAttribute("test", new String("hello"));
			// Perform the query
			ResultSet rs = statement.executeQuery();
			ArrayList<Item> whiteProducts = new ArrayList<Item>();
			// Iterate through each row of rs
			while (rs.next()) {
				Item product = new Item();
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setType(type);
				product.setPrice(rs.getDouble("price"));
				product.setImage1(rs.getBlob("image1"));
				product.setImage2(rs.getBlob("image2"));
				product.setImage3(rs.getBlob("image3"));
				whiteProducts.add(product);
			}
			//Set attribute to use variable in jsp
			rs.close();
			statement.close();
			dbcon.close();
			request.setAttribute("whiteProducts", whiteProducts);
			request.getRequestDispatcher("homepage.jsp").forward(request, response);
		} catch (Exception e) {
			// set reponse status to 500 (Internal Server Error)
			response.setStatus(500);
		}
	}

}
