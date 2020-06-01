
import com.fasterxml.jackson.core.type.TypeReference;
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
import java.util.List;

@WebServlet(name="ProductsServlet", urlPatterns = {"/products"})
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		try {
			ClientConfig config = new ClientConfig();

			Client client = ClientBuilder.newClient(config);

			WebTarget target = client.target(BaseURI.getBaseURI());


			String jsonResponse =
					target.path("chocoholic").path("products").path(type).
							request(). //send a request
							accept(MediaType.APPLICATION_JSON). //specify the media type of the response
							get(String.class); // use the get method and return the response as a string

			System.out.println(jsonResponse);

			ObjectMapper objectMapper = new ObjectMapper(); // This object is from the jackson library

			ArrayList<Item> genericProducts = objectMapper.readValue(jsonResponse, new TypeReference<ArrayList<Item>>(){});
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
