import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

@WebServlet(name="ProductDescriptionServlet", urlPatterns = {"/productDescription"})
public class ProductDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			Item product = new Item();
			ClientConfig config = new ClientConfig();
			Client client = ClientBuilder.newClient(config);
			WebTarget target = client.target(BaseURI.getBaseURI());
			String jsonResponse =
					target.path("chocoholic").path("products").path("product").path(id).
							request(). //send a request
							accept(MediaType.APPLICATION_JSON). //specify the media type of the response
							get(String.class); // use the get method and return the response as a string
			ObjectMapper objectMapper = new ObjectMapper();
			Item todo = objectMapper.readValue(jsonResponse, Item.class);
			System.out.println(jsonResponse);
			request.setAttribute("product", product);
			request.getRequestDispatcher("/recentVisit").include(request, response);
			request.getRequestDispatcher("/productDescription.jsp").forward(request, response);
		} catch (Exception e) {
			// set reponse status to 500 (Internal Server Error)
			System.out.println(e.toString());
			response.setStatus(500);
		}
	}

}
