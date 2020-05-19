

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "RecentVisitServlet", urlPatterns = "/recentVisit")
public class RecentVisitServlet extends HttpServlet  {
    private static final long serialVersionUID = 2L;

    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            Item toAdd = (Item) request.getAttribute("product");
            Queue<Item> viewHistory = (Queue<Item>) session.getAttribute("viewHistory");
            if(viewHistory == null) {
                session.setAttribute("viewHistory", new LinkedList<Item>());
                viewHistory = (Queue<Item>) session.getAttribute("viewHistory");
            }
            if (toAdd != null){
                if (viewHistory.size() >= 5){
                    viewHistory.remove();
                }
                viewHistory.add(toAdd);
            }
            request.setAttribute("viewHistory", viewHistory);
        }catch (Exception e){
            System.out.println(e.toString());
            // set reponse status to 500 (Internal Server Error)
            response.setStatus(500);
        }
    }

}
