import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
			RequestDispatcher rd= request.getRequestDispatcher("products?type=White&forward=false");
			rd.include(request, response);
			RequestDispatcher rd2= request.getRequestDispatcher("products?type=Dark&forward=false");
			rd2.include(request, response);
			RequestDispatcher rd3= request.getRequestDispatcher("products?type=Milk&forward=false");
			rd3.include(request, response);
			RequestDispatcher rd4= request.getRequestDispatcher("recentVisit");
			rd4.include(request, response);
			request.getRequestDispatcher("/homepage.jsp").forward(request, response);
		} catch (Exception e) {
			// set reponse status to 500 (Internal Server Error)
			System.out.println(e.toString());
			response.setStatus(500);
		}
	}

}
