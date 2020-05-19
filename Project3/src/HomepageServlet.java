import javax.servlet.RequestDispatcher;
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

@WebServlet(name="HomepageServlet", urlPatterns = {"/homepage"})
public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = "white";
		try {
			RequestDispatcher rd= request.getRequestDispatcher("whiteProducts");
			rd.include(request, response);
			RequestDispatcher rd2= request.getRequestDispatcher("darkProducts");
			rd2.include(request, response);
			RequestDispatcher rd3= request.getRequestDispatcher("milkProducts");
			rd3.include(request, response);
			request.getRequestDispatcher("/homepage.jsp").forward(request, response);
		} catch (Exception e) {
			// set reponse status to 500 (Internal Server Error)
			System.out.println(e.toString());
			response.setStatus(500);
		}
	}

}
