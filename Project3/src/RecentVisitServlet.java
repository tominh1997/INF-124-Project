package src;

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


@WebServlet(name = "RecentVisitServlet", urlPatterns = "/api/recent-visit")
public class RecentVisitServlet extends HttpServlet  {
    private static final long serialVersionUID = 2L;

    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json"); // Response mime type
        JsonObject jsonObject = new JsonObject();
        PrintWriter out = response.getWriter();
        try{
            Gson g = new Gson();

            HttpSession session = request.getSession();
            System.out.println(session.getId());
            Queue<Item> history = (Queue<Item>)session.getAttribute("items-history");
            if(history == null) {
                session.setAttribute("items-history", new LinkedList<>() );
                history = (Queue<Item>) session.getAttribute("items-history");
            }
            history.add(new Item("white chocolate","1"));
            history.add(new Item("dark chocolate","2"));

            Map<String, Item> hm = new HashMap<>();
            for(Item i : history){
                hm.put(i.getId(), i);
            }

            jsonObject.addProperty("items-history", g.toJson(hm.values()));
            out.write(jsonObject.toString().replace("\\", "").replace("\"[{", "[{").replace("}]\"", "}]"));
            response.setStatus(200);
        }catch (Exception e){
            // write error message JSON object to output
            jsonObject.addProperty("message", e.getMessage());
            out.write(jsonObject.toString());
            e.printStackTrace();
            // set reponse status to 500 (Internal Server Error)
            response.setStatus(500);
        }
        out.close();

    }

}
