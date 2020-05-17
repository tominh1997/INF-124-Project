import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "RecentVisitServlet", urlPatterns = "/api/recent-visit")
public class RecentVisitServlet {
    private static final long serialVersionUID = 2L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json"); // Response mime type
        try{
            JsonObject jsonObject = new JsonObject();
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession();
            System.out.println(session.getId());


        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }


    }

}
